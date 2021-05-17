package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Add {
    private WebDriver driver;
    private By postJob = By.cssSelector("#c0_0 > a:nth-child(2)");
    private By offerJob = By.cssSelector("#c1_Jobs > a:nth-child(1)");
    private By jobCategories = By.cssSelector("#c2_29 .n");
    private By organization = By.cssSelector("#fsec_0 > div:nth-child(2) > div > div.e > div > label:nth-child(1) > div.r1");
    private By locationDropdown = By.cssSelector("#fsec_1 > div:nth-child(2) > div > div.e > div > div.me");
    private By location = By.cssSelector("#fsec_1 > div:nth-child(2) > div > div.e > div > div.l.top > div:nth-child(2)");
    private By employmentTypeDropdown = By.cssSelector("#attrSec > div:nth-child(2) > div:nth-child(1) > div.e > div > div.me");
    private By permanentEmployment = By.cssSelector("#attrSec > div:nth-child(2) > div:nth-child(1) > div.e > div > div.l.top > div:nth-child(1)");
    private By scheduleDropdown = By.cssSelector("#attrSec > div:nth-child(2) > div:nth-child(2) > div.e > div > div.me");
    private By fullTimeJob = By.cssSelector("#attrSec > div:nth-child(2) > div:nth-child(2) > div.e > div > div.l.top > div:nth-child(1)");
    private By experienceDropdown = By.cssSelector("#attrSec > div:nth-child(2) > div:nth-child(3) > div.e > div > div.me");
    private By noExperience = By.cssSelector("#attrSec > div:nth-child(2) > div:nth-child(3) > div.e > div > div.l.top > div:nth-child(1)");
    private By salaryInput = By.cssSelector("#_idsalary_from");
    private By jobTitleInput = By.cssSelector("#_idtitle");
    private By jobDescriptionInput = By.cssSelector("#_iddescription");
    private String title = "Lorem ipsum dolor sit amet";
    private String description = "Lorem ipsum dolor sit amet; Lorem ipsum dolor sit amet";
    private String salary = "123";
    private By preview = By.cssSelector("#postaction__form_action0");
    private By companyNameInput = By.cssSelector("#_idorganization_name");
    private String companyName = "Company";
    private By previewTitle = By.cssSelector("#main > div.postdlg > form > div.preview_box > div.l > div > div.vit > div > h1");
    private By previewCompanyType = By.cssSelector("#attr > div:nth-child(1) > div.i");
    private By previewEmploymentType = By.cssSelector("#attr > div:nth-child(3) > div.i");
    private By previewExperience = By.cssSelector("#attr > div:nth-child(5) > div.i");
    private By previewCompanyName = By.cssSelector("#attr > div:nth-child(2) > div.i");
    private By previewSchedule = By.cssSelector("#attr > div:nth-child(4) > div.i");
    private By previewSalary = By.cssSelector("#attr > div:nth-child(6) > div.i");
    private String expectedCompanyType = "Կազմակերպություն";
    private String expectedEmploymentType = "Մշտական";
    private String expectedExperience = "Փորձը պարտադիր չէ";
    private String expectedCompanyName = companyName;
    private String expectedSchedule = "Լրիվ աշխատանքային օր";
    private String expectedSalary = salary + " ֏";
    private By cancelJobCreate = By.cssSelector("#main > div.postdlg > form > div.fbtn > input.btncancel");
    private By organizationRadioForm = By.cssSelector("#fsec_0 > div:nth-child(2) > div > div.e > div");
    private String radioIdPrefix = "idstatus";

    public Add(WebDriver driver) {
        this.driver = driver;
    }

    public Add goPostJob() {
        (new WebDriverWait(driver, 10)).until((driver) -> (driver.findElements(postJob).size() > 0));
        driver.findElement(postJob).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(driver.findElement(offerJob)));
        driver.findElement(offerJob).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(driver.findElements(jobCategories).get(0)));
        driver.findElements(jobCategories).get(0).click();
        return new Add(driver);
    }

    public void fillFields() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((driver) -> (driver.findElements(organization).size() > 0));
        driver.findElement(organization).click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(companyNameInput)));
        driver.findElement(companyNameInput).sendKeys(companyName);
        driver.findElement(locationDropdown).click();
        driver.findElement(location).click();
        driver.findElement(employmentTypeDropdown).click();
        driver.findElement(permanentEmployment).click();
        driver.findElement(scheduleDropdown).click();
        driver.findElement(fullTimeJob).click();
        driver.findElement(experienceDropdown).click();
        driver.findElement(noExperience).click();
        driver.findElement(salaryInput).sendKeys(salary);
        driver.findElement(jobTitleInput).sendKeys(title);
        driver.findElement(jobDescriptionInput).sendKeys(description);
    }

    public Add clickPreview() {
        driver.findElement(preview).click();
        return new Add(driver);
    }

    public List<String> getPreviewData() {
        List<String> data = new ArrayList<>(6);
        data.add(driver.findElement(previewCompanyType).getText());
        data.add(driver.findElement(previewEmploymentType).getText());
        data.add(driver.findElement(previewExperience).getText());
        data.add(driver.findElement(previewCompanyName).getText());
        data.add(driver.findElement(previewSchedule).getText());
        data.add(driver.findElement(previewSalary).getText());
        return data;
    }

    public List<String> getExpectedData() {
        List<String> data = new ArrayList<>(6);
        data.add(expectedCompanyType);
        data.add(expectedEmploymentType);
        data.add(expectedExperience);
        data.add(expectedCompanyName);
        data.add(expectedSchedule);
        data.add(expectedSalary);
        return data;
    }

    public Profile clickCancelCreate() {
        driver.findElement(cancelJobCreate).click();
        return new Profile(driver);
    }

    public List<Boolean> getOrganizationRadioFormStates() {
        List<Boolean> states = new ArrayList<>();
        WebElement form = driver.findElement(organizationRadioForm);
        states.add(form.findElement(By.id(radioIdPrefix + 0)).isSelected());
        states.add(form.findElement(By.id(radioIdPrefix + 1)).isSelected());
        states.add(form.findElement(By.id(radioIdPrefix + 2)).isSelected());
        return states;
    }
}
