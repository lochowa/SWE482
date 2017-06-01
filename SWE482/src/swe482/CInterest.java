package swe482;


import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ubuntu2B
 */
public class CInterest implements java.awt.event.ActionListener {
    
    MInterest model;
    VInterest view;

    CInterest(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Interest Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Interest Model");
        model.incrementValue();
    }
    
    void addModel(MInterest m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Interest Model");
        this.model = m;
    }

    void addView(VInterest v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Interest View");
        this.view = v;
    } 
    
    void initModel(
            int dbRecordID,
            int dbPropertyREFID,
            int dbInterestID,
            int interest,
            String status,
            String[] owners,
            String address,
            String city ,
            String state ,
            int zipcode,
            String phone ,
            // TO DO:  Insert List<E> to contain Recorded Documents
            boolean active){
            model.setValues(0, 0, 0, 0);
            model.setOwner(0, null, null, null, null, null, 0, phone, active);
        
    }
}
