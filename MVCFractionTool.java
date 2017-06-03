package JavaApp.mvccompliant;
/**
 *
 * @author by Michael Barth
 */
public class MVCFractionTool {
    public static void main(String[] args) {
        // TODO code application logic here
        new MVCFractionTool();
    }

    public MVCFractionTool() {

        MFractionTool model = new MFractionTool();
        VFractionTool view = new VFractionTool();

        model.addObserver(view);

        CFractionTool controller = new CFractionTool();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0);
        view.addController(controller);

    }
}
