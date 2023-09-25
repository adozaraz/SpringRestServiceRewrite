package mappers;

import entities.Student;
import entities.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { LearningClassMapper.class })
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    StudentDTO studentToStudentDTO(Student student);
    Student studentDTOToStudent(StudentDTO studentDTO);
}
