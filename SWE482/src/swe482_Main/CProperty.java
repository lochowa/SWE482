package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CProperty implements java.awt.event.ActionListener {

    MProperty model;
    VProperty view;
    
    CProperty(){
        
    }
     public enum Actions {
        ADDMINERALOWNER,
        ADDSURFACEOWNER,
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
        System.out.println("Propety Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Property Model");
        
        if((e.getActionCommand().equals(Actions.ADDMINERALOWNER.name()))){
            new MVCMineralRTI();
        }
        
        if (e.getActionCommand().equals(Actions.ADDSURFACEOWNER.name())){
            new MVCSurfaceRTI();
        }
        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if (e.getActionCommand().equals(Actions.SAVEPROPERTY.name())){
            String recID = view.getDBRecordID();
            int parcelID = view.getParcelID();
            String taxmap = view.getTaxMapID();
            String county = view.getCounty();
            String st = view.getCounty();
            String description = view.getDescription();
            int acreage = view.getAcreage();
            String township = view.getTownship();
            String range = view.getRange();
            int section = view.getSection();
            String PM = view.getPM();
            String bnorth = view.getbNorth();
            String bsouth = view.getbSouth();
            String beast = view.getbEast();
            String bwest = view.getbWest();
            System.out.print(recID);
            model.setValues(recID,parcelID,taxmap,county,st,acreage,township,range,section,PM,description,bnorth,beast,bsouth,bwest);
            System.out.print(recID);
            model.committoDB();
        }
    }
    
    void addModel(MProperty m){
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Property Model");
        this.model = m;       
    }
    
    void addView(VProperty v){
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Property View");
        this.view = v;
    }

    void initModel(
            String dbRecordID,
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
            String b_west){
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
                    b_west);
    }

}
