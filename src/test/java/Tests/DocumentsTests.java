package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.DocumentsPageObject;
import lib.ui.NavigationUI;
import lib.ui.factories.DocumentsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import org.junit.Test;

import java.time.LocalDateTime;

public class DocumentsTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value = "Library"), @Feature(value = "Audit")})
    @DisplayName("Создание нового аудита с 1 вопросом типа 1 из списка")
    @Description("Создаем аудит с 1 вопросом типа 1 из списка")
    @Step("Starting test testLib_5")
    @Severity(value = SeverityLevel.NORMAL)
    public void testDoc_1() throws InterruptedException {
        if (Platform.getInstance().isMw()){
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.openMenuCreatedDocuments();
            NavigationUI.openPageCreateAudit();
            DocumentsPageObject DocumentsPageObject = DocumentsPageObjectFactory.get(driver);
            DocumentsPageObject.setDocumentTitle("Test Audit "+ LocalDateTime.now());
            DocumentsPageObject.clickOnCreateQuestion();
         //   Thread.sleep(5000);
           // DocumentsPageObject.clickOnCreateQuestion();
            DocumentsPageObject.setQuestionTitle("Первый вопрос");
            DocumentsPageObject.setFirstAnswer("Первый ответ");
            DocumentsPageObject.setSecondAnswer("Второй ответ");
        }
    }
}
