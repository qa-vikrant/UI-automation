package com.myHr.tests;

import com.myHr.utils.DriverHelperMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class LoginSteps extends DriverHelperMethod {


    private static final Logger LOG = LoggerFactory
            .getLogger(LoginSteps.class);

    @FindBy(xpath = "(//*[text()='LOGIN'])[1]")
    private WebElement signInButton;

    @FindBy(xpath = "(//*[text()='CONTINUE TO LOGIN'])[1]")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@name='userName']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement passowdField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement LoginButton;

    @FindBy(xpath = "//html/body")
    private WebElement bodyTag;

    public LoginSteps() {
        PageFactory.initElements(getDriver(), this);
    }

    @Given("User is on Spicejet login page")
    public void userIsOnSpicejetLoginPage() throws InterruptedException {
        try {
            getDriver().get("https://www.onlinesbi.sbi/");
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @When("User moves to signup page")
    public void userMovesToSignupPage() throws InterruptedException {
        LOG.info(" getCurrentPageTitle is - "+getCurrentPageTitle());
        LOG.info(" getCurrentUrl is - "+getCurrentUrl());


        try {

            signInButton.click();
            continueButton.click();
        } catch (Exception e) {
            e.printStackTrace();

        }

        switchToNextTab();
        LOG.info(" getCurrentPageTitle is - "+getCurrentPageTitle());
        LOG.info(" getCurrentUrl is - "+getCurrentUrl());

    }

    @And("User fills up all the valid details of Member Enrollment page")
    public void userFillupAllTheDetails() {
        usernameField.sendKeys(" Ranjit ");
        passowdField.sendKeys(" Yadav ");

    }

    @And("user should see a submit button")
    public void userSeessubmit() {
        Assert.assertTrue(LoginButton.isEnabled());
        tearDown();
    }

}