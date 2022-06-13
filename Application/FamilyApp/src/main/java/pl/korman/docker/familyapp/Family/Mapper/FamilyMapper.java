package pl.korman.docker.familyapp.Family.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.korman.docker.familyapp.Family.DTO.FamilyCreateDTO;
import pl.korman.docker.familyapp.Family.Family;

@Mapper
public interface FamilyMapper {
    FamilyMapper INSTANCE = Mappers.getMapper( FamilyMapper.class );
    Family createDtoToFamily(FamilyCreateDTO dto);

}
