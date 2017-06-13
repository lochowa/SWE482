package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CDocument implements java.awt.event.ActionListener {

    MDocument model;
    VDocument view;
    
    private enum Actions {
        INSERTDOCUMENT,
        CLOSEWINDOW
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Document Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Acted on Lease Model");

        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        
        if (e.getActionCommand().equals(Actions.INSERTDOCUMENT.name())){
            System.out.println("Validating Data");
            if(this.validateData(view)){
                System.out.println("Document View: Valid User Input");
            } else System.out.println("Invalid Data");
        }

    }

    void addModel(MDocument m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Document Model");
        this.model = m;
    }

    void addView(VDocument v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Document View");
        this.view = v;
    }

    //  MVC initializes values to the Model.
    void initModel(
            int RecordIdentification,
            String DocumentType,
            String EffectiveDate,
            String RecordedDate,
            int ReceptionNumber,
            int Book,
            int Page) {
        model.setValues(RecordIdentification, DocumentType, EffectiveDate, RecordedDate, ReceptionNumber, Book, Page);
    }
    
    boolean validateData(VDocument v){
        //  Using Try/Catch for Data Validation.
        boolean isValid = false;
        int validInt;
        try{
            if (!v.getReceptionNumber().isEmpty()){
                validInt = Integer.parseInt(v.getReceptionNumber().trim());
            } else {
                // Change field label color to RED.
            }
            if (!v.getBook().isEmpty()){
                validInt = Integer.parseInt(v.getBook().trim());
            } else {
                // Change field label color to RED.
            }
            if (!v.getPage().isEmpty()){
                validInt = Integer.parseInt(v.getBook().trim());
            }
            String regex = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$";
            if (!v.getEffectiveDate().isEmpty() && v.getEffectiveDate().trim().matches(regex) &&
                !v.getRecordingDate().isEmpty() && v.getRecordingDate().trim().matches(regex)
                ){
                isValid = true;
            }
        } catch (NumberFormatException e) { return isValid; }
        return isValid;
        }
    
    
}
