package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {
    @Test
    public void practiceFormPositiveTest() {
        Student student = Student.builder()
                .firstName("Polina")
                .lastName("Polina")
                .email("polina345@gmail.com")
                .gender("female")
                .mobile("0123456789")
                .dateOfBirth("22 Apr 2003")
                .subjects("Maths,Chemistry,English")
                .hobbies("sport")
                .picture("")
                .address("Street 1")
                .state("NCR")
                .city("City")
                .build();
//        HomePage homePage = new HomePage(getDriver());
//        homePage.clickBtnForms();
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage =
                new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

    }
}
