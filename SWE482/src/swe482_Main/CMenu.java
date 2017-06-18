package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;

public class CMenu implements java.awt.event.ActionListener {
    MMenu model;
    VMenu view;
    
    public enum UserActions {
        START_FUNCTION,
        CLOSE_MENU
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Menu Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Received Action Command: " + e.getActionCommand());
        
        if(e.getActionCommand().equals(UserActions.CLOSE_MENU.name())){
            System.exit(0);
        }
        
        if (e.getActionCommand().equals("ADD_ABSTRACT_TITLE_PACKAGE")){
                    UC001MVC mvcProperty = new UC001MVC();
        }
        
        if (e.getActionCommand().equals("ADD_PAID-UP_LEASE")){
                    UC002MVC mvcLease = new UC002MVC();
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
