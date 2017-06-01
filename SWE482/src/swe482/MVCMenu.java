/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe482;

/**
 *
 * @author Ubuntu2B
 */
public class MVCMenu {
        public static void main(String[] args) {
        // TODO code application logic here
        new MVCMenu();
    }
        
            public MVCMenu(){
        
        MMenu model = new MMenu();
        VMenu view = new VMenu();
        
        model.addObserver(view);
        
        CMenu controller = new CMenu();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel("NOACTIONCOMMAND");
        
        view.addController(controller);
        
    }
}
