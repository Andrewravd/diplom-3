public class TestSignInWithButtonLogin {

    @Test
    @Description("Авторизация по кнопке <Войти в аккаунт> на главной")
    public void signInWithButtonLogin() {
        steps.clickOnElement(mainPage.getButtonLogin());
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
