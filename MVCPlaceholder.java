package JavaApp.mvccompliant;
/**
 *
 * @author by Michael Barth
 */
public class MVCPlaceholder {
        public static void main(String[] args) {
        // TODO code application logic here
        new MVCPlaceholder();
    }
    

    public MVCPlaceholder(){
        
        MPlaceholder model = new MPlaceholder();
        VPlaceholder view = new VPlaceholder();
        
        model.addObserver(view);
        
        CPlaceholder controller = new CPlaceholder();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, null, null, 0, null, null, 0, null, null, null, null, null, null, false);
        
        view.addController(controller);
        
    }
}
