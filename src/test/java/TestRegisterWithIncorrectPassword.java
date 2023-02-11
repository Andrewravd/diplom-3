import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class TestRegisterWithIncorrectPassword {
    private User user;

    private Steps steps;

    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        user = UserGenerator.getUserWitIncorrectPassword();
        steps = new Steps();
        registrationPage = new RegistrationPage();
        open(Urls.REGISTRATION_URL);
    }
    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }
    @Test
    @Description("Регистрация пользователя с паролем меньше 6 символов")
    public void makeUserWithIncorrectPassword() {
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.isElementDisplayed(registrationPage.getTextIncorrectPassword());
    }
}
