package pl.korman.docker.familymemberapp.FamilyMember;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;

@RestController
@AllArgsConstructor
public class FamilyMemberController {
    private FamilyMemberService service;

    @GetMapping("/serachfamilymember/{familyid}")
    public Iterable<FamilyMember> SerachFamilyMember(@PathVariable("familyid") int familyid){
        return service.findFamilyMemberByFamilyName(familyid);
    }

    @PostMapping("/createfamilymember")
    public void CreateFamilyMember(@RequestBody FamilyMember_CreateDTO dto){
        service.createNewMember(dto);
    }
}
