package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MVCLease {
    
    public static void main(String[] args) {
        // TODO code application logic here
        new MVCLease();
    }
        public MVCLease(){
            
        MLease model = new MLease();
        VLease view = new VLease();

        CLease controller = new CLease();
        
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, 0, 0, null, 0, 0, 0, null, false, 0, null, null, null, null, null, 0, null, null, null, null, 0);
        
        view.addController(controller);    
}
}
