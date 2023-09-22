package services;

import entities.LearningClass;
import entities.LearningClassDTO;
import mappers.LearningClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LearningClassRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LearningClassService {
    @Autowired
    private LearningClassRepository learningClassRepository;

    @Autowired
    private LearningClassMapper learningClassMapper;

    public LearningClassDTO create(LearningClassDTO learningClassDTO) {
        LearningClass learningClass = learningClassMapper.learningClassDTOToLearningClass(learningClassDTO);
        return learningClassMapper.learningClassToLearningClassDTO(learningClassRepository.save(learningClass));
    }

    public LearningClassDTO read(UUID uuid) {
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
