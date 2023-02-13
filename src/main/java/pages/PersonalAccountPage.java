package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {

    private SelenideElement buttonExit = $(By.xpath(".//button[text()='Выход']"));

    private SelenideElement divLogo = $(By.xpath(".//div[@class ='AppHeader_header__logo__2D0X2']"));

    private SelenideElement divConstructor = $(By.xpath(".//p[text()='Конструктор']/parent::a"));

    public SelenideElement getButtonExit() {
        return buttonExit;
    }

    public void setButtonExit(SelenideElement buttonExit) {
        this.buttonExit = buttonExit;
    }

    public SelenideElement getDivLogo() {
        return divLogo;
    }

    public void setDivLogo(SelenideElement divLogo) {
        this.divLogo = divLogo;
    }

    public SelenideElement getDivConstructor() {
        return divConstructor;
    }

    public void setDivConstructor(SelenideElement divConstructor) {
        this.divConstructor = divConstructor;
    }
}
