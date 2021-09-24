package be.intecbrussel.dao;

public class Person {

    private Integer id;
    private String firstname;
    private String familyname;
    private Gender gender;
    private Course course;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
