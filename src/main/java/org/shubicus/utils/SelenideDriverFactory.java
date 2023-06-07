package org.shubicus.utils;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;

public class SelenideDriverFactory {

    public static SelenideDriver getSelenideDriver(String baseUrl) {
        return new SelenideDriver(new SelenideConfig()
                .baseUrl(baseUrl)
                .headless(true));
    }
}
