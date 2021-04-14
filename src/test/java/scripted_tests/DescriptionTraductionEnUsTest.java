package scripted_tests;

import manager.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LiferayFormsPage;
import pages.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DescriptionTraductionEnUsTest {
    private WebDriver driver = DriverManager.getDriver();
    private LiferayFormsPage mainpage = new LiferayFormsPage(driver);

    @Before
    public void startBrowser(){
        this.driver.get(URL.MAIN_PAGE);
    }

    @Test
    public void TestDescriptionTraduction() {
        mainpage.redirectFormPage();
        DriverManager.getWait();
        driver.findElement(By.cssSelector("html")).click();
        assertThat(driver.findElement(By.cssSelector(".ddm-form-description")).getText(), is("This is a description field from our Liferay Forms"));
        assertThat(driver.findElement(By.cssSelector(".lfr-ddm-form-page-title")).getText(), is("This is the first page of our forms."));
        assertThat(driver.findElement(By.cssSelector(".lfr-ddm-form-page-description")).getText(), is("Let's party rock."));
    }

    @After
    public void endBrowser(){
        DriverManager.endSession();
    }

}
