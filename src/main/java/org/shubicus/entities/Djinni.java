package org.shubicus.entities;

import com.codeborne.selenide.SelenideDriver;

import static org.shubicus.utils.SelenideDriverFactory.getSelenideDriver;

public class Djinni extends Job {

    private final static SelenideDriver SELENIDE_DRIVER_DJINNI = getSelenideDriver("https://djinni.co/jobs/?all-keywords=&any-of-keywords=&exclude-keywords=&primary_keyword=QA+Automation");

    public Djinni() {
        super(SELENIDE_DRIVER_DJINNI);
    }

    @Override
    public void run() {
        super.search();
    }

    @Override
    public String getElementInfo() {
        return SELENIDE_DRIVER_DJINNI.$("a.profile").getAttribute("href");
    }

    @Override
    public void printLink() {
        System.out.println("The new link " + getElementInfo());
    }
}
