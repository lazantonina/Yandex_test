package com.example.testtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");
    }

    protected void filterItem(Item item) {
        click(By.cssSelector("[href^='/catalog--"+ item.getItemType() +"']"));

        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());

        //click(By.cssSelector("[name$=Apple]"));
        //By.xpath("//div[@class='LhMupC0dLR']//span[text()='Apple']")
        //By.xpath("//span[text()='Apple']"
        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }

    protected void selectComputers() {
        click(By.cssSelector("[href*='kompiuternaia-tekhnika']"));
    }

    protected void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        if(text!=null) {
            wd.findElement(locator).sendKeys(text);
        }
    }

    private void openSite(String url) {
        wd.navigate().to(url);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void switchToNextTab() {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
    }
}
