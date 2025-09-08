package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
    private WebDriver driver;

    private By dashboardHeader = By.id("dashboardHeader");
    private By employeeMenu = By.id("employeeMenu");
    private By leaveApplyOption = By.id("leaveApplyLink");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public void hoverEmployeeMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(employeeMenu)).perform();
    }

    public boolean isLeaveApplyOptionVisible() {
        return driver.findElement(leaveApplyOption).isDisplayed();
    }

    public void clickLeaveApply() {
        driver.findElement(leaveApplyOption).click();
    }
}
