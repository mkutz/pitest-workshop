package de.assertagile.workshop.pitest;

interface UserRepository {

    void saveUser(final UserEntity user);

    UserEntity findUserByUserName(final String userName);
}
