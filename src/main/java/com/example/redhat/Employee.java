package com.example.redhat;

public class Employee {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String invalidUser;

    public Employee(long id, String firstName, String lastName, String invalidUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.invalidUser = invalidUser;
    }

    public Employee(long id, String invalidUser) {
        this.id = id;
        this.invalidUser = invalidUser;
        firstName = null;
        lastName = null;
    }

    public Employee(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        invalidUser = null;
    }



    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInvalidUser() {
        return invalidUser;
    }
}
