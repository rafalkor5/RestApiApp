package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;


@RestController
@AllArgsConstructor
public class FamilyMemberController {
    private FamilyMemberService service;


    @GetMapping("/serachfamilymember/{familyid}")
    public ResponseEntity<Iterable<FamilyMember>> SerachFamilyMember(@PathVariable("familyid") int familyid){
        return service.findFamilyMemberByFamilyName(familyid);
    }


    @PostMapping("/createfamilymember")
    public ResponseEntity<?> CreateFamilyMember(@RequestBody FamilyMember_CreateDTO input){
        return service.createNewMember(input);
    }
}
