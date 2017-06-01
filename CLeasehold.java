package JavaApp.mvccompliant;

import java.awt.event.ActionEvent;

/**
 *
 * @author by Michael Barth
 */
public class CLeasehold implements java.awt.event.ActionListener {
    
    MLeasehold model = new MLeasehold();
    VLeasehold view = new VLeasehold();

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Interest Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Interest Model");
        model.incrementValue();
        
        if(e.getActionCommand().equals("CLOSEWINDOW")){
            view.setVisible(false);
        }
    
    }
        void addModel(MLeasehold m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Interest Model");
        this.model = m;
    }

    void addView(VLeasehold v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Interest View");
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
