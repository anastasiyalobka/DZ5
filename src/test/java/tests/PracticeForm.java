package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageObject;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm extends TestBase {

    Faker faker = new Faker();
          //  new Locale("ru"));

    String  firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = "May",
            yearOfBirth = "2004",
            dayOfBirth = "27",
            subject1 = "Chemistry",
            hobby1 = "Sports",
            picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state1 = "Uttar Pradesh",
            city1 = "Merrut";

    RegistrationPageObject registrationPageObject = new RegistrationPageObject();

    @Test
    void successFullPracticeForm(){
        registrationPageObject.openPage();
        registrationPageObject.typeFirstName(firstName);
        registrationPageObject.typeLastName(lastName);
        registrationPageObject.typeEmail(email);
        registrationPageObject.typeGender(gender);
        registrationPageObject.typeMobileNumber(mobile);
        registrationPageObject.typeDateBirth(dayOfBirth,monthOfBirth,yearOfBirth);
        registrationPageObject.typeSubject(subject1);
        registrationPageObject.typeHobby(hobby1);
        registrationPageObject.uploadPicture(picture);
        registrationPageObject.typeCurrentAddress(currentAddress);
        registrationPageObject.typeStateAndCity(state1,city1);
        registrationPageObject.pressSubmit();

        registrationPageObject.checkResults(firstName,
                lastName,
                email,
                gender,
                mobile,
                monthOfBirth,
                yearOfBirth,
                dayOfBirth,
                subject1,
                hobby1,
                picture,
                currentAddress,
                state1,
                city1);
    }
}

