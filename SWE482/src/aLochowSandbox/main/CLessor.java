package aLochowSandbox.main;
/**
 *
 * @author by Michael Barth
 */
import swe482_Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CLessor implements java.awt.event.ActionListener {

    MLessor model;
    VLessor view;

    CLessor() {

    }

    private enum Actions {
        ADDINSTRUMENT,
        INSERTLESSOR,
        CLOSEWINDOW,
        ACTIVESTATUSCHANGE
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("MineralRTI Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Acted on MineralRTI Model");

        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }

        if (e.getActionCommand().equals(Actions.ADDINSTRUMENT.name())) {
            new MVCDocument();
        }
    }

    void addModel(MLessor m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding MineralRTI Model");
        this.model = m;
    }

    void addView(VLessor v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding MineralRTI View");
        this.view = v;
    }

    void initModel(
            int dbRecordID,
            int interest,
            String status,
            String name1,
            String name2,
            String name3,
            String name4,
            String address,
            String city,
            String state,
            int zipcode,
            String phone,
            // TO DO:  Insert List<E> to contain Recorded Documents
            boolean active) {
        model.setValues(0, 0, null, null, null, null, null, null, null, null, 0, null, false);
        // TO DO:  Update setValues() to include Recorded Documents.
        
    }
}
