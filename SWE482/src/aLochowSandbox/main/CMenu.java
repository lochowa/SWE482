package aLochowSandbox.main;
/**
 *
 * @author by Michael Barth
 */
import swe482_Main.*;
import java.awt.event.ActionEvent;

public class CMenu implements java.awt.event.ActionListener {
    MMenu model;
    VMenu view;

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Menu Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Received Action Command: " + e.getActionCommand());
        
        if(e.getActionCommand().equals("CLOSEWINDOW")){
            System.exit(0);
        }
        
        switch (e.getActionCommand()) {

            case "PROJECT_CONFIGURATION":
                // TO DO: Connect MVC Function class here.
                break;

            case "ADD_PROPERTY":
                // TO DO: Connect MVC Function class here.
                new MVCProperty();
                break;

            case "ADD_PLACEHOLDER_PROPERTY":
                // TO DO: Connect MVC Function class here.
                new MVCPlaceholder();
                break;

            case "ADD_LEASE":
                // TO DO: Connect MVC Function class here.
                new MVCLease();
                break;

            case "DISTRIBUTE_OWNERSHIP_RTI":
                // TO DO: Connect MVC Function class here.
                break;

            case "MODIFY_OWNER_RECORD":
                // TO DO: Connect MVC Function class here.
                break;

            case "CREATE_PROJECT_REPORT":
                // TO DO: Connect MVC Function class here.
                break;

            case "CREATE_LEASE_PURCHASE_REPORT":
                // TO DO: Connect MVC Function class here.
                break;

            case "QUERY_RECORDS":
                // TO DO: Connect MVC Function class here.
                break;

            default:
                break;
            
        }
    }

    void addModel(MMenu m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Interest Model");
        this.model = m;
    }

    void addView(VMenu v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Interest View");
        this.view = v;
    }
    
    void initModel(String command){
        model.setValues(command);
    }
    
}
