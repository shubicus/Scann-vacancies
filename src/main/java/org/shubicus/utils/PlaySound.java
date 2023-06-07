package org.shubicus.utils;

import org.tinylog.Logger;

import static com.codeborne.selenide.Selenide.sleep;
import static java.awt.Toolkit.getDefaultToolkit;

public class PlaySound {

    private static final Runnable RUNNABLE_SOUND =
            (Runnable) getDefaultToolkit().getDesktopProperty("win.sound.exclamation");

    public static void playSound() {
        Logger.info("Lets play the music.");
        for (int i = 0; i < 10; i++) {
            RUNNABLE_SOUND.run();
            sleep(2_000);
        }
    }
}
