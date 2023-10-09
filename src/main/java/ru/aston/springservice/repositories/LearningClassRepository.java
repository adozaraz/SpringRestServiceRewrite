package ru.aston.springservice.repositories;

import ru.aston.springservice.entities.LearningClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LearningClassRepository extends CrudRepository<LearningClass, Long> {
}
