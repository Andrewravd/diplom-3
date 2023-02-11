package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement buttonLogin = $(By.xpath(".//button[text()='Войти в аккаунт']"));

    private SelenideElement linkAccount = $(By.xpath(".//p[text()='Личный Кабинет']/parent::a"));

    private SelenideElement divBuns = $(By.xpath(".//span[text()='Булки']/parent::div"));

    private SelenideElement divSauces = $(By.xpath(".//span[text()='Соусы']/parent::div"));

    private SelenideElement divFiling = $(By.xpath(".//span[text()='Начинки']/parent::div"));

    private SelenideElement headerBuns = $(By.xpath(".//h2[text()='Булки']"));

    private SelenideElement headerSauces = $(By.xpath(".//h2[text()='Соусы']"));

    private SelenideElement headerFiling = $(By.xpath(".//h2[text()='Начинки']"));

    private SelenideElement buttonMakeOrder = $(By.xpath(".//button[text()='Оформить заказ']"));

    public SelenideElement getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(SelenideElement buttonLogin) {
        this.buttonLogin = buttonLogin;
    }

    public SelenideElement getaAccount() {
        return linkAccount;
    }

    public void setLinkAccount(SelenideElement aAccount) {
        this.linkAccount = aAccount;
    }

    public SelenideElement getDivBuns() {
        return divBuns;
    }

    public void setDivBuns(SelenideElement divBuns) {
        this.divBuns = divBuns;
    }

    public SelenideElement getDivSauces() {
        return divSauces;
    }

    public void setDivSauces(SelenideElement divSauces) {
        this.divSauces = divSauces;
    }

    public SelenideElement getDivFiling() {
        return divFiling;
    }

    public void setDivFiling(SelenideElement divFiling) {
        this.divFiling = divFiling;
    }

    public SelenideElement getHeaderBuns() {
        return headerBuns;
    }

    public void setHeaderBuns(SelenideElement hBuns) {
        this.headerBuns = hBuns;
    }

    public SelenideElement getHeaderSauces() {
        return headerSauces;
    }

    public void sethSauces(SelenideElement headerSauces) {
        this.headerSauces = headerSauces;
    }

    public SelenideElement getHeaderFiling() {
        return headerFiling;
    }

    public void setHeaderFiling(SelenideElement headerFiling) {
        this.headerFiling = headerFiling;
    }

    public SelenideElement getButtonMakeOrder() {
        return buttonMakeOrder;
    }

    public void setButtonMakeOrder(SelenideElement buttonMakeOrder) {
        this.buttonMakeOrder = buttonMakeOrder;
    }
}
