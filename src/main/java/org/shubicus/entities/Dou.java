package org.shubicus.entities;

import com.codeborne.selenide.SelenideDriver;

import static org.shubicus.utils.SelenideDriverFactory.getSelenideDriver;

public class Dou extends Job {

    private final static SelenideDriver SELENIDE_DRIVER_DOU = getSelenideDriver("https://jobs.dou.ua/vacancies/?search=Automation");

    public Dou() {
        super(SELENIDE_DRIVER_DOU);
    }

    @Override
    public void run() {
        super.search();
    }

    @Override
    public String getElementInfo() {
        return SELENIDE_DRIVER_DOU.$(".b-inner-page-header>h1").getText();
    }

    @Override
    public void printLink() {
        System.out.println("Open url " + SELENIDE_DRIVER_DOU.getWebDriver().getCurrentUrl());
    }
}
