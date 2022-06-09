package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class FamilyMemberController {
    private FamilyMemberService service;

    @GetMapping("/SerachFamilyMember/{familyid}")
    public Iterable<FamilyMember> SerachFamilyMember(@PathVariable("familyid") int familyid){
        return service.findFamilyMemberByFamilyName(familyid);
    }

    @PostMapping("/CreateFamilyMember")
    public void CreateFamilyMember(@RequestBody FamilyMember familyMember){
        service.createNewMember(familyMember);
    }
}
