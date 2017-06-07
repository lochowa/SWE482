package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MFractionTool{
    
    MFractionTool() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model FractionTool()");
    }

    // Variable Declaration Area:  Do not change.
    private double topNumber;
    private double bottomNumber;
    private double decimal;

    void setValues(
            double topNumber,
            double bottomNumber) {
        this.topNumber = topNumber;
        this.bottomNumber = bottomNumber;
    }

    public double getTopNumber() {
        return topNumber;
    }

    public void setTopNumber(double topNumber) {
        this.topNumber = topNumber;
    }

    public double getBottomNumber() {
        return bottomNumber;
    }

    public void setBottomNumber(double bottomNumber) {
        this.bottomNumber = bottomNumber;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }
}
