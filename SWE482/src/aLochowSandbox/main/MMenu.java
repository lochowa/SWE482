package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MMenu extends java.util.Observable {

    MMenu() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Menu()");

    }

    void setValues(String command) {
        this.command = command;
    }
    // Variable Declaration Area:  Do not change.
    private int counter;
    private String command;

    // END Variable Declaration Area
}
