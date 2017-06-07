package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MVCSurfaceRTI {
            public static void main(String[] args) {
        // TODO code application logic here
        new MVCSurfaceRTI();
    }
        
            public MVCSurfaceRTI(){
        
        MSurfaceRTI model = new MSurfaceRTI();
        VSurfaceRTI view = new VSurfaceRTI();

        CSurfaceRTI controller = new CSurfaceRTI();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        
        view.addController(controller);
        
    }
}
