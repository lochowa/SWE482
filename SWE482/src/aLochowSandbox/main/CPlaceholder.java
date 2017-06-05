package aLochowSandbox.main;
/**
 *
 * @author by Michael Barth
 */
import swe482_Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CPlaceholder implements java.awt.event.ActionListener{
        MPlaceholder model;
        VPlaceholder view;
    
         public enum Actions {
        DISPLAYBOUNDERS,
        SAVEPROPERTY,
        CBOTOWNSHIPCHANGE,
        CBORANGECHANGE,
        CBOMERIDIANCHANGE,
        CLOSEWINDOW

    }
           
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Placeholder Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Property Model");  

        if(e.getActionCommand().equals(Actions.CLOSEWINDOW.name())){
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        
    }
    
    void addModel(MPlaceholder m){
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Placeholder Model");
        this.model = m;       
    }
    
    void addView(VPlaceholder v){
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Placeholder View");
        this.view = v;
    }

    void initModel(
            int dbRecordID,
            int parcelID,
            String taxMapID,
            String county,
            String state,
            int acreage,
            String township,
            String range,
            int section,
            String PM,
            String description,
            String b_north,
            String b_east,
            String b_south,
            String b_west,
            boolean titled){
            // TO DO: Include List<E> Parameter Here.
            
            model.setValues(
                    dbRecordID,
                    parcelID,
                    taxMapID,
                    county,
                    state,
                    acreage,
                    township,
                    range,
                    section,
                    PM,
                    description,
                    b_north,
                    b_east,
                    b_south,
                    b_west,
                    titled);
    }
}
