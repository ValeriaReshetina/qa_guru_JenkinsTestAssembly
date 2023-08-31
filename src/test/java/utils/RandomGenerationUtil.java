package utils;


import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomGenerationUtil {

    Faker faker = new Faker();
    Date userBirthday = faker.date().birthday(18, 80);

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public String getUserGender() {
        String[] gender = {"Male", "Female", "Other"};
        return new Faker().options().option(gender);
    }

    public String getUserMobileNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getUserBirthDay() {
        return (new SimpleDateFormat("dd", Locale.ENGLISH)).format(userBirthday);
    }

    public String getUserBirthMonth() {
        return (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(userBirthday);
    }

    public String getUserBirthYear() {
        return (new SimpleDateFormat("y", Locale.ENGLISH)).format(userBirthday);
    }

    public String getUserSubject() {
        String[] subject = {"English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies",
                "Arts", "History", "Maths", "Accounting", "Physics", "Biology", "Hindi", "Civics"};
        return new Faker().options().option(subject);
    }

    public String getUserHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobby);
    }

    public String getUserAddress() {
        return faker.address().fullAddress();
    }

    public String getUserState() {
        String[] userState = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(userState);
    }

    public String getUserCity(String state) {
        switch (state) {
            case "NCR": {
                String[] ncrCity = {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(ncrCity);
            }
            case "Uttar Pradesh": {
                String[] uttarPradeshCity = {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(uttarPradeshCity);
            }
            case "Haryana": {
                String[] haryanaCity = {"Karnal", "Panipat"};
                return new Faker().options().option(haryanaCity);
            }
            case "Rajasthan": {
                String[] rajasthanCity = {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(rajasthanCity);
            }
        }
        return null;
    }
}
