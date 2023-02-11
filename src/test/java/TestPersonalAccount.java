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

public class TestPersonalAccount {
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
            public void closeBrowser() {
        Selenide.closeWebDriver();
    }
    @Test
    @Description("Переход в личный кабинет по клику на ссылку")
    public void clickOnLinkPersonalAccount() {
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
    @Test
    @Description("Переход на главную страницу  по клику на Конструктор")
    public void clickOnDivConstructor() {
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
        steps.clickOnElement(personalAccountPage.getDivConstructor());
        steps.isElementDisplayed(mainPage.getButtonMakeOrder());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
    }
    @Test
    @Description("Переход по клику на главную страницу  по клику на лого")
    public void clickOnDivLogo() {
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
        steps.clickOnElement(personalAccountPage.getDivLogo());
        steps.isElementDisplayed(mainPage.getButtonMakeOrder());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
    }
    @Test
    @Description("Выход из аккаунта по клику на кнопку <Выход>")
    public void clickOnButtonExit() {
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
        steps.clickOnElement(personalAccountPage.getButtonExit());
        steps.isElementDisplayed(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.LOGIN_URL);
    }
}
