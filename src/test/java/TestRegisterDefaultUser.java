import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class TestRegisterDefaultUser {
    private User user;

    private Steps steps;

    private RegistrationPage registrationPage;

    private LoginPage loginPage;

    @Before
    public void setUp() {
        user = UserGenerator.getDefaultUser();
        steps = new Steps();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        open(Urls.REGISTRATION_URL);
    }

    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Регистрация пользователя с валидными данными")
    public void makeDefaultUser() {
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.isElementDisplayed(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.LOGIN_URL);
    }
}