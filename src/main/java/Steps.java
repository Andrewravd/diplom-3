import com.codeborne.selenide.Condition;
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
        Selenide.sleep(500);
        email.sendKeys(user.getEmail());
        Selenide.sleep(500);
        password.sendKeys(user.getPassword());
        Selenide.sleep(500);
    }

    @Step("Авторизация пользователя")
    public void login(User user, SelenideElement email,
                      SelenideElement password, SelenideElement buttonSignIn) {
        email.shouldBe(visible, Duration.ofSeconds(10));
        password.shouldBe(visible, Duration.ofSeconds(10));
        buttonSignIn.shouldBe(visible, Duration.ofSeconds(10));
        email.sendKeys(user.getEmail());
        Selenide.sleep(500);
        password.sendKeys(user.getPassword());


    }

    @Step("Проверка отображения элемента")
    public static boolean isElementDisplayed(SelenideElement element) {
        Selenide.sleep(700);
        try {
            element.shouldBe(Condition.visible);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Открыта страница {url}")
    public void checkUrl(String url) {
        Selenide.sleep(1000);
        Assert.assertEquals(url, url());
    }

    @Step("Клик по элементу")
    public void clickOnElement(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
        element.shouldBe(enabled, Duration.ofSeconds(10));
        element.click();

    }
}
