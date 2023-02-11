public class TestSignInWithLinkSignIn {

    private User user;

    private Steps steps;

    private RegistrationPage registrationPage;

    private MainPage mainPage;

    private LoginPage loginPage;

    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        user = UserGenerator.getDefaultUser();
        steps = new Steps();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
        forgotPasswordPage = new ForgotPasswordPage();
        loginPage = new LoginPage();
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
        steps.checkUrl(Urls.LOGIN_URL);
        open(Urls.FORGOT_PASSWORD_URL);
        steps.checkUrl(Urls.FORGOT_PASSWORD_URL);
        steps.clickOnElement(forgotPasswordPage.getLinkSignIn());
        steps.login(user, loginPage.getEmail(), loginPage.getPassword(), loginPage.getButtonSignIn());
        steps.clickOnElement(loginPage.getButtonSignIn());
        steps.checkUrl(Urls.MAIN_PAGE_URL);
        steps.clickOnElement(mainPage.getaAccount());
        steps.checkUrl(Urls.PROFILE_URL);

    }

}
