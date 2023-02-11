import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class TestSignInWithLinkAccount {
    private User user;

    private Steps steps;

    private RegistrationPage registrationPage;

    private MainPage mainPage;

    private LoginPage loginPage;

    @Before
    public void setUp() {
        user = UserGenerator.getDefaultUser();
        steps = new Steps();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        open(Urls.MAIN_PAGE_URL);
    }
    @After
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }
    @Test
    @Description("Авторизация по кнопке <Личный кабинет>")
    public void signIn() {
        steps.clickOnElement(mainPage.getaAccount());
        steps.checkUrl(Urls.LOGIN_URL);
        steps.clickOnElement(loginPage.getLinkRegister());
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.checkUrl(Urls.LOGIN_URL);
        steps.login(user, loginPage.getEmail(), loginPage.getPassword(), loginPage.getButtonSignIn());
        steps.clickOnElement(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
        steps.clickOnElement(mainPage.getaAccount());
        steps.checkUrl(Urls.PROFILE_URL);
    }
}
