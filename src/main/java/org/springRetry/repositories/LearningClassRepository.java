package org.springRetry.repositories;

import org.springRetry.entities.LearningClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LearningClassRepository extends CrudRepository<LearningClass, UUID> {
}
