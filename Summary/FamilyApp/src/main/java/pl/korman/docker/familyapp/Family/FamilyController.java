package pl.korman.docker.familyapp.Family;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.korman.docker.familyapp.Family.DTO.FamilyCreateDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyMemberRestInputDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyOutputDTO;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class FamilyController {
    @NonNull
    private FamilyService service;

    @Value("${mymemberport}")
    private String serverport;
    @Value("${mymemberdomain}")
    private String mydomain;

    //do zrobienia
    @GetMapping("/getfamily/{familyid}")
    public ResponseEntity<FamilyOutputDTO> getFamily(@PathVariable("familyid") int familyid){
        //GetFamily
        Optional<Family> family = service.getFamilyById(familyid);
        if(family.isPresent()){
            //SerachMembers
            RestTemplate restTemplate = new RestTemplate();
            //url błędny
            ResponseEntity<FamilyMemberRestInputDTO[]> exchange = restTemplate.exchange("http://{mydomain}:{serverport}/serachfamilymember/{id}",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    FamilyMemberRestInputDTO[].class,
                    mydomain,
                    serverport,
                    familyid);
                List<FamilyMemberRestInputDTO> familymembers = Arrays.stream(exchange.getBody()).collect(Collectors.toList());
                return ResponseEntity.ok(service.getFamilyOutputDTO(family.get(), familymembers));
        }
        return ResponseEntity.notFound().build();
    }

    //do zrobienia
    @PostMapping("/createfamily")
    public void createFamily(@RequestBody FamilyCreateDTO dto){
        service.createNewFamily(dto);
    }

}
