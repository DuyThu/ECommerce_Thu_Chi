package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;

import javax.swing.*;

public class LoginAction {

    public static void ClickOnLinkDangNhap(WebDriver driver){
        driver.findElement(By.xpath(LoginPage.linkDangNhap)).click();
    }
    public static void EnterUserName(WebDriver driver, String userName){
        driver.findElement(By.xpath(LoginPage.txtUserName)).sendKeys(userName);
    }

    public static void EnterPass(WebDriver driver, String pass){
        driver.findElement(By.xpath(LoginPage.txtPass)).sendKeys(pass);
    }
    public static void ClickOnBtnDangNhap(WebDriver driver){
        driver.findElement(By.xpath(LoginPage.btnDangNhap)).click();
        WebElement input = driver.findElement(By.xpath(LoginPage.btnDangNhap));
        new Actions(driver).moveToElement(input).click().perform();
    }

    public static void Login(WebDriver driver, String userName, String pass){
        ClickOnLinkDangNhap(driver);
        CommonAction.waitReponse(2000);
        EnterUserName(driver,userName);
        EnterPass(driver, pass);
        ClickOnBtnDangNhap(driver);
        CommonAction.waitReponse(3000);
    }
}
