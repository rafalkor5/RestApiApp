package pl.korman.docker.familyapp.Family;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.korman.docker.familyapp.Family.DTO.FamilyCreateDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyOutputDTO;

@RestController
@RequiredArgsConstructor
public class FamilyController {
    @NonNull
    private FamilyService service;

    @GetMapping("/getfamily/{familyid}")
    public ResponseEntity<FamilyOutputDTO> getFamily(@PathVariable("familyid") int familyid) {
        return service.getFamilyByID(familyid);
    }

    @PostMapping("/createfamily")
    public ResponseEntity<?> createFamily(@RequestBody FamilyCreateDTO dto){
        return service.createNewFamily(dto);
    }

}
