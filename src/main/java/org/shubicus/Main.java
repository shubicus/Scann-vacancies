package org.shubicus;

import org.shubicus.entities.Djinni;
import org.shubicus.entities.Dou;

public class Main {

    public static void main(String[] args) {
        new Thread(new Djinni()).start();
        new Thread(new Dou()).start();
    }

}