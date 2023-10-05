package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class LearningClass {
    @Id
    @GeneratedValue
    private UUID learningClassId;

    private String title;
    private String description;

    @ManyToMany(mappedBy = "learningClasses")
    private Set<Student> attendingStudents = new HashSet<>();

    public UUID getLearningClassId() {
        return learningClassId;
    }

    public void setLearningClassId(UUID learningClassId) {
        this.learningClassId = learningClassId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getAttendingStudents() {
        return attendingStudents;
    }

    public void setAttendingStudents(Set<Student> attendingStudents) {
        this.attendingStudents = attendingStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearningClass that = (LearningClass) o;
        return Objects.equals(learningClassId, that.learningClassId) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(attendingStudents, that.attendingStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(learningClassId, title, description, attendingStudents);
    }
}
