package ru.aston.springservice.services;

import ru.aston.springservice.entities.Student;
import ru.aston.springservice.entities.StudentDTO;
import ru.aston.springservice.mappers.StudentMapper;
import org.springframework.stereotype.Service;
import ru.aston.springservice.repositories.StudentRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDTO create(StudentDTO studentDTO) {
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        return studentMapper.studentToStudentDTO(this.studentRepository.save(student));
    }

    public StudentDTO read(Long uuid) {
        Optional<Student> student = studentRepository.findById(uuid);
        return student.map(stud -> studentMapper.studentToStudentDTO(stud)).orElse(null);
    }

    public StudentDTO update(StudentDTO studentDTO) {
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        return studentMapper.studentToStudentDTO(this.studentRepository.save(student));
    }

    public void delete(StudentDTO studentDTO) {
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        studentRepository.delete(student);
    }
}
