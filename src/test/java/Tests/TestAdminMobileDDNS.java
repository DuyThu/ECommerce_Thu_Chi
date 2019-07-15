package Test;

import Actions.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainLoginPage;
import pages.MainUserPage;

public class TestAdminMobileDDNS {
    WebDriver driver;
    String userDir = System.getProperty("user.dir");
    String chromeDiver = userDir + "\\src\\drivers\\chromedriver.exe";
    String username="tranthang212@gmail.com";
    String pass="123123";
    String fullName="Thay đổi user";

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", chromeDiver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mobile.ddns.net/");
    }

    @Test
    public void VerifyThatUserCanLoginSuccessful(){
        driver.switchTo().frame("redir_frame");
        //Login
        LoginAction.Login(driver, username, pass);
        //Check
        boolean isLogin = driver.findElement(By.xpath(MainLoginPage.btnDropdown)).isDisplayed();
        if(isLogin){
            CommonAction.writeResultTestCaseToExcel(1, "VerifyThatUserCanLoginSuccessful", "PASS", "");
        }
        else {
            CommonAction.writeResultTestCaseToExcel(1, "VerifyThatUserCanLoginSuccessful", "FAIL", "");
        }

        Assert.assertEquals("Login Successful",true,isLogin);
    }

    @Test
    public void VerifyThatAdminCanEditUserSuccessful(){
        driver.switchTo().frame("redir_frame");
        //Login
        LoginAction.Login(driver, username, pass);

        //navigate admin menu
        AdminAction.navigateAdminMenu(driver);
        CommonAction.waitReponse(3000);
        //Edit user first
        UserAction.EditUserFirst(driver, fullName);
        //Check
        boolean isEditUser=driver.getCurrentUrl().equals(MainUserPage.lnkEditUser);
        if(isEditUser){
            CommonAction.writeResultTestCaseToExcel(2, "VerifyThatUserCanEditUserSuccessful", "PASS", "");
        }
        else {
            CommonAction.writeResultTestCaseToExcel(2, "VerifyThatUserCanEditUserSuccessful", "FAIL", "");
        }

        Assert.assertEquals("Edit User Successful",true,isEditUser);



    }

    @After
    public void end() {
        driver.quit();
    }

}
