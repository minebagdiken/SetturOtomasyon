import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods extends DriverManager {
    private static final WebDriver driver = DriverManager.driver;
    private static final WebDriverWait webDriverWait = DriverManager.webDriverWait;

    private boolean clicked = false;

    public WebElement findElement(By by) {
        if (!clicked) clickIfExist(By.id("close-button-1454703513202"));

        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void click(By by) {

        try {
            findElement(by).click();
        } catch (ElementClickInterceptedException e) {
            findElement(by).click();

        }

    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }


    public void waitSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public boolean doesPageContainText(String text) {
        return driver.getPageSource().contains(text);
    }


    public boolean isElementVisibleWithoutLog(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {

        }
        return false;
    }

    public void clickIfExist(By by) {
        try {
            setWebDriverWait(3, 500);
            if (isElementVisibleWithoutLog(by))
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
            clicked = true;
        } catch (TimeoutException e) {
            setWebDriverWait(30, 500);
        }
    }


    public void setWebDriverWait(int second, int millis) {
        webDriverWait.withTimeout(Duration.ofSeconds(second))
                .pollingEvery(Duration.ofMillis(millis))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public void clickRandomDigerBolge() {
        By digerBolgelerLocator = By.cssSelector("[title*='(']");
        List<WebElement> digerBolgelerList = findElements(digerBolgelerLocator);

        if (!digerBolgelerList.isEmpty()) {
            int randomIndex = new Random().nextInt(digerBolgelerList.size());
            WebElement randomElement = digerBolgelerList.get(randomIndex);
            randomElement.click();
        }
    }

}