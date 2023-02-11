package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement email = $(By.xpath(".//*[text()='Email']/following-sibling::input"));

    private SelenideElement password = $(By.xpath(".//*[text()='Пароль']/following-sibling::input"));

    private SelenideElement buttonSignIn = $(By.xpath(".//button[text()='Войти']"));

    private SelenideElement linkRegister = $(By.xpath(".//a[text()='Зарегистрироваться']"));

    private SelenideElement linkForgotPassword = $(By.xpath(".//a[text()='Восстановить пароль']"));

    public SelenideElement getEmail() {
        return email;
    }

    public void setEmail(SelenideElement email) {
        this.email = email;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public void setPassword(SelenideElement password) {
        this.password = password;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    public void setButtonSignIn(SelenideElement buttonSignIn) {
        this.buttonSignIn = buttonSignIn;
    }

    public SelenideElement getLinkRegister() {
        return linkRegister;
    }

    public void setaRegister(SelenideElement linkRegister) {
        this.linkRegister = linkRegister;
    }

    public SelenideElement getLinkForgotPassword() {
        return linkForgotPassword;
    }

    public void setaForgotPassword(SelenideElement linkForgotPassword) {
        this.linkForgotPassword = linkForgotPassword;
    }
}
