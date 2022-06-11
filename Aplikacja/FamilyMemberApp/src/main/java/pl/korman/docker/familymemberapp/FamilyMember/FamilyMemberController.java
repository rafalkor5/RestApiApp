package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;

import javax.validation.Valid;
import java.net.URI;


@RestController
@AllArgsConstructor
public class FamilyMemberController {
    private FamilyMemberService service;


    @GetMapping("/familymember/{familyid}")
    public ResponseEntity<Iterable<FamilyMember>> serachFamilyMember(@PathVariable("familyid") int familyid){
        return ResponseEntity.ok(service.findFamilyMemberByFamilyId(familyid));
    }


    @PostMapping("/familymember")
    public ResponseEntity<FamilyMember> createFamilyMember(@RequestBody @Valid FamilyMember_CreateDTO input){
        var familyMember = service.createNewMember(input);
        return ResponseEntity.created(URI.create("/" + familyMember.getId() )).body(familyMember);
    }
}
