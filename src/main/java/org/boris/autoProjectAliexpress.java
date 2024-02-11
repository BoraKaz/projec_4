package org.boris;

import org.openqa.selenium.chrome.ChromeDriver;

public class autoProjectAliexpress {
    String URL = "https://www.aliexpress.us/";
    seleniumBase base = new seleniumBase();
    ChromeDriver driver = base.seleniumInit(URL);
}
