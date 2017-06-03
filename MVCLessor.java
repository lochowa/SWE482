package JavaApp.mvccompliant;
/**
 *
 * @author by Michael Barth
 */
public class MVCLessor {

    public static void main(String[] args) {
        // TODO code application logic here
        new MVCLessor();
    }

    public MVCLessor() {

        MLessor model = new MLessor();
        VLessor view = new VLessor();
        model.addObserver(view);

        CLessor controller = new CLessor();

        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, null, null, null, null, null, null, null, 0, null, false);
        // TO DO:  Update initModel() arguments to include Recorded Document.
        view.addController(controller);
    }
}
