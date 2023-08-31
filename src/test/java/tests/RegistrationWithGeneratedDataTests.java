package tests;


import checks.RegistrationPageChecks;
import com.demoqa.utils.Fields;
import components.CalendarComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithGeneratedDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageChecks registrationChecks = new RegistrationPageChecks();
    CalendarComponent calendarComponent = new CalendarComponent();
    Fields fields = new Fields();


    @DisplayName("Registration test with usage of generated data as a homework for lesson #8")
    @Test
    void userRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(fields.userFirstName)
                .setLastName(fields.userLastName)
                .setUserEmail(fields.userEmail)
                .setGender(fields.userGender)
                .setUserMobileNumber(fields.userMobileNumber);

        calendarComponent.setBirthDate(fields.userBirthDay, fields.userBirthMonth, fields.userBirthYear);

        registrationPage.setSubjects(fields.userSubject)
                .setHobbies(fields.userHobby)
                .setAddress(fields.userAddress)
                .uploadFile(fields.userPhoto)
                .selectState(fields.userState)
                .selectCity(fields.userCity)
                .submitInformation();

        registrationChecks
                .checkResult("Student Name", fields.userFullName)
                .checkResult("Student Email", fields.userEmail)
                .checkResult("Gender", fields.userGender)
                .checkResult("Mobile", fields.userMobileNumber)
                .checkResult("Date of Birth", fields.userFullBirthday)
                .checkResult("Subjects", fields.userSubject)
                .checkResult("Hobbies", fields.userHobby)
                .checkResult("Picture", fields.userPhoto)
                .checkResult("Address", fields.userAddress)
                .checkResult("State and City", fields.userStateAndCity);
    }
}
