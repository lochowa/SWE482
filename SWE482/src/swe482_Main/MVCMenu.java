package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MVCMenu {
    public static void main(String[] args) {
        // TODO code application logic here
        MVCMenu mvcMenu = new MVCMenu();
    }

    public MVCMenu() {

        MMenu model = new MMenu();
        VMenu view = new VMenu();

        CMenu controller = new CMenu();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel("NOACTIONCOMMAND");

        view.addController(controller);

    }
}
