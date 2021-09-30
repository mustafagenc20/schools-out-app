package be.intecbrussel.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length = 2000)
    private String description;
    private LocalDate date;
    private int weight;
    private int total;
    @ManyToOne
    private Module module;
    @ManyToOne(fetch = FetchType.EAGER)
    private Exam examGroup;
    @OneToMany
    private List<Exam> subExam;
//    @OneToMany(mappedBy = "exam")
//    private List<Grade> grades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Exam getExamGroup() {
        return examGroup;
    }

    public void setExamGroup(Exam examGroup) {
        this.examGroup = examGroup;
    }

    public List<Exam> getSubExam() {
        return subExam;
    }

    public void setSubExam(List<Exam> subExam) {
        this.subExam = subExam;
    }

//    public List<Grade> getGrades() {
//        return grades;
//    }
//
//    public void setGrades(List<Grade> grades) {
//        this.grades = grades;
//    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", weight=" + weight +
                ", total=" + total +
                ", module=" + module +
                '}';
    }
}
