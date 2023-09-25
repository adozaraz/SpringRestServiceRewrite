package services;

import entities.Student;
import entities.StudentDTO;
import mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StudentRepository;

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

    public StudentDTO read(UUID uuid) {
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
