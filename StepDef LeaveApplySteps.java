package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LeaveApplyPage;
import pages.LoginPage;
import utils.DriverFactory;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LeaveApplySteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    LeaveApplyPage leaveApplyPage = new LeaveApplyPage(driver);

    @Given("I open the login page {string}")
    public void i_open_the_login_page(String url) {
        driver.get(url);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) throws InterruptedException {
        loginPage.login(username, password);
        Thread.sleep(2000);
    }

    @Then("I should see the employee dashboard")
    public void i_should_see_the_employee_dashboard() {
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard not visible!");
    }

    @When("I hover over the Employee menu")
    public void i_hover_over_the_employee_menu() {
        dashboardPage.hoverEmployeeMenu();
    }

    @Then("I should see the {string} option in the dropdown")
    public void i_should_see_the_option_in_the_dropdown(String option) {
        Assert.assertTrue(dashboardPage.isLeaveApplyOptionVisible(), option + " option not visible!");
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String button) {
        dashboardPage.clickLeaveApply();
    }

    @Then("I should be navigated to the Leave Apply page")
    public void i_should_be_navigated_to_the_leave_apply_page() {
        Assert.assertTrue(leaveApplyPage.isNewEntryVisible(), "New Entry button not visible!");
    }

    @And("I should see the {string} button")
    public void i_should_see_the_button(String button) {
        Assert.assertTrue(leaveApplyPage.isNewEntryVisible(), button + " button not visible!");
    }

    @When("I click on the {string} button")
    public void i_click_on_new_entry(String button) {
        leaveApplyPage.clickNewEntry();
    }

    @And("I select {string} as from date and {string} as to date")
    public void i_select_dates(String from, String to) {
        leaveApplyPage.selectDates(from, to);
    }

    @And("I select leave type {string} from the Leave Type dropdown")
    public void i_select_leave_type(String type) {
        leaveApplyPage.selectLeaveType(type);
    }

    @And("I enter {string} as the reason")
    public void i_enter_reason(String reason) {
        leaveApplyPage.enterReason(reason);
    }

    @Then("I click on the {string} button")
    public void i_click_on_save_button(String button) {
        leaveApplyPage.clickSave();
    }

    @And("I should see a {string} message")
    public void i_should_see_a_success_message(String message) {
        Assert.assertTrue(leaveApplyPage.isSuccessMessageDisplayed(message), "Success message not shown!");
    }

    @Then("I validate the Leave Apply API response")
    public void i_validate_the_leave_apply_api_response() {
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            baseUri = "https://glbg.servergi.com:8072/SIMWEBGLB/Employee/Leave%20Apply";
        }
        RestAssured.baseURI = baseUri;

        given()
            .relaxedHTTPSValidation()
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));

        DriverFactory.quitDriver();
    }
}
