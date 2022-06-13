package pl.korman.docker.familyapp.Family.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.korman.docker.familyapp.Family.DTO.FamilyMemberRestInputDTO;
import pl.korman.docker.familyapp.Family.DTO.FamilyOutputDTO;
import pl.korman.docker.familyapp.Family.Family;

import java.util.List;

@Mapper
public interface FamilyOutputMapper {
    FamilyOutputMapper INSTANCE = Mappers.getMapper( FamilyOutputMapper.class );

    @Mapping(source="memberInput", target = "familyMembersDtoList")
    FamilyOutputDTO familyAndFamilyMembersToOutputDto(Family family, List<FamilyMemberRestInputDTO> memberInput);
}
