package tests;


import checks.RegistrationPageChecks;
import com.demoqa.utils.Fields;
import components.CalendarComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends RemoteTestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageChecks registrationChecks = new RegistrationPageChecks();
    CalendarComponent calendarComponent = new CalendarComponent();
    Fields fields = new Fields();


    @DisplayName("Registration test for remote launch in Jenkins")
    @Tag("remote")
    @Test
    void userRegistrationTest() {
        step("Page opening", () -> {
            registrationPage.openPage().removeBanner();
        });

        step("Filling out the registration form", () -> {
            registrationPage.
                    setFirstName(fields.userFirstName).
                    setLastName(fields.userLastName).
                    setUserEmail(fields.userEmail).
                    setGender(fields.userGender).
                    setUserMobileNumber(fields.userMobileNumber);

            calendarComponent.
                    setBirthDate(fields.userBirthDay, fields.userBirthMonth, fields.userBirthYear);

            registrationPage.
                    setSubjects(fields.userSubject).
                    setHobbies(fields.userHobby).
                    uploadFile(fields.userPhoto).
                    setAddress(fields.userAddress).
                    selectState(fields.userState).
                    selectCity(fields.userCity).
                    submitInformation();
        });

        step("Checking fields of completed registration form", () -> {
            registrationChecks.
                    checkResult("Student Name", fields.userFullName).
                    checkResult("Student Email", fields.userEmail).
                    checkResult("Gender", fields.userGender).
                    checkResult("Mobile", fields.userMobileNumber).
                    checkResult("Date of Birth", fields.userFullBirthday).
                    checkResult("Subjects", fields.userSubject).
                    checkResult("Hobbies", fields.userHobby).
                    checkResult("Picture", fields.userPhoto).
                    checkResult("Address", fields.userAddress).
                    checkResult("State and City", fields.userStateAndCity);

        });
    }
}
