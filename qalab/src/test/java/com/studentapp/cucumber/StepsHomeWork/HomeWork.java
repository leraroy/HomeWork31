package com.studentapp.cucumber.StepsHomeWork;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(SerenityRunner.class)

public class HomeWork {

    @Managed
    WebDriver driver;

    @Test

    @Given("^User goes to Mixcloud$")
    public void user_navigates_to_mixcloud_website() {
        driver.get("https://www.mixcloud.com/");
        this.driver.manage().window().maximize();
    }

    @Step
    @When("^User click on the login button on page at the site$")
    public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
        driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
    }

    @Step
    @And("^User enters a correct username$")
    public void userEntersACorrectUsername() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("vicktoria.vivi2020@gmail.com");
    }

    @Step
    @And("^User enters a correct password$")
    public void userEntersACorrectPassword() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Dbdb2020");
    }

    @Step
    @When("^User click on the login button on the homepage$")
    public void user_click_on_the_login_button() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),'Log In')]")).click();

    }

    @Then("^User must be successfully logged in$")
    public void user_must_be_successfully_logged_in() throws Throwable {
        Thread.sleep(2000);
        WebElement QaLab=driver.findElement(By.xpath("//*[contains(text(), 'Lera_lera')]"));
        Assert.assertEquals(true,  QaLab.isDisplayed());
    }

    @Given("^User click on the Search field$")
    public void userClickOnTheSearchField() throws Throwable{
        Thread.sleep(3000);
        driver.findElement(By.name("mixcloud_query")).click();
    }

    @When("^User enter name artist in the Search field$")
    public void userEnterNameArtistInTheSearchField() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/input['mixcloud_query']")).sendKeys("Martin Garrix");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[3]/div/div/div[3]/div/div/div/div/div[3]/div[2]/div/div/div[1]/div[1]/div/div/span/a/p")).click();
    }

    @And("^User select any track\\.$")
    public void user_plays_any_track () throws Throwable {
        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");

    }

    @And("^User click on the favorites button$")
    public void user_clicks_the_favorites_button() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/section[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]/*[1]")).click();

    }

    @When("^User click on icon your profile$")
    public void user_clicks_icon_your_profile () throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[3]/div/div/div[2]/div/div[3]/div[3]/div/div/img")).click();
        }

    @And("^User clicks button your profile$")
    public void user_clicks_button_your_profile () throws Throwable {
        driver.findElement(By.xpath("//p[contains(text(),'Your profile')]")).click();
    }
    @And("^Track should be in the favorites$")
    public void track_should_be_in_the_favorites() throws Throwable {
        Thread.sleep(3000);
        WebElement track=driver.findElement(By.xpath("//a[contains(text(),'The Martin Garrix Show #339')]"));
        Assert.assertEquals(true, track.isDisplayed());
    }

    @Then("^User clicks remove a track from favorites$")
    public void user_clicks_remove_a_track_from_favorites () throws Throwable {
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[3]/div/div/div[3]/div/div[3]/main/div[1]/div/div/div[1]/div[1]/div/div/div[1]/span")).click();

    }



}
