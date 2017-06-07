package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MVCDocument {

    public static void main(String[] args) {
        // TODO code application logic here
        new MVCDocument();
    }

    public MVCDocument() {

        MDocument model = new MDocument();
        VDocument view = new VDocument();

        CDocument controller = new CDocument();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, null, null, null, 0, 0, 0);

        view.addController(controller);

    }
}
