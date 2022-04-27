package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        MY_LISTS_LINK = "css:a[data-event-name='menu.unStar']";
        OPEN_EDUCATION ="css:a.link_study"; //"xpath://div[@class='desktop-menu__nav']/a['desktop-menu__link'][1]";
        OPEN_AUDITS ="css:a.link_audits";//"xpath://div[@class='desktop-menu__nav']/a['desktop-menu__link'][2]";
        OPEN_LIBRARY ="css:a.link_cms";//"xpath://div[@class='desktop-menu__nav']/a['desktop-menu__link'][3]";
        OPEN_COMMUNICATION ="css:a.link_communication";//"xpath://div[@class='desktop-menu__nav']/a['desktop-menu__link'][4]";
        OPEN_REPORTS ="css:a.link_report";//"xpath://div[@class='desktop-menu__nav']/a['desktop-menu__link'][5]";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
        OPEN_MENU_CREATE_DOCUMENTS = "css:#create_dropdown_toggle";
        SELECT_MENU_CREATE_FOLDER = "css:a.create_folder";//"xpath://div[@class='context-menu']//a[5]";
        SELECT_MENU_CREATE_COURSE = "css:a.create_course";
        SELECT_MENU_CREATE_TEST = "css:a.create_test";
        SELECT_MENU_CREATE_EXAM = "css:a.create_exam";
        SELECT_MENU_CREATE_AUDIT = "css:a.create_audit";

    }
    public MWNavigationUI (RemoteWebDriver driver)
    {
        super(driver);
    }
}
