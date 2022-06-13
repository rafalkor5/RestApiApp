package pl.korman.docker.familymemberapp.FamilyMember.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.korman.docker.familymemberapp.FamilyMember.DTO.FamilyMember_CreateDTO;
import pl.korman.docker.familymemberapp.FamilyMember.FamilyMember;

@Mapper
public interface FamilyMemberMapper {
    FamilyMemberMapper INSTANCE = Mappers.getMapper(FamilyMemberMapper.class);
    FamilyMember DtoToFamilyMember(FamilyMember_CreateDTO dto);
}
