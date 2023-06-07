package org.shubicus.entities;

import com.codeborne.selenide.SelenideDriver;
import org.tinylog.Logger;

import static com.codeborne.selenide.Selenide.sleep;
import static org.shubicus.utils.PlaySound.playSound;

public abstract class Job implements Runnable {

    public SelenideDriver selenideDriver;

    public Job(SelenideDriver selenideDriver) {
        this.selenideDriver = selenideDriver;
    }

    public abstract String getElementInfo();

    public abstract void printLink();

    @SuppressWarnings("InfiniteRecursion")
    public void search() {
        String firstInfo = getInfo();
        String actualInfo;
        Logger.info("Starting the new search on " + this.getClass().getName());

        do {
            sleep(200_000L);
            actualInfo = getInfo();
        } while (actualInfo.equals(firstInfo));

        printLink();
        playSound();
        search();
    }

    public String getInfo() {
        try {
            selenideDriver.open("/");
        } catch (org.openqa.selenium.TimeoutException e) {
            Logger.warn("There was a problem opening the URL " + selenideDriver.getWebDriver().getCurrentUrl());
            sleep(300_000L);
            getInfo();
        }
        return getElementInfo();
    }
}
