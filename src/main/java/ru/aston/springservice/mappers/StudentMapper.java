package ru.aston.springservice.mappers;

import ru.aston.springservice.entities.Student;
import ru.aston.springservice.entities.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { LearningClassMapper.class })
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    StudentDTO studentToStudentDTO(Student student);
    Student studentDTOToStudent(StudentDTO studentDTO);
}
