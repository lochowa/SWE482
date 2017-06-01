package JavaApp.mvccompliant;

/**
 *
 * @author by Michael Barth
 */
public class MVCLeasehold {
    
    public static void main(String[] args) {
        // TODO code application logic here
        new MVCLeasehold();
    }
        public MVCLeasehold(){
            
        MLeasehold model = new MLeasehold();
        VLeasehold view = new VLeasehold();
        model.addObserver(view);
        
        CLeasehold controller = new CLeasehold();
        
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, 0, 0, null, 0, 0, 0, null, false, 0, null, null, null, null, null, 0, null, null, null, null, 0);
        
        view.addController(controller);    
}
}
