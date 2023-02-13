import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class TestSignInWithButtonConfirm {
    private User user;

    private Steps steps;

    private RegistrationPage registrationPage;

    private MainPage mainPage;

    private LoginPage loginPage;

    private PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        user = UserGenerator.getDefaultUser();
        steps = new Steps();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        personalAccountPage = new PersonalAccountPage();
        open(Urls.REGISTRATION_URL);
    }

    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Авторизация через кнопку <Войти> в форме регистрации")
    public void signInSignInWithButtonConfirm() {
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.isElementDisplayed(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.LOGIN_URL);
        open(Urls.REGISTRATION_URL);
        steps.isElementDisplayed(registrationPage.getButtonConfirm());
        steps.checkUrl(Urls.REGISTRATION_URL);
        steps.clickOnElement(registrationPage.getLinkSignIn());
        steps.login(user, loginPage.getEmail(), loginPage.getPassword(), loginPage.getButtonSignIn());
        steps.clickOnElement(loginPage.getButtonSignIn());
        steps.isElementDisplayed(mainPage.getButtonMakeOrder());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
        steps.clickOnElement(mainPage.getaAccount());
        steps.isElementDisplayed(personalAccountPage.getButtonExit());
        steps.checkUrl(Urls.PROFILE_URL);
    }
}
