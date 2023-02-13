package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    private SelenideElement linkSignIn = $(By.xpath(".//a[text()='Войти']"));

    public SelenideElement getLinkSignIn() {
        return linkSignIn;
    }

    public void setgetLinkSignIn(SelenideElement linkSignIn) {
        this.linkSignIn = linkSignIn;
    }
}