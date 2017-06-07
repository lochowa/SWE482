package aLochowSandbox.main;

import swe482_Main.*;

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

        CLeasehold controller = new CLeasehold();
        
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, null, null, 0, null, 0, null, false, 0, 0, null, null, null, null, null);
        // TO DO:  Update initModel() arguments to include Document Object initialization.
        view.addController(controller);    
}
}
