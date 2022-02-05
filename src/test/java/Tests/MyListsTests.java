package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String
        login = "Thenesq",
        password = "Thenesq123";

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
        ArticlePageObject.addArticleToMyList(name_of_folder);
        }
        else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if(Platform.getInstance().isMw()) {
            AutorizationPageObject Auth = new AutorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            assertEquals("we are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUi = NavigationUIFactory.get(driver);
        NavigationUi.openNavigation();
        NavigationUi.clickMyLists();
        MyListsPageObjects MyListsPageObjects = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }
        if(Platform.getInstance().isIOS()){
            MyListsPageObjects.closeInfoWindowInMyList();
        }
        MyListsPageObjects.swipeByArticleToDelete(article_title);
    };

    @Test
    public void testSaveTwoArticle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }
        else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if(Platform.getInstance().isMw()) {
            AutorizationPageObject Auth = new AutorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            assertEquals("we are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("anguage");
        ArticlePageObject.waitForTitleElement();
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        }
        else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUi = NavigationUIFactory.get(driver);
        NavigationUi.openNavigation();
        NavigationUi.clickMyLists();
        MyListsPageObjects MyListsPageObjects = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            MyListsPageObjects.openFolderByName(name_of_folder);
        }
        if(Platform.getInstance().isIOS()){
            MyListsPageObjects.closeInfoWindowInMyList();
        }
        MyListsPageObjects.swipeByArticleToDelete(article_title);


        String title_article_in_list =  ArticlePageObject.getTitleArticleFromMyList();

        ArticlePageObject.openArticle();

        String title_article_after_open =  ArticlePageObject.getArticleSecondTitle();
        assertEquals(
                "Article title have been change after open",
                title_article_in_list,
                title_article_after_open
        );
        if (Platform.getInstance().isMw()){
            assertEquals(
                    "Article not have note",
                    ArticlePageObject.getArticleNote(),
                    "Wikipedia:JavaScript"
            );
        }

    }
}
