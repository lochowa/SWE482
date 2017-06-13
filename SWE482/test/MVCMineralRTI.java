package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MVCMineralRTI {

    public static void main(String[] args) {
        // TODO code application logic here
        MVCMineralRTI mvcMineralRTI = new MVCMineralRTI();
    }

    public MVCMineralRTI() {

        MMineralRTI model = new MMineralRTI();
        VMineralRTI view = new VMineralRTI();

        CMineralRTI controller = new CMineralRTI();

        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(true, 0, 0, null, null, null, null, null, null, null, null, null, null);

        view.addController(controller);
}
}
