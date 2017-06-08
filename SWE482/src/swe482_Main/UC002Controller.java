package swe482_Main;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author Michael Barth UC-002 UC002Controller Class Object
 * @param <E>
 */
public class UC002Controller<E> implements java.awt.event.ActionListener {

    UC002Model model;
    UC002View view;
    
    private final String doubleReg = "^(([1-9]{1}(\\d+)?)(\\.\\d+)?)|([0]\\.(\\d+)?([1-9]{1})(\\d+)?)$";
    private final String royaltyReg = "^[1]?\\.[0]{1,10}$||^[1]$||^\\.[0-9]{1,10}$";
    private final String integerReg = "^[0-9]{1,3}$";
    private final String zipCodeReg = "^[0-9]{1,6}";
    private final String dateReg = "^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/\\d{4}$";
    private final String streetReg = "^(\\d{3,})\\s?(\\w{0,5})\\s([a-zA-Z]{2,30})\\s([a-zA-Z]{2,15})\\.?\\s?(\\w{0,5})$";
    private final String stringReg = "^[a-zA-Z0-9\\040]+$";
    private final String stateReg = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$";

    void addModel(UC002Model m) {
        this.model = m;
    }

    void addView(UC002View v) {
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(UserActions.CLOSE_LEASE.name())) {
            System.out.println("Action Triggered: Close Lease");
             view.getDxuc007().dispose();
             view.getfUC002().dispose();
        }
        if (e.getActionCommand().equals(UserActions.OPEN_ADDPROPERTY.name())) {
            System.out.println("Action Triggered: Add Property");
            view.displayAddProperty(true);
        }
        if (e.getActionCommand().equals(UserActions.SAVE_LEASE.name())) {
            System.out.println("Action Triggered: Save Lease");

            // TO DO: Add Code to get ArrayList<Property> is empty
//            Implementing Try/Catch Statement for user input validation.
            this.feedbackLeaseForm();
            // TO DO: Wrap try/loop to execute based on boolean return on data validation.
            try {
                if (view.getXuc005_cbxAlternativePayee()){
                    if(!view.getXuc005_AlternatePayee().isEmpty() && !view.getXuc005_AlternatePayee().matches(stringReg)){
                        model.setIsAlternativePayee(view.getXuc005_cbxAlternativePayee());
                        model.setXuc005_AlternatePayee(view.getXuc005_AlternatePayee());
                    }
                } else {
                    model.setIsAlternativePayee(false);
                    model.setXuc005_AlternatePayee(null);
                }
                model.setUC002Values(
                        view.getXuc005_OOPDate().trim(),
                        Double.parseDouble(view.getXuc005_BPA().trim()),
                        Integer.parseInt(view.getXuc005_PaymentTerms().trim()),
                        Double.parseDouble(view.getXuc005_BonusSubtotal()),
                        view.getUc002_LeaseDate().trim(),
                        Double.parseDouble(view.getUc002_Royalty().trim()),
                        Integer.parseInt(view.getUc002_PrimaryTerm().trim()),
                        Integer.parseInt(view.getUc002_SecondaryTerm().trim()),
                        view.getUc002_Lessor().trim(),
                        view.getUc002_Address().trim(),
                        view.getUc002_City().trim(),
                        view.getUc002_State().trim(),
                        Integer.parseInt(view.getUc002_ZipCode().trim()),
                        view.getUc002_Lessee().trim());
                
                model.printUC002Values();
                model.sqlStatement();
                
            } catch (NumberFormatException f1) { return;
            }
        }
        if (e.getActionCommand().equals(UserActions.SEARCH_PERSON.name())) {
            System.out.println("Action Triggered: Search/Add Lessor");
        }
        
        if(e.getActionCommand().equals(UserActions.SEARCH_PROPERTY.name())){
            System.out.println("Action Triggered: Search/Add Property");
        }
        
