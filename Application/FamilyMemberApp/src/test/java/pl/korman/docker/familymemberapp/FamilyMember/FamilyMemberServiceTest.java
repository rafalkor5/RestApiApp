package pl.korman.docker.familymemberapp.FamilyMember;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FamilyMemberServiceTest {

    @Mock
    private FamilyMemberRepo mockrepo;

    @Test
    void findFamilyMemberByFamilyId(){
        //given
        List<FamilyMember> membersList = new ArrayList<>();
        membersList.add(new FamilyMember(1,"Mateusz","Kowalski",15));
        membersList.add(new FamilyMember(1,"Andrzej","Kowalski",10));
        given(mockrepo.findAllByFamilyId(1)).willReturn(membersList);
        var service = new FamilyMemberService(mockrepo);
        //when
        List<FamilyMember> result = service.findFamilyMemberByFamilyId(1);
        //then
        assertThat(result).hasSize(2);

    }

    @Test
    void createNewMember(){
        //given
        var inputmember = new FamilyMember_CreateDTO(1,"Mateusz","Kowalski",15);
        var member = new FamilyMember(1,"Mateusz","Kowalski",15);
        given(mockrepo.save(any(FamilyMember.class))).willReturn(member);
        var service = new FamilyMemberService(mockrepo);
        //when
        var returnmember = service.createNewMember(inputmember);
        //then
        assertThat(returnmember).isEqualTo(member);

    }
}
