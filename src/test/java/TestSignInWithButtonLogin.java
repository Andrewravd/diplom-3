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

public class TestSignInWithButtonLogin {
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
        open(Urls.MAIN_PAGE_URL);
    }

    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Авторизация по кнопке <Войти в аккаунт> на главной")
    public void signInWithButtonLogin() {
        steps.clickOnElement(mainPage.getButtonLogin());
        steps.isElementDisplayed(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.LOGIN_URL);
        steps.clickOnElement(loginPage.getLinkRegister());
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.isElementDisplayed(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.LOGIN_URL);
        steps.login(user, loginPage.getEmail(), loginPage.getPassword(), loginPage.getButtonSignIn());
        steps.clickOnElement(loginPage.getButtonSignIn());
        steps.isElementDisplayed(mainPage.getButtonMakeOrder());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
        steps.clickOnElement(mainPage.getaAccount());
        steps.isElementDisplayed(personalAccountPage.getButtonExit());
        steps.checkUrl(Urls.PROFILE_URL);
    }
}
