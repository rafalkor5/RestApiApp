package pl.korman.docker.familyapp.Family;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.korman.docker.familyapp.Family.DTO.FamilyCreateDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyOutputDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FamilyController {
    @NonNull
    private FamilyService service;

    @GetMapping("/family/{familyid}")
    public ResponseEntity<FamilyOutputDTO> getFamily(@PathVariable("familyid") int familyid) {
        return service.getFamilyByID(familyid);
    }

    @PostMapping("/family")
    public ResponseEntity<?> createFamily(@RequestBody @Valid FamilyCreateDTO dto){
        return service.createNewFamily(dto);
    }

}
