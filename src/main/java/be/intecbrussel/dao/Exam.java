package be.intecbrussel.dao;

import java.time.LocalDate;
import java.util.List;

public class Exam {

    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private int weight;
    private int total;
    private Module module;
    private Exam examGroup;
    private List<Exam> subExams;


}
