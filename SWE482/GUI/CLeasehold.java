/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApp.mvccompliant;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author Ubuntu2B
 */
public class CLeasehold implements java.awt.event.ActionListener {

    MLeasehold model;
    VLeasehold view;
    
    private enum Actions {
        SAVELEASEHOLD,
        CLOSEWINDOW
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
        model.incrementValue();

        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
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
            int leasedAcreage,
            String currentLessee,
            String currentShallowDepthRights,
            String specificShallowDepthRestrictions,
            String currentDeepDepthRights,
            String specificDeepDepthRestrictions
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
                leasedAcreage,
                currentLessee,
                currentShallowDepthRights,
                specificShallowDepthRestrictions,
                currentDeepDepthRights,
                specificDeepDepthRestrictions
        );

    }
}
