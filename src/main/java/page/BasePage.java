package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage extends Page {

    private static final String USER_ICON_XPATH ="a[@class='header__header__account-user--icon___1k48U']";

    @FindBy( xpath = "//div[contains(@class,'header__header__logo___2h_2V')]")
    private WebElement logo;
    @FindBy( xpath = "//" + USER_ICON_XPATH + "/*[name()='svg']")
    private WebElement userAccountIcon;
    @FindBy( xpath = "//*[contains(@class,'dropdown-toggler')]")
    private WebElement arrowIcon;
    @FindBy( xpath = "//*[contains(@class,'dropdown-list--item')]")
    private List<WebElement> dropdownListItems;
    @FindBy( xpath = "//span[@class='sidebar__menu-item___1MMsk']")
    private List<WebElement> sidebarItems;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public boolean dropdownItemExist(String name){
        return findDropdownItem(name) != null;
    }

    public boolean sidebarItemExist(String name){
        return findSidebarItem(name) != null;
    }

    public void clickUserAccountIcon(){
        userAccountIcon.click();
    }

    public void clickArrowIcon(){
        arrowIcon.click();
    }

    public void clickDropdownItem(String name){
        WebElement resultItem = findDropdownItem(name);
        if(resultItem!=null){
            resultItem.click();
        }
    }

    public void clickSidebarItem(String name){
        WebElement resultItem = findSidebarItem(name);
        if(resultItem!=null){
            resultItem.click();
        }
    }

    public boolean waitVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private WebElement findDropdownItem(String name){
        for (WebElement dropdownListItem : dropdownListItems) {
            if(dropdownListItem.findElement(By.xpath(USER_ICON_XPATH)).getText().equalsIgnoreCase(name)) {
                return dropdownListItem;
            }
        }
        return null;
    }

    private WebElement findSidebarItem(String name){
        for (WebElement sidebarItem : sidebarItems) {
            if(sidebarItem.getText().equals(name)) return sidebarItem;
        }
        return null;
    }


}
