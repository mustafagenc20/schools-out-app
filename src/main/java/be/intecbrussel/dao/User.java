package be.intecbrussel.dao;

import javax.persistence.OneToOne;

public class User {

    private String login;
    private String passwordhash;
    private boolean active;
    @OneToOne
    private Person person;


}
