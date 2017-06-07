package swe482_Main;

import java.awt.event.ActionEvent;

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

        }
        if (e.getActionCommand().equals(UserActions.OPEN_ADDPROPERTY.name())) {
            System.out.println("Action Triggered: Add Property");
            view.displayAddProperty(true);
        }
        if (e.getActionCommand().equals(UserActions.SAVE_LEASE.name())) {
            System.out.println("Action Triggered: Save Lease");

            // TO DO: Add Code to get ArrayList<Property> is empty
//            Implementing Try/Catch Statement for user input validation.
            this.userInputFeedback();
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
                
            } catch (NumberFormatException nf) { return;
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
        }
        if(e.getActionCommand().equals(UserActions.CLOSE_ADDPROPERTY.name())){
            System.out.println("Action Triggered: Close Add Property Window");
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
    
    private void userInputFeedback() {
//            START Invalid User Feedback
        if (view.getXuc005_OOPDate().isEmpty() || !view.getXuc005_OOPDate().matches(dateReg)) {
            view.setXuc005_lblOOPDate(1);
        } else {
            view.setXuc005_lblOOPDate(0);
        }
        if (view.getXuc005_BPA().isEmpty() || !view.getXuc005_BPA().matches(doubleReg)) {
            view.setXuc005_lblBPA(1);
        } else {
            view.setXuc005_lblBPA(0);
        }
        if (view.getXuc005_PaymentTerms().isEmpty() || !view.getXuc005_PaymentTerms().matches(integerReg)) {
            view.setXuc005_lblPaymentTerms(1);
        } else {
            view.setXuc005_lblPaymentTerms(0);
        }
        if (view.getXuc005_BonusSubtotal().isEmpty() || !view.getXuc005_BonusSubtotal().matches(doubleReg)) {
            view.setXuc005_lblBonusSubtotal(1);
        } else {
            view.setXuc005_lblBonusSubtotal(0);
        }
        if (view.getXuc005_AlternatePayee().isEmpty() || !view.getXuc005_AlternatePayee().matches(stringReg)) {
            view.setXuc005_lblAlternativePayee(1);
        } else {
            view.setXuc005_lblAlternativePayee(0);
        }

        if (!view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty() && view.getXuc005_AlternatePayee().matches(stringReg)) {
                view.setXuc005_cbxAlternatePayee(1);
            }
        }
        if (view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty()
                    && view.getXuc005_AlternatePayee().matches(stringReg)) {
                view.setXuc005_cbxAlternatePayee(0);
            }
        }
        if (view.getUc002_Lessor().isEmpty() || !view.getUc002_Lessor().matches(stringReg)) {
            view.setUc002_lblLessor(1);
        } else {
            view.setUc002_lblLessor(0);
        }
        if (view.getUc002_Address().isEmpty() || !view.getUc002_Address().matches(streetReg)) {
            view.setUc002_lblAddress(1);
        } else {
            view.setUc002_lblAddress(0);
        }
        if (view.getUc002_City().isEmpty() || !view.getUc002_City().matches(stringReg)) {
            view.setUc002_lblCity(1);
        } else {
            view.setUc002_lblCity(0);
        }
        if (view.getUc002_State().isEmpty() || !view.getUc002_State().matches(stateReg)) {
            view.setUc002_lblState(1);
        } else {
            view.setUc002_lblState(0);
        }
        if (view.getUc002_ZipCode().isEmpty() || !view.getUc002_ZipCode().matches(zipCodeReg)) {
            view.setUc002_lblZipCode(1);
        } else {
            view.setUc002_lblZipCode(0);
        }
        if (view.getUc002_Lessee().isEmpty() || !view.getUc002_Lessee().matches(stringReg)) {
            view.setUc002_lblLessee(1);
        } else {
            view.setUc002_lblLessee(0);
        }
        if (view.getUc002_LeaseDate().isEmpty() || !view.getUc002_LeaseDate().matches(dateReg)) {
            view.setUc002_lblLeaseDate(1);
        } else {
            view.setUc002_lblLeaseDate(0);
        }
        if (view.getUc002_PrimaryTerm().isEmpty() || !view.getUc002_PrimaryTerm().matches(integerReg)) {
            view.setUc002_lblPrimaryTerm(1);
        } else {
            view.setUc002_lblPrimaryTerm(0);
        }
        if (view.getUc002_SecondaryTerm().isEmpty() || !view.getUc002_SecondaryTerm().matches(integerReg)) {
            view.setUc002_lblSecondaryTerm(1);
        } else {
            view.setUc002_lblSecondaryTerm(0);
        }
        if (view.getUc002_Royalty().isEmpty() || !view.getUc002_Royalty().matches(royaltyReg)) {
            view.setUc002_lblRoyalty(1);
        } else {
            view.setUc002_lblRoyalty(0);
        }

    }
}
