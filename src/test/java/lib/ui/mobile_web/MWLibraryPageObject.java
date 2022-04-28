package lib.ui.mobile_web;

import lib.ui.LibraryPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWLibraryPageObject extends LibraryPageObject
{
    static {
        PAGE_TITLE = "css:div.library__header h1";
        PAGE_FAVORITES = "xpath://div[contains(text(),'Избранное')]";
        PAGE_DELETED = "xpath://div[contains(text(),'Удаленное')]";
        PAGE_ARCHIVE = "xpath://div[contains(text(),'Архив')]";
        LIBRARY_SEARCH_PLACEHOLDER="xpath://div[@class='form-input']/input";
        TAB_COURSES = "css:div.filter.type_course";
        TAB_EXAMS = "css:div.filter.type_exam";
        TAB_TESTS = "css:div.filter.type_test";
        TAB_AUDITS = "css:div.filter.type_audit";
        TAB_SURVEYS = "css:div.filter.type_survey";
        FILE_MENU = "css:div.file-menu";
        FILE_MENU_WINDOW = "css:div.context-menu__wrapper";
        FILE_MENU_EDIT = "css:div.action.action_edit";
        FILE_MENU_APPOINTMENT = "css:div.action.action_appointment";
        FILE_MENU_REPORT = "css:div.action.action_report";
        FILE_MENU_PERMISSION = "css:div.action.action_permissions";
    }


    public MWLibraryPageObject (RemoteWebDriver driver)
    {
        super(driver);
    }




}
