package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MVCFractionTool {
    public static void main(String[] args) {
        // TODO code application logic here
        MVCFractionTool mvcFractionTool = new MVCFractionTool();
    }
    
    MFractionTool model = new MFractionTool();
    VFractionTool view = new VFractionTool();
    CFractionTool controller = new CFractionTool();
    
    public MVCFractionTool() {


        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0);
        view.addController(controller);

    }

    double returnDouble(){
        return controller.getDecimal();
    }
}
