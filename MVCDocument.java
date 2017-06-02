/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApp.mvccompliant;

/**
 *
 * @author Ubuntu2B
 */
public class MVCDocument {

    public static void main(String[] args) {
        // TODO code application logic here
        new MVCDocument();
    }

    public MVCDocument() {

        MDocument model = new MDocument();
        VDocument view = new VDocument();

        model.addObserver(view);

        CDocument controller = new CDocument();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, null, null, null, 0, 0, 0);

        view.addController(controller);

    }
}
