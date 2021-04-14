package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.parser.Element;

public class LiferayFormsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By name_input_box = By.cssSelector(".col-md-7 .ddm-field-text");
    private By date_input_box = By.cssSelector(".input-group-inset");
    private By motivation_input_box = By.cssSelector(".col-md-12 > .form-group > .ddm-field-text");
    private By submit_btn = By.xpath("//button[@type='submit']");

    public LiferayFormsPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getWait();
    }

    public void redirectFormPage(){
        wait.until(ExpectedConditions.urlToBe(URL.MAIN_PAGE));
    }

    public WebElement getNameBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(name_input_box));
        return driver.findElement(name_input_box);
    }

    public WebElement getDateBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(date_input_box));
        return driver.findElement(date_input_box);
    }

    public WebElement getMotivationBox(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(motivation_input_box));
        return driver.findElement(motivation_input_box);
    }

    public WebElement getSubmitButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit_btn));
        return driver.findElement(submit_btn);
    }



}
