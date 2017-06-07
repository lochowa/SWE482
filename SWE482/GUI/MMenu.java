package JavaApp.mvccompliant;

/**
 *
 * @author by Michael Barth
 */
public class MMenu extends java.util.Observable {
    
    void incrementValue() {
        ++counter;
    } // incrementValue()

    int getCounter() {
        return counter;
    } // getCounter()
    
    MMenu(){ 
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Menu()");

    }
    
    void setValues(String command){
        this.command = command;
    }
    // Variable Declaration Area:  Do not change.
    private int counter;
    private String command;
    
    // END Variable Declaration Area
}
