package mappers;

import entities.LearningClass;
import entities.LearningClassDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface LearningClassMapper {
    LearningClassMapper INSTANCE = Mappers.getMapper( LearningClassMapper.class );

    LearningClassDTO learningClassToLearningClassDTO(LearningClass learningClass);
    LearningClass learningClassDTOToLearningClass(LearningClassDTO learningClassDTO);
}
