package aLochowSandbox.main;
/**
 *
 * @author by Michael Barth
 */
import swe482_Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CLeasehold implements java.awt.event.ActionListener {

    MLeasehold model;
    VLeasehold view;
    
    private enum Actions {
        SAVELEASEHOLD,
        CLOSEWINDOW,
        ADDINSTRUMENT
    }
    void addModel(MLeasehold m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Leasehold Model");
        this.model = m;
    }

    void addView(VLeasehold v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Leasehold View");
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Leasehold Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Acted on Leasehold Model");

        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if(e.getActionCommand().equals(Actions.ADDINSTRUMENT.name())){
            new MVCDocument();
        }
    }

    void initModel(
            int dbRecordID,
            String lessor,
            String lessee,
            int primaryTerm,
            String primaryTermExpiration,
            int optionalTerm,
            String optionalTermExpiration,
            boolean isOptional,
            int royalty,
            int leasedAcreage,
            String currentLessee,
            String currentShallowDepthRights,
            String specificShallowDepthRestrictions,
            String currentDeepDepthRights,
            String specificDeepDepthRestrictions
            //TO DO: Add code to include Recorded Document object.
    ) {
        model.setValues(
                dbRecordID,
                lessor,
                lessee,
                primaryTerm,
                primaryTermExpiration,
                optionalTerm,
                optionalTermExpiration,
                isOptional,
                royalty,
                leasedAcreage,
                currentLessee,
                currentShallowDepthRights,
                specificShallowDepthRestrictions,
                currentDeepDepthRights,
                specificDeepDepthRestrictions
                //TO DO: Add code to include Recorded Document object.
        );

    }
}
