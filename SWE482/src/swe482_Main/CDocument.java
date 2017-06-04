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
        SAVEDOCUMENT,
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

    void initModel(
            int dbRecordID,
            String docType,
            String effectiveDate,
            String recordingDate,
            int documentID,
            int book,
            int page) {
        model.setValues(
                dbRecordID,
                docType,
                effectiveDate,
                recordingDate,
                documentID,
                book,
                page);
    }
}
