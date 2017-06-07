package aLochowSandbox.main;
/**
 *
 * @author by Michael Barth
 */
import swe482_Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CSurfaceRTI implements java.awt.event.ActionListener {

    MSurfaceRTI model;
    VSurfaceRTI view;

    private enum Actions {
        INSERTOWNER,
        CLOSEWINDOW,
        SEARCHNAME,
        CHANGESTATUS,
        ADDRECORDEDDOCUMENT
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("SurfaceRTI Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Acted on SurfaceRTI Model");

        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if (e.getActionCommand().equals(Actions.ADDRECORDEDDOCUMENT.name())){
            new MVCDocument();
        }
    }

    void addModel(MSurfaceRTI m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding SurfaceRTI Model");
        this.model = m;
    }

    void addView(VSurfaceRTI v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding SurfaceRTI View");
        this.view = v;
    }

    void initModel(
            int dbRecord,
            String name1,
            String name2,
            String name3,
            String name4,
            String address,
            String city,
            String state,
            int zipcode,
            String phone) {
        model.setValues(0, null, null, null, null, null, null, null, 0, null);

    }
}
