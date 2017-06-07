package JavaApp.mvccompliant;

/**
 *
 * @author by Michael Barth
 */
public class MVCMineralRTI {


    public static void main(String[] args) {
        // TODO code application logic here
        new MVCMineralRTI();
    }
        public MVCMineralRTI(){
            
                    MMineralRTI model = new MMineralRTI();
        VMineralRTI view = new VMineralRTI();
        model.addObserver(view);
        
        CMineralRTI controller = new CMineralRTI();
        
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, null, null, null, null, null, null, null, 0, null, false);
        
        view.addController(controller);    
}
}
