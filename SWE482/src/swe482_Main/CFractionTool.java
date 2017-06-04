package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class CFractionTool implements java.awt.event.ActionListener {

    MFractionTool model;
    VFractionTool view;

    private enum Actions {
        CLOSEWINDOW,
        INSERTDECIMAL,
        CONVERTFRACTION
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("FractionTool Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Received Action Command: " + e.getActionCommand());
        model.incrementValue();

        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if(e.getActionCommand().equals(Actions.CONVERTFRACTION.name())){
            
        }
    }

    void addModel(MFractionTool m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding FractionTool Model");
        this.model = m;
    }

    void addView(VFractionTool v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding FractionTool View");
        this.view = v;
    }

    void initModel(
            double firstNumber,
            double secondNumber) {
        model.setValues(
                firstNumber,
                secondNumber);
    }
}
