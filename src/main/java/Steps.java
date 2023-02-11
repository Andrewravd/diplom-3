import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;


public class Steps {
    @Step("Ввод данных пользователя при регистрации")
    public void register(User user, SelenideElement name, SelenideElement email,
                         SelenideElement password) {
        name.sendKeys(user.getName());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
    }

    @Step("Авторизация пользователя")
    public void login(User user, SelenideElement email,
                      SelenideElement password, SelenideElement buttonSignIn) {
        email.shouldBe(visible, Duration.ofSeconds(10));
        password.shouldBe(visible, Duration.ofSeconds(10));
        buttonSignIn.shouldBe(visible, Duration.ofSeconds(10));
        email.sendKeys(user.getEmail());
        Selenide.sleep(5000);
        password.sendKeys(user.getPassword());


    }

    @Step("Проверка отображения элемента {element}")
    public void isElementDisplayed(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
        Selenide.sleep(1000);

    }

    @Step("Открыта страница {url}")
    public void checkUrl(String url) {
        Assert.assertEquals(url, url());
    }

    @Step("Клик по элементу {element}")
    public void clickOnElement(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
        element.shouldBe(enabled, Duration.ofSeconds(10));
        element.click();

    }
}
