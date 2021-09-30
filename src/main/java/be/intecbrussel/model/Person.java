package be.intecbrussel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String familyName;
    private Gender gender;

    @ManyToOne
    private Course courseActive;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person__course_history", joinColumns = @JoinColumn(name = "person_id"))
    private List<Course> courseHistory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public Course getCourseActive() {
        return courseActive;
    }

    public void setCourseActive(Course course) {
        this.courseActive = course;
    }

    public List<Course> getCourseHistory() {
        return courseHistory;
    }

    public void setCourseHistory(List<Course> courseHistory) {
        this.courseHistory = courseHistory;
    }
}
