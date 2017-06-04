package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MFractionTool extends java.util.Observable {
    
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
}
