package com.sofka.utils;

import com.sofka.models.UserData;
import java.util.Random;
import java.util.UUID;

public class DataGenerator {

    private static final Random random = new Random();

    public static UserData generateRandomUser() {
        String uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        return UserData.builder()
                .firstName("Test")
                .lastName("User")
                .address("123 Test Street")
                .city("Test City")
                .state("CA")
                .zipCode("12345")
                .phone("5551234567")
                .ssn(generateRandomSSN())
                .username("usr" + uniqueId)
                .password("Test@123")
                .build();
    }

    private static String generateRandomSSN() {
        return String.format("%03d%02d%04d",
                random.nextInt(900) + 100,
                random.nextInt(90) + 10,
                random.nextInt(9000) + 1000);
    }
}
