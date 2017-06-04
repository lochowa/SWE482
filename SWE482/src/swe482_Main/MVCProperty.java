package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MVCProperty {
    
    public static void main(String[] args) {
        // TODO code application logic here
        new MVCProperty();
    }
    

    public MVCProperty(){
        
        MProperty model = new MProperty();
        VProperty view = new VProperty();
        
        model.addObserver(view);
        
        CProperty controller = new CProperty();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, null, null, 0, null, null, 0, null, null, null, null, null, null);
        
        view.addController(controller);
        
    }
}
