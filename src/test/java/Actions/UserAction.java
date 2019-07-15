package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import pages.UserPage;

public class UserAction {

    public static void clickOnUserManager(WebDriver driver){
        var element = driver.findElement(By.xpath(UserPage.linkUserManager));
        var action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
    public static void clickOnUserEditUserFirst(WebDriver driver){
        var elements = driver.findElements(By.xpath(UserPage.btnEdit));

        if(elements.size() > 0) {
            elements.get(0).click();
        }
    }

    public static void enterFullNameUser(WebDriver driver, String fullName){
        driver.findElement(By.xpath(UserPage.txtName)).clear();
        driver.findElement(By.xpath(UserPage.txtName)).sendKeys(fullName);
    }
    public static void clickOnBtnSubmit(WebDriver driver){
        driver.findElement(By.xpath(UserPage.btnSubmit)).click();
    }

    public  static void EditUserFirst(WebDriver driver, String name){
        clickOnUserManager(driver);
        CommonAction.waitReponse(3000);
        clickOnUserEditUserFirst(driver);
        CommonAction.waitReponse(3000);
        enterFullNameUser(driver, name);
        clickOnBtnSubmit(driver);
    }
}
