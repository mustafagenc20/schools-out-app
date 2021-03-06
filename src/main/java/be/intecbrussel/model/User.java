package be.intecbrussel.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private String login;
    private String passwordhash;
    private boolean active;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id")
    @OneToOne
//    @MapsId
    private Person person;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
