package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for app conditions")
public class ChangeAppConditionTests extends CoreTestCase
{

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "App conditions"), @Feature(value = "Article")})
    @DisplayName("Change Screen Orientation on page Search Result")
    @Description("We change the screen orientation twice and check the title of the article")
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    @Severity(value = SeverityLevel.NORMAL)
    public void testChangeScreenOrientationOnSearchResults()
    {
        if (Platform.getInstance().isMw()) {return;}
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation =  ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();
        Assert.assertEquals(
                "Article title have been change after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
        this.rotateScreenPortrait();
        String title_after_second_rotation =  ArticlePageObject.getArticleTitle();
        Assert.assertEquals(
                "Article title have been change after screen rotation",
                title_after_second_rotation,
                title_after_rotation
        );
    };

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "App conditions"), @Feature(value = "Article")})
    @DisplayName("Check Search Article In Background")
    @Description("We open search result and assert title after Background app")
    @Step("Starting test testCheckSearchArticleInBackground")
    @Severity(value = SeverityLevel.NORMAL)
    public void testCheckSearchArticleInBackground()
    {
        if (Platform.getInstance().isMw()) {return;}
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    };
}
