package JavaApp.mvccompliant;
/**
 *
 * @author by Michael Barth
 */
public class MFractionTool extends java.util.Observable {
    
    MFractionTool() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model FractionTool()");
    }

    void incrementValue() {
        ++counter;
    } // incrementValue()

    int getCounter() {
        return counter;
    } // getCounter()

    // Variable Declaration Area:  Do not change.
    private int counter;
    private double topNumber;
    private double bottomNumber;
    private double decimal;

    void setValues(
            double topNumber,
            double bottomNumber) {
        ++counter;
        this.topNumber = topNumber;
        this.bottomNumber = bottomNumber;
        notifyObservers(counter);
    }
}
