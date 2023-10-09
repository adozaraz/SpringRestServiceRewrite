package ru.aston.springservice.services;

import ru.aston.springservice.entities.LearningClass;
import ru.aston.springservice.entities.LearningClassDTO;
import ru.aston.springservice.mappers.LearningClassMapper;
import org.springframework.stereotype.Service;
import ru.aston.springservice.repositories.LearningClassRepository;

import java.util.Optional;

@Service
public class LearningClassService {
    private LearningClassRepository learningClassRepository;

    private LearningClassMapper learningClassMapper;

    public LearningClassService(LearningClassRepository learningClassRepository, LearningClassMapper learningClassMapper) {
        this.learningClassRepository = learningClassRepository;
        this.learningClassMapper = learningClassMapper;
    }

    public LearningClassDTO create(LearningClassDTO learningClassDTO) {
        LearningClass learningClass = learningClassMapper.learningClassDTOToLearningClass(learningClassDTO);
        return learningClassMapper.learningClassToLearningClassDTO(learningClassRepository.save(learningClass));
    }

    public LearningClassDTO read(Long uuid) {
        Optional<LearningClass> learningClass = learningClassRepository.findById(uuid);
        return learningClass.map(aClass -> learningClassMapper.learningClassToLearningClassDTO(aClass)).orElse(null);
    }

    public LearningClassDTO update(LearningClassDTO learningClassDTO) {
        LearningClass learningClass = learningClassMapper.learningClassDTOToLearningClass(learningClassDTO);
        return learningClassMapper.learningClassToLearningClassDTO(learningClassRepository.save(learningClass));
    }

    public void delete(LearningClassDTO learningClass) {
        LearningClass toDelete = learningClassMapper.learningClassDTOToLearningClass(learningClass);
        this.learningClassRepository.delete(toDelete);
    }

}
