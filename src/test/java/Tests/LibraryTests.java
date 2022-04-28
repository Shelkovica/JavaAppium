package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.DocumentsPageObject;
import lib.ui.LibraryPageObject;
import lib.ui.NavigationUI;
import lib.ui.factories.DocumentsPageObjectFactory;
import lib.ui.factories.LibraryPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import org.junit.Assert;
import org.junit.Test;

public class LibraryTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Library")})
    @DisplayName("Проверка заголовка библиотеки")
    @Description("Проверяем заголовок страницы Библиотеки")
    @Step("Starting test testLib_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_1()
    {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            String title = LibraryPageObject.getPageTitle();
            Assert.assertEquals(
                    "Библиотека материалов",
                    title);
           // LibraryPageObject.getSearchPlaceholder();
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library")})
    @DisplayName("Проверка заголовка избранного библиотеки")
    @Description("Проверяем заголовок страницы Библиотеки, раздел Избранное")
    @Step("Starting test testLib_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_1_2(){
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.openFavoritesPages();
            String title = LibraryPageObject.getPageTitle();
            Assert.assertEquals(
                    "Избранное",
                    title);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library")})
    @DisplayName("Проверка заголовка удаленного библиотеки")
    @Description("Проверяем заголовок страницы Библиотеки, раздел Удаленное")
    @Step("Starting test testLib_3")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_1_3() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.openDeletedPages();
            String title = LibraryPageObject.getPageTitle();
            Assert.assertEquals(
                    "Удаленное",
                    title);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library")})
    @DisplayName("Проверка заголовка архива библиотеки")
    @Description("Проверяем заголовок страницы Библиотеки, раздел Архив")
    @Step("Starting test testLib_4")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_1_4() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.openArchivePages();
            String title = LibraryPageObject.getPageTitle();
            Assert.assertEquals(
                    "Архив",
                    title);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню курса Редактировать")
    @Description("Открываем редактирование из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_1_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_1_1() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryCourses();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileEdit();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Содержание", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню курса Назначить")
    @Description("Открываем Назначить  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_1_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_1_2() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryCourses();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileAppointment();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Назначения", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню курса Посмотреть отчет")
    @Description("Открываем Посмотреть отчет  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_1_3")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_1_3() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryCourses();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileReport();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Отчет", str);
        }
    }


    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Экзамена Редактировать")
    @Description("Открываем редактирование из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_2_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_2_1() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryExams();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileEdit();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Содержание", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Экзамена Назначить")
    @Description("Открываем Назначить  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_2_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_2_2() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryExams();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileAppointment();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Назначения", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Экзамена Посмотреть отчет")
    @Description("Открываем Посмотреть отчет  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_2_3")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_2_3() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryExams();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileReport();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Отчет", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Теста Редактировать")
    @Description("Открываем редактирование из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_3_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_3_1() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryTests();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileEdit();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Содержание", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Теста Назначить")
    @Description("Открываем Назначить  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_3_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_3_2() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryTests();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileAppointment();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Назначения", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Теста Посмотреть отчет")
    @Description("Открываем Посмотреть отчет  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_3_3")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_3_3() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryTests();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileReport();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Отчет", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Опроса  Редактировать")
    @Description("Открываем редактирование из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_4_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_4_1() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibrarySurveys();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileEdit();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Содержание", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Опроса Назначить")
    @Description("Открываем Назначить  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_4_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_4_2() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibrarySurveys();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileAppointment();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Назначения", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Опроса Посмотреть отчет")
    @Description("Открываем Посмотреть отчет  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_4_3")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_4_3() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibrarySurveys();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileReport();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Отчет", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Аудита Редактировать")
    @Description("Открываем редактирование из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_5_1")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_5_1() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryAudits();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileEdit();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Содержание", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Аудита Назначить")
    @Description("Открываем Назначить  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_5_2")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_5_2() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryAudits();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileAppointment();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Назначения", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Аудита Посмотреть отчет")
    @Description("Открываем Посмотреть отчет  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_5_3")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_5_3() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryAudits();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFileReport();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Отчет", str);
        }
    }

    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "course")})
    @DisplayName("Проверка пункта меню Аудита Предоставить доступ")
    @Description("Открываем Посмотреть отчет  из меню документа и проверяем открытый таб")
    @Step("Starting test testLib_2_5_4")
    @Severity(value = SeverityLevel.MINOR)
    public void testLib_2_5_4() {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openLibrary();
            LibraryPageObject LibraryPageObject = LibraryPageObjectFactory.get(driver);
            LibraryPageObject.selectFilterLibraryAudits();
            LibraryPageObject.openFileMenu();
            LibraryPageObject.selectMenuFilePermission();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            String str = DocumentsPageObject.getActiveTabTitle();
            Assert.assertEquals("Active tab is wrong", "Доступ", str);
        }
    }

}
