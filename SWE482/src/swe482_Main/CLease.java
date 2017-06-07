package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CLease implements java.awt.event.ActionListener {
    
    MLease model;
    VLease view;
    private enum Actions {
        SAVECONTENTS,
        CLOSEWINDOW,
        SEARCHNAME,
        ADDLEGALDESCRIPTION,
        LESSEECLIENT
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Lease Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Lease Model");
        
        if(e.getActionCommand().equals(Actions.CLOSEWINDOW.name())){
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if(e.getActionCommand().equals(Actions.ADDLEGALDESCRIPTION.name())){
            new MVCPlaceholder();
        }
        if(e.getActionCommand().equals(Actions.SEARCHNAME.name())){
            new MVCLessor();
        }
    }
    void addModel(MLease m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Lease Model");
        this.model = m;
    }

    void addView(VLease v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Lease View");
        this.view = v;
    } 
    
    void initModel(int dbRecordID,
            int dbLeaseholdID,
            String oopEffectiveDate,
            int bonusPNMNA,
            int paymentTerms,
            String paymentDueDate,
            int totalBonusPayment,
            int royalty,
            int primaryTerm,
            String primaryTermExpiration,
            boolean isOptional,
            int optionTerm,
            String optionalTermExpiration,
            String lessorName,
            String lessorAddress,
            String lessorCity,
            String lessorState,
            int lessorZipCode,
            String lesseeName,
            String lesseeAddress,
            String lesseeCity,
            String lesseeState,
            int lesseeZipCode) {
        model.setValues(
                dbRecordID, 
                dbLeaseholdID, 
                oopEffectiveDate, 
                bonusPNMNA, 
                paymentTerms, 
                paymentDueDate, 
                totalBonusPayment, 
                royalty, 
                primaryTerm, 
                primaryTermExpiration, 
                isOptional, 
                optionTerm, 
                optionalTermExpiration, 
                lessorName, 
                lessorAddress, 
                lessorCity, 
                lessorState, 
                lessorZipCode, 
                lesseeName, 
                lesseeAddress, 
                lesseeCity, 
                lesseeState, 
                lesseeZipCode);
        
    }
}
