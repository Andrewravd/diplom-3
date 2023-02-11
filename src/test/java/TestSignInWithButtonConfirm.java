import static com.codeborne.selenide.Selenide.open;

public class TestSignInWithButtonConfirm {


    @Test
    @Description("Авторизация через кнопку <Войти> в форме регистрации")
    public void signInSignInWithButtonConfirm() {
        steps.register(user, registrationPage.getName(),
                registrationPage.getEmail(), registrationPage.getPassword());
        steps.clickOnElement(registrationPage.getButtonConfirm());
        steps.checkUrl(Urls.LOGIN_URL);
        open(Urls.REGISTRATION_URL);
        steps.checkUrl(Urls.REGISTRATION_URL);
        steps.clickOnElement(registrationPage.getLinkSignIn());
        steps.login(user, loginPage.getEmail(), loginPage.getPassword(), loginPage.getButtonSignIn());
        steps.clickOnElement(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
        steps.clickOnElement(mainPage.getaAccount());
        steps.checkUrl(Urls.PROFILE_URL);
    }

}
