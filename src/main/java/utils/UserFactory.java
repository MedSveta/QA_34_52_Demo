package utils;

import dto.User;
import net.datafaker.Faker;

public class UserFactory {
    static Faker faker = new Faker();

    public static User positiveUser(){
        return User.builder()
                .userName(faker.internet().emailAddress())
                .password("Qwerty123!")
                .build();
    }
}
