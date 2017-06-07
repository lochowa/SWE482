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
        model.incrementValue();

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
