package StepDefinitions;

import Pages.DialogContent;
import Pages._Parent;
import Utilities.DBUtility;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _11_JDBCSteps {

    @Then("^Send The query the database \"([^\"]*)\" and control match$")
    public void sendTheQueryTheDatabaseAndControlMatch(String query)  {

        // DB deki country tablosundaki isimler UI da gözüküyor mu?
        List<List<String>> dbList = DBUtility.getListData(query);

        DialogContent dialogContent=new DialogContent(); // dialogContent.nameList elementine ulaşmak için tanımlandı.
        // UI daki ülke listesi alındı
        List<WebElement> uiList = dialogContent.waitVisibleListAllElement(dialogContent.nameList);

        for(int i=0; i < dbList.size(); i++) // db deki kadar karşılaştırma yaptırdık
        {
            System.out.println("db:"+dbList.get(i).get(1) + " - ui:"+ uiList.get(i).getText());

            Assert.assertEquals(dbList.get(i).get(1), uiList.get(i).getText());
            // dbList.get(i).get(1)  -> her satırın 1 indexli elemanı alındı.
            // uiList.get(i)   -> UI daki sadece country isimleri alındaı
            // ve karşılaştırıldı.
        }
    }
}
