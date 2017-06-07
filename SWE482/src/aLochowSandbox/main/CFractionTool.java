package aLochowSandbox.main;
/**
 *
 * @author by Michael Barth
 */
import swe482_Main.*;
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
    public void actionPerformed(ActionEvent ae) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("FractionTool Controller: The " + ae.getActionCommand()
                + " button is clicked at " + new java.util.Date(ae.getWhen())
                + " with e.paramString: " + ae.paramString());

        System.out.println("Controller: Received Action Command: " + ae.getActionCommand());

        if (ae.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if(ae.getActionCommand().equals(Actions.CONVERTFRACTION.name())){
            try {
                double Numerator = Double.parseDouble(view.getTopNumber());
                double Denominator = Double.parseDouble(view.getBottomNumber());
                double Decimal = Numerator/Denominator;
                view.setDecimal(Decimal);
                model.setDecimal(Decimal);
            } catch (NumberFormatException e) {  
            }
        }
        
        if (ae.getActionCommand().equals(Actions.INSERTDECIMAL.name())){
            
            
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
    
    double getDecimal(){
        return model.getDecimal();
    }
}
