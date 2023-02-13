import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class TestSignInWithLinkSignIn {
    private User user;

    private Steps steps;

    private RegistrationPage registrationPage;

    private MainPage mainPage;

    private LoginPage loginPage;

    private ForgotPasswordPage forgotPasswordPage;

    private PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        user = UserGenerator.getDefaultUser();
        steps = new Steps();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
        forgotPasswordPage = new ForgotPasswordPage();
        loginPage = new LoginPage();
        personalAccountPage = new PersonalAccountPage();
        open(Urls.REGISTRATION_URL);
    }

    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Авторизация через кнопку <Войти> в форме восстановления пароля")
    public void signInWithLinkSignIn() {
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.isElementDisplayed(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.LOGIN_URL);
        open(Urls.FORGOT_PASSWORD_URL);
        steps.isElementDisplayed(forgotPasswordPage.getLinkSignIn());
        steps.checkUrl(Urls.FORGOT_PASSWORD_URL);
        steps.clickOnElement(forgotPasswordPage.getLinkSignIn());
        steps.login(user, loginPage.getEmail(), loginPage.getPassword(), loginPage.getButtonSignIn());
        steps.clickOnElement(loginPage.getButtonSignIn());
        steps.isElementDisplayed(mainPage.getButtonMakeOrder());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
        steps.clickOnElement(mainPage.getaAccount());
        steps.isElementDisplayed(personalAccountPage.getButtonExit());
        steps.checkUrl(Urls.PROFILE_URL);

    }


}
