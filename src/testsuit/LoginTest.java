package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String bseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(bseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@name='user-name']"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //Verify the text “PRODUCTS”
        String expectedText="Products";
        String actualText=getTextFromElement(By.xpath("//span[text()='Products']"));
        Assert.assertEquals("Massage not found",expectedText,actualText);

        //getTextFromElement(By.xpath("//span[text()='Products']"));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@name='user-name']"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Login']"));
        // Verify that six products are displayed on page

        String expectedText="carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String actualText=getTextFromElement(By.xpath("//div[@class='inventory_item_desc']"));
        Assert.assertEquals("Massage not found",expectedText,actualText);




     }

    @After
    public void tearDown(){
        driver.quit();
    }


}
