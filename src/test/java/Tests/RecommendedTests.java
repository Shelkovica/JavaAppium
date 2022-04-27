package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.RecommendedPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.RecommendedPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class RecommendedTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Education"), @Feature(value = "Recommended")})
    @DisplayName("Проверка заголовка Рекомедуемых")
    @Description("Проверяем заголовок страницы рекомендуемых")
    @Step("Starting test testEduc_1_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testEduc_1_1()
    {
        if (Platform.getInstance().isMw()){
            RecommendedPageObject RecommendedPageObject = RecommendedPageObjectFactory.get(driver);
            RecommendedPageObject.recommendedTitleIsPresent();
            String title = RecommendedPageObject.getPageTitle();
            Assert.assertEquals(
                    "Мои",
                     title);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Education"), @Feature(value = "Recommended")})
    @DisplayName("Проверка заголовка Завершеннрых")
    @Description("Проверяем заголовок страницы Завершенных")
    @Step("Starting test testEduc_1_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testEduc_1_2()
    {
        if (Platform.getInstance().isMw()){
            RecommendedPageObject RecommendedPageObject = RecommendedPageObjectFactory.get(driver);
            RecommendedPageObject.completedTitleIsPresent();
            String title = RecommendedPageObject.getPageTitle();
            Assert.assertEquals(
                    "Завершенные",
                    title);
        }
    }
}