        if(e.getActionCommand().equals(UserActions.INSERT_PROPERTY.name())){
            System.out.println("Action Triggered: Insert Property");
          
            
        // Need boolean to trigger try/catch loop code.    
         try{
            XUC007Property property = model.createXUCProperty(
                    Integer.parseInt(view.getXuc007_ParcelID()),
                    view.getXuc007_TaxMapID(),
                    view.getXuc007_County(),
                    view.getXuc007_State(),
                    Double.parseDouble(view.getXuc007_Acreage()),
                    view.getXuc007_Township(),
                    view.getXuc007_Range(),
                    Integer.parseInt(view.getXuc007_Section()),
                    view.getXuc007_Meridian(),
                    view.getXuc007_LegalDescription(),
                    view.getXuc007_cbxBounders(),
                    view.getXuc007_NorthBounder(),
                    view.getXuc007_EastBounder(),
                    view.getXuc007_SouthBounder(),
                    view.getXuc007_WestBounder()
            );
            model.addXuc007_LeasedProperty(property);
            model.incrementModCount();
        } catch (NumberFormatException f2) { 
            
        }}
        if(e.getActionCommand().equals(UserActions.CLOSE_ADDPROPERTY.name())){
            System.out.println("Action Triggered: Close Add Property Window");
               view.getDxuc007().dispose();
        }
    }

    private enum UserActions {
        SEARCH_PERSON,
        OPEN_ADDPROPERTY,
        CLOSE_LEASE,
        SAVE_LEASE,
        SEARCH_PROPERTY,
        INSERT_PROPERTY,
        CLOSE_ADDPROPERTY
    }
    
    private void feedbackLeaseForm() {
//            START Invalid User Feedback
        if (view.getXuc005_OOPDate().isEmpty() || !view.getXuc005_OOPDate().matches(dateReg)) {
            view.setXuc005_lblOOPDate(true);
        } else {
            view.setXuc005_lblOOPDate(false);
        }
        if (view.getXuc005_BPA().isEmpty() || !view.getXuc005_BPA().matches(doubleReg)) {
            view.setXuc005_lblBPA(true);
        } else {
            view.setXuc005_lblBPA(false);
        }
        if (view.getXuc005_PaymentTerms().isEmpty() || !view.getXuc005_PaymentTerms().matches(integerReg)) {
            view.setXuc005_lblPaymentTerms(true);
        } else {
            view.setXuc005_lblPaymentTerms(false);
        }
        if (view.getXuc005_BonusSubtotal().isEmpty() || !view.getXuc005_BonusSubtotal().matches(doubleReg)) {
            view.setXuc005_lblBonusSubtotal(true);
        } else {
            view.setXuc005_lblBonusSubtotal(false);
        }
        if (view.getXuc005_AlternatePayee().isEmpty() || !view.getXuc005_AlternatePayee().matches(stringReg)) {
            view.setXuc005_lblAlternativePayee(true);
        } else {
            view.setXuc005_lblAlternativePayee(false);
        }

        if (!view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty() && view.getXuc005_AlternatePayee().matches(stringReg)) {
                view.setXuc005_cbxAlternatePayee(true);
            }
        }
        if (view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty()
                    && view.getXuc005_AlternatePayee().matches(stringReg)) {
                view.setXuc005_cbxAlternatePayee(false);
            }
        }
        if (view.getUc002_Lessor().isEmpty() || !view.getUc002_Lessor().matches(stringReg)) {
            view.setUc002_lblLessor(true);
        } else {
            view.setUc002_lblLessor(false);
        }
        if (view.getUc002_Address().isEmpty() || !view.getUc002_Address().matches(streetReg)) {
            view.setUc002_lblAddress(true);
        } else {
            view.setUc002_lblAddress(false);
        }
        if (view.getUc002_City().isEmpty() || !view.getUc002_City().matches(stringReg)) {
            view.setUc002_lblCity(true);
        } else {
            view.setUc002_lblCity(false);
        }
        if (view.getUc002_State().isEmpty() || !view.getUc002_State().matches(stateReg)) {
            view.setUc002_lblState(true);
        } else {
            view.setUc002_lblState(false);
        }
        if (view.getUc002_ZipCode().isEmpty() || !view.getUc002_ZipCode().matches(zipCodeReg)) {
            view.setUc002_lblZipCode(true);
        } else {
            view.setUc002_lblZipCode(false);
        }
        if (view.getUc002_Lessee().isEmpty() || !view.getUc002_Lessee().matches(stringReg)) {
            view.setUc002_lblLessee(true);
        } else {
            view.setUc002_lblLessee(false);
        }
        if (view.getUc002_LeaseDate().isEmpty() || !view.getUc002_LeaseDate().matches(dateReg)) {
            view.setUc002_lblLeaseDate(true);
        } else {
            view.setUc002_lblLeaseDate(false);
        }
        if (view.getUc002_PrimaryTerm().isEmpty() || !view.getUc002_PrimaryTerm().matches(integerReg)) {
            view.setUc002_lblPrimaryTerm(true);
        } else {
            view.setUc002_lblPrimaryTerm(false);
        }
        if (view.getUc002_SecondaryTerm().isEmpty() || !view.getUc002_SecondaryTerm().matches(integerReg)) {
            view.setUc002_lblSecondaryTerm(true);
        } else {
            view.setUc002_lblSecondaryTerm(false);
        }
        if (view.getUc002_Royalty().isEmpty() || !view.getUc002_Royalty().matches(royaltyReg)) {
            view.setUc002_lblRoyalty(true);
        } else {
            view.setUc002_lblRoyalty(false);
        }

    }
}
