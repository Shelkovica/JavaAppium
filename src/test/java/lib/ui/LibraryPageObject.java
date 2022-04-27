package lib.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class LibraryPageObject extends MainPageObject {

    protected static  String
            PAGE_TITLE,
            PAGE_FAVORITES,
            PAGE_DELETED,
            PAGE_ARCHIVE,
            LIBRARY_SEARCH_PLACEHOLDER,
            TAB_COURSES,
            TAB_EXAMS,
            TAB_TESTS,
            TAB_AUDITS,
            TAB_SURVEYS,
            FILE_MENU,
            FILE_MENU_WINDOW,
            FILE_MENU_EDIT,
            FILE_MENU_APPOINTMENT,
            FILE_MENU_REPORT;

    public LibraryPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    public String getPageTitle()
    {
        WebElement title_element = waitForElementPresent(PAGE_TITLE, "Cannot present title", 10);
        //System.out.println(title_element.getText());
        return title_element.getText();
    };

    public void openFavoritesPages()  {
        this.waitForElementAndClick(PAGE_FAVORITES, "Cannot find favorite folder", 10);
    }

    public void openDeletedPages()  {
        this.waitForElementAndClick(PAGE_DELETED, "Cannot find deleted folder", 10);
    }

    public void openArchivePages()  {
        this.waitForElementAndClick(PAGE_ARCHIVE, "Cannot find archive  folder", 10);
    }

    public String getSearchPlaceholder()  {
        WebElement element = waitForElementPresent(LIBRARY_SEARCH_PLACEHOLDER, "Cannot present searchInput", 10);

        System.out.println(element.getText());
        return element.getText();
    }

    public void selectFilterLibraryCourses()
    {
        this.waitForElementAndClick(TAB_COURSES, "Cannot find filter courses" , 5);
    }

    public void selectFilterLibraryTests()
    {
        this.waitForElementAndClick(TAB_TESTS, "Cannot find filter tests" , 5);
    }

    public void selectFilterLibraryExams()
    {
        this.waitForElementAndClick(TAB_EXAMS, "Cannot find filter exams" , 5);
    }

    public void selectFilterLibraryAudits()
    {
        this.waitForElementAndClick(TAB_AUDITS, "Cannot find filter audits" , 5);
    }

    public void selectFilterLibrarySurveys()
    {
        this.waitForElementAndClick(TAB_SURVEYS, "Cannot find filter surveys" , 5);
    }

    public void openFileMenu()
    {
        this.waitForElementAndClick(FILE_MENU, "Cannot open file menu", 5);
    }

    public void selectMenuFileEdit()
    {
        this.waitForElementPresent(FILE_MENU_WINDOW, "Cannot view file menu", 5);
        this.waitForElementAndClick(FILE_MENU_EDIT, "Cannot click menu Edit", 5);
    }

    public void selectMenuFileAppointment()
    {
        this.waitForElementPresent(FILE_MENU_WINDOW, "Cannot view file menu", 5);
        this.waitForElementAndClick(FILE_MENU_APPOINTMENT, "Cannot click menu Appointment", 5);
    }

    public void selectMenuFileReport()
    {
        this.waitForElementPresent(FILE_MENU_WINDOW, "Cannot view file menu", 5);
        this.waitForElementAndClick(FILE_MENU_REPORT, "Cannot click menu Report", 5);
    }
}
