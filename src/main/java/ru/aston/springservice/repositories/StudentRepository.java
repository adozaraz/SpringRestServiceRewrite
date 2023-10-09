package ru.aston.springservice.repositories;

import ru.aston.springservice.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
