package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement name = $(By.xpath(".//*[text()='Имя']/following-sibling::input"));

    private SelenideElement email = $(By.xpath(".//*[text()='Email']/following-sibling::input"));

    private SelenideElement password = $(By.xpath(".//*[text()='Пароль']/following-sibling::input"));

    private SelenideElement buttonConfirm = $(By.xpath(".//button[text()='Зарегистрироваться']"));

    private SelenideElement textIncorrectPassword = $(By.xpath(".//p[text()='Некорректный пароль']"));

    private SelenideElement linkSignIn = $(By.xpath(".//a[text()='Войти']"));

    public SelenideElement getName() {
        return name;
    }

    public void setName(SelenideElement name) {
        this.name = name;
    }

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

    public SelenideElement getButtonConfirm() {
        return buttonConfirm;
    }

    public void setButtonConfirm(SelenideElement buttonConfirm) {
        this.buttonConfirm = buttonConfirm;
    }

    public SelenideElement getTextIncorrectPassword() {
        return textIncorrectPassword;
    }

    public void setTextIncorrectPassword(SelenideElement textIncorrectPassword) {
        this.textIncorrectPassword = textIncorrectPassword;
    }

    public SelenideElement getLinkSignIn() {
        return linkSignIn;
    }

    public void setLinkSignIn(SelenideElement aSignIn) {
        this.linkSignIn = linkSignIn;
    }
}
