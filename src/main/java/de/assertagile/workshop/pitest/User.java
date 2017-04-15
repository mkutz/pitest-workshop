package de.assertagile.workshop.pitest;

import java.time.LocalDate;

public class User {

    private final String userName;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    public User(final String userName, final String firstName, final String lastName, final LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException();
        }
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isOfAge() {
        return this.birthday.isBefore(LocalDate.now().minusYears(18)) ||
                this.birthday.isEqual(LocalDate.now().minusYears(18));
    }

    public UserEntity toEntity() {
        return new UserEntity(userName, firstName, lastName, birthday);
    }
}
