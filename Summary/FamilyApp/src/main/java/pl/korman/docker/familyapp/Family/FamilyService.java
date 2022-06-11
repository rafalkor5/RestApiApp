package pl.korman.docker.familyapp.Family;



import com.google.gson.Gson;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.korman.docker.familyapp.Family.DTO.FamilyCreateDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyMemberRestInputDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyMemberRestOutputDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyOutputDTO;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FamilyService {
    @NonNull
    private FamilyRepo familyRepo;

    @Value("${mymemberport}")
    private String serverport;
    @Value("${mymemberdomain}")
    private String mymemberdomain;

    /**
     * It creates a new family and returns the family with id and the family members with id's.
     *
     * @param input The input object is object created from json@GetMapping.
     * @return A ResponseEntity with a status code of 201 (Created) and the new Family in body or ResponseEntity with status code of 400 (Bad Request).
     */
    public ResponseEntity<FamilyOutputDTO> createNewFamily(FamilyCreateDTO input){
        //validate family
        if(validateFamilyData(input)) {
            //Save Family
            var familyReturnFromSave = familyRepo.save(new Family(
                    input.getFamilyName(),
                    input.getNrOfAdults(),
                    input.getNrOfChildren(),
                    input.getNrOfInfants()
            ));
            //Get FamilyMembers from input and  POST (CreateMember)
            List<FamilyMemberRestInputDTO> returnFromPost = postFamilyMember(getFamilyMembersFrom_input(input, familyReturnFromSave.getId()));
            //Return Family
            FamilyOutputDTO newFamily = new FamilyOutputDTO(
                    familyReturnFromSave.getId(),
                    familyReturnFromSave.getFamilyName(),
                    familyReturnFromSave.getNrOfAdults(),
                    familyReturnFromSave.getNrOfChildren(),
                    familyReturnFromSave.getNrOfInfants(),
                    returnFromPost
            );
            return ResponseEntity.created(URI.create("/" + newFamily.getId())).body(newFamily);
        }
        return ResponseEntity.badRequest().build();
    }


    /**
     * > It validates the number of adults, children and infants in a family
     *
     * @param input The input object is object created from json@GetMapping .
     * @return If condition is true it will be return true.
     */
    private boolean validateFamilyData(FamilyCreateDTO input){
        int nrOfAdults = 0;
        int nrOfChildren = 0;
        int nrOfInfants = 0;

        for(var members: input.getFamilyMembersList()){
            if(members.getAge() >= 0 && members.getAge() <= 3){
                nrOfInfants++;
            }else if(members.getAge() >= 4 && members.getAge() <= 15){
                nrOfChildren++;
            }else if(members.getAge() >= 16){
                nrOfAdults++;
            }
        }

        return nrOfAdults == input.getNrOfAdults() && nrOfChildren == input.getNrOfChildren() && nrOfInfants == input.getNrOfInfants();
    }

    /**
     * It takes a FamilyCreateDTO and an id from save family,
     * and returns a list of FamilyMemberRestOutputDTOs for Post
     *
     * @param creationDTO The input DTO that contains the family members list
     * @param id The id of the family from save family.
     * @return A list of FamilyMemberRestOutputDTO objects.
     */
    private List<FamilyMemberRestOutputDTO> getFamilyMembersFrom_input(final FamilyCreateDTO creationDTO, final int id) {
        return creationDTO.getFamilyMembersList().stream()
                .map(dtoinput -> new FamilyMemberRestOutputDTO(id, dtoinput.getGivenName(), dtoinput.getFamilyName(), dtoinput.getAge()))
                .toList();
    }

    /**
     * It takes a list of FamilyMemberRestOutputDTO objects, converts them to JSON, sends them to the family member
     * controller, and returns a list of FamilyMemberRestInputDTO objects
     *
     * @param familyMemberOutputList This is the list of FamilyMemberRestOutputDTO objects that we got from the
     * getFamilyMembersFrom_input() method.
     * @return A list of FamilyMemberRestInputDTO objects.
     */
    private List<FamilyMemberRestInputDTO> postFamilyMember(final List<FamilyMemberRestOutputDTO> familyMemberOutputList) {
        return familyMemberOutputList.stream()
                .map(familymember ->
                {
                    Gson gson = new Gson();
                    String requestJson = gson.toJson(familymember);

                    RestTemplate restTemplate = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    HttpEntity<String> request = new HttpEntity<>(requestJson,headers);
                    return restTemplate.exchange("http://{mymemberdomain}:{serverport}/familymember",
                            HttpMethod.POST,
                            request,
                            FamilyMemberRestInputDTO.class,
                            mymemberdomain,
                            serverport);
                })
                .map(HttpEntity::getBody)
                .collect(Collectors.toList());
    }

    /**
     * > We are using the RestTemplate to call the FamilyMemberService to get the family members
     *
     * @return A FamilyOutputDTO object
     */
    public ResponseEntity<FamilyOutputDTO> getFamilyByID(int familyid){
        Optional<Family> family = familyRepo.findById(familyid);
        if(family.isPresent()){
            //SerachMembers
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<FamilyMemberRestInputDTO[]> exchange = restTemplate.exchange("http://{mymemberdomain}:{serverport}/familymember/{id}",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    FamilyMemberRestInputDTO[].class,
                    mymemberdomain,
                    serverport,
                    familyid);
            List<FamilyMemberRestInputDTO> familymembers = Arrays.stream(exchange.getBody()).collect(Collectors.toList());
            //Return Family
            return ResponseEntity.ok(getFamilyOutputDTO(family.get(), familymembers));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * It takes a family and a list of family members and returns a family output DTO
     *
     * @param family the family object that we want to convert to a DTO
     * @param members a list of FamilyMemberRestInputDTO objects
     * @return A FamilyOutputDTO object.
     */
    private FamilyOutputDTO getFamilyOutputDTO(Family family, List<FamilyMemberRestInputDTO> members){
        return new FamilyOutputDTO(
                family.getId(),
                family.getFamilyName(),
                family.getNrOfAdults(),
                family.getNrOfChildren(),
                family.getNrOfInfants(),
                members
        );
    }
}
