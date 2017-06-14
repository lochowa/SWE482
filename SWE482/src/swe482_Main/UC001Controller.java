package swe482_Main;
/**
 *
 * @author by Michael Barth
 * @modifications by Andrew Lochow (See save button section)
 */
import java.awt.event.ActionEvent;


public class UC001Controller implements java.awt.event.ActionListener {

    UC001Model model;
    UC001View view;
    private final String doubleRegEx = "^(([1-9]{1}(\\d+)?)(\\.\\d+)?)|([0]\\.(\\d+)?([1-9]{1})(\\d+)?)$";
    private final String royaltyRegEx = "^[1]?\\.[0]{1,10}$||^[1]$||^\\.[0-9]{1,10}$";
    private final String integerRegEx = "^[0-9]{1,3}$";
    private final String parcelIDRegEx = "^[0-9]{1,20}";
    private final String zipCodeRegEx = "^[0-9]{1,6}";
    private final String dateRegEx = "^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/\\d{4}$";
    private final String streetAddressRegEx = "^(\\d{3,})\\s?(\\w{0,5})\\s([a-zA-Z]{2,30})\\s([a-zA-Z]{2,15})\\.?\\s?(\\w{0,5})$";
    private final String descriptionRegEx = "^(a-z|A-Z|0-9)*[^#$%^&*()']*";
    private final String stringRegEx = "^[a-zA-Z0-9\\040]+$";
    private final String stateAbbreviationRegEx = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$";
    private final String townshipRegEx = "^([1-9][0-9]{1,2})[N|S]$"; // ## + W|West E|East S|South N|North
    private final String rangeRegEx = "^([1-9][0-9]{1,2})[E|W]$";   // ## + W|West E|East S|South N|North
    private final String sectionRegEx = "^[1-6]$|^[1][0-9]$|^[2][0-9]$|^[3][0-6]$"; // 1 - 36 only
    UC001Controller(){ }
    
    public enum UserActions {
        OPEN_SURFACEOWNER,
        OPEN_MINERALOWNER,
        SEARCH_PROPERTY,
        SEARCH_PERSON,
        CLOSE_ABSTRACT,
        CLOSE_SURFACEOWNER,
        CLOSE_MINERALOWNER,
        INSERT_SURFACEOWNER,
        INSERT_MINERALOWNER,
        EDIT_SURFACEOWNER,
        EDIT_MINERALOWENR,
        SAVE_ABSTRACT,
        REMOVE_SURFACEOWNER,
        REMOVE_MINERALOWNER,
        OPEN_DOCUMENT,
        INSERT_DOCUMENT,
        CLOSE_DOCUMENT,
        OPEN_BURDEN,
        CLOSE_BURDEN
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Propety Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on Property Model");
        
        
        if((e.getActionCommand().equals(UserActions.OPEN_MINERALOWNER.name()))){
            view.getMineralDialog().setVisible(true);
        }
        
        if (e.getActionCommand().equals(UserActions.OPEN_SURFACEOWNER.name())){
            view.getSurfaceDialog().setVisible(true);
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_ABSTRACT.name())) {
            view.getSurfaceDialog().dispose();
            view.getMineralDialog().dispose();
            view.getAbstractTitleFrame().dispose();
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_SURFACEOWNER.name())){
            view.getSurfaceDialog().dispose();
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_MINERALOWNER.name())){
            view.getMineralDialog().dispose();
        }
        //Save actions modified by Andrew Lochow for managing Database input
        if (e.getActionCommand().equals(UserActions.SAVE_ABSTRACT.name())){
                     
            model.setValues(Integer.parseInt(view.geXuc001tParcelID()),view.getXuc001TaxAccountID()
                    ,view.getXuc001County(),view.getXuc001State(),view.getXuc001Acreage(),view.getXuc001Township()
                    ,view.getXuc001Range(),Integer.parseInt(view.getXuc001Section()),view.getXuc001Meridian(),view.getXuc001Description()
                    ,view.getXuc001NorthBounder(),view.getXuc001EastBounder(),view.getXuc001SouthBounder(), view.getXuc001WestBounder());
            model.committoDB();
        }
        if(e.getActionCommand().equals(UserActions.OPEN_BURDEN.name())){
            view.getBurdenDialog().setVisible(true);
        }
        if(e.getActionCommand().equals(UserActions.CLOSE_BURDEN.name())){
            view.getBurdenDialog().dispose();
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
                    //dbRecordID,
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
