package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class UC001Controller implements java.awt.event.ActionListener {

    UC001Model model;
    UC001View view;
    
    UC001Controller(){ }
    
    public enum UserActions {
        OPEN_SURFACEOWNER,
        OPEN_MINERALOWNER,
        SEARCH_PROPERTY,
        CLOSE_ABSTRACT,
        CLOSE_SURFACEOWNER,
        CLOSE_MINERALOWNER,
        INSERT_SURFACEOWNER,
        INSERT_MINERALOWNER,
        EDIT_SURFACEOWNER,
        EDIT_MINERALOWENR,
        SAVE_ABSTRACT
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Propety Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Property Model");
        
        if((e.getActionCommand().equals(UserActions.OPEN_MINERALOWNER.name()))){
            new MVCMineralRTI();
        }
        
        if (e.getActionCommand().equals(UserActions.OPEN_SURFACEOWNER.name())){
            new MVCSurfaceRTI();
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_ABSTRACT.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        if (e.getActionCommand().equals(UserActions.SAVE_ABSTRACT.name())){
            System.out.print(view.getDBRecordID());
            model.setValues(view.getDBRecordID(), Integer.parseInt(view.geXuc001tParcelID()),view.getXuc001TaxAccountID()
                    ,view.getXuc001County(),view.getXuc001State(),view.getXuc001Acreage(),view.getXuc001Township()
                    ,view.getXuc001Range(),Integer.parseInt(view.getXuc001Section()),view.getXuc001Meridian(),view.getXuc001Description()
                    ,view.getXuc001NorthBounder(),view.getXuc001EastBounder(),view.getXuc001SouthBounder(), view.getXuc001WestBounder());
            model.committoDB();
        }
    }
    
    void addModel(UC001Model m){
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Property Model");
        this.model = m;       
    }
    
    void addView(UC001View v){
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
