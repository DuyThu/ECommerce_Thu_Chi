package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import pages.MainLoginPage;

public class AdminAction {
    public static void clickOnBtnDropdown(WebDriver driver){
        driver.findElement(By.xpath(MainLoginPage.btnDropdown)).click();
    }
    public static void clickOnAdminPanel(WebDriver driver){
        var element = driver.findElement(By.xpath(AdminPage.linkControlPanel));
        var action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }


    public static void navigateAdminMenu(WebDriver driver){
        clickOnBtnDropdown(driver);
        clickOnAdminPanel(driver);
        CommonAction.SwitchTabPage(driver);
    }

}
