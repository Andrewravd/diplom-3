import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;


public class TestMainPageSauces {
    private Steps steps;

    MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new MainPage();
        steps = new Steps();
        open(Urls.MAIN_PAGE_URL);
    }

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка раздела <Соусы> на главной странице")
    public void checkTabs() {
        steps.clickOnElement(mainPage.getDivSauces());
        steps.checkCurrentTab(mainPage.getDivSauces());
        steps.isElementDisplayed(mainPage.getHeaderSauces());

    }
}
