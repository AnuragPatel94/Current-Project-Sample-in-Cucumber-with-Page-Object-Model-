package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveApplyPage {
    private WebDriver driver;

    private By newEntryBtn = By.id("newEntryBtn");
    private By fromDate = By.id("fromDate");
    private By toDate = By.id("toDate");
    private By leaveType = By.id("leaveType");
    private By reasonField = By.id("reason");
    private By saveBtn = By.id("saveBtn");
    private By successMsg = By.id("successMessage");

    public LeaveApplyPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewEntryVisible() {
        return driver.findElement(newEntryBtn).isDisplayed();
    }

    public void clickNewEntry() {
        driver.findElement(newEntryBtn).click();
    }

    public void selectDates(String from, String to) {
        driver.findElement(fromDate).sendKeys(from);
        driver.findElement(toDate).sendKeys(to);
    }

    public void selectLeaveType(String type) {
        driver.findElement(leaveType).sendKeys(type);
    }

    public void enterReason(String reason) {
        driver.findElement(reasonField).sendKeys(reason);
    }

    public void clickSave() {
        driver.findElement(saveBtn).click();
    }

    public boolean isSuccessMessageDisplayed(String message) {
        return driver.findElement(successMsg).getText().contains(message);
    }
}
