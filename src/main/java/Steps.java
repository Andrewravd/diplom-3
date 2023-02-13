import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;



public class Steps {
    @Step("Ввод данных пользователя при регистрации")
    public void register(User user, SelenideElement name, SelenideElement email,
                         SelenideElement password) {
        name.shouldBe(enabled, Duration.ofSeconds(10));
        email.shouldBe(enabled, Duration.ofSeconds(10));
        password.shouldBe(enabled, Duration.ofSeconds(10));
        name.sendKeys(user.getName());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
    }

    @Step("Авторизация пользователя")
    public void login(User user, SelenideElement email,
                      SelenideElement password, SelenideElement buttonSignIn) {
        email.shouldBe(enabled, Duration.ofSeconds(10));
        password.shouldBe(enabled, Duration.ofSeconds(10));
        buttonSignIn.shouldBe(enabled, Duration.ofSeconds(10));
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());


    }

    @Step("Проверка отображения элемента")
    public void isElementDisplayed(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));

    }


    @Step("Открыта страница {url}")
    public void checkUrl(String url) {
        Assert.assertEquals(url, url());
    }

    @Step("Клик по элементу")
    public void clickOnElement(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
        element.shouldBe(enabled, Duration.ofSeconds(10));
        element.click();

    }

    @Step("Вкладка выбрана")
    public void checkCurrentTab(SelenideElement element) {
        Assert.assertEquals($(By.xpath(".//div[contains(@class,'tab_tab_type_current')]"))
                , element);
    }
}