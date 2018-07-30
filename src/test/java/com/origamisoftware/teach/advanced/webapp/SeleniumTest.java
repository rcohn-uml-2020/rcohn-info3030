package com.origamisoftware.teach.advanced.webapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void DoTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8000/");
    }
}
