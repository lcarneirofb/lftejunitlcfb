package scripted_tests;

import manager.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LiferayFormsPage;
import pages.URL;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;


public class FormSubmissionEmptyTest{

    private WebDriver driver = DriverManager.getDriver();
    private LiferayFormsPage mainpage = new LiferayFormsPage(driver);

    @Before
    public void startBrowser(){
        this.driver.get(URL.MAIN_PAGE);
    }

    @Test
    public void TestFormSubmission() {
        mainpage.redirectFormPage();
        DriverManager.getWait();
        mainpage.getNameBox().click();
        mainpage.getDateBox().click();
        mainpage.getMotivationBox().click();
        mainpage.getSubmitButton().click();
        DriverManager.getWait();
        driver.findElement(By.cssSelector("html")).click();
        assertThat(driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item")).getText(), is("This field is required."));
        assertThat(driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item")).getText(), is("This field is required."));
        assertThat(driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item")).getText(), is("This field is required."));
    }

    @After
    public void endBrowser(){
        DriverManager.endSession();
    }

}
