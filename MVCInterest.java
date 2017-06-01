package JavaApp.mvccompliant;

/**
 *
 * @author by Michael Barth
 */
public class MVCInterest {


    public static void main(String[] args) {
        // TODO code application logic here
        new MVCInterest();
    }
        public MVCInterest(){
            
                    MInterest model = new MInterest();
        VInterest view = new VInterest();
        model.addObserver(view);
        
        CInterest controller = new CInterest();
        
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, 0, 0, null, null, null, null, null, 0, null, true);
        
        view.addController(controller);    
}
}
