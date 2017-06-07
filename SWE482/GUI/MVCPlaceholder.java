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
public class MVCPlaceholder {
        public static void main(String[] args) {
        // TODO code application logic here
        new MVCPlaceholder();
    }
    

    public MVCPlaceholder(){
        
        MPlaceholder model = new MPlaceholder();
        VPlaceholder view = new VPlaceholder();
        
        model.addObserver(view);
        
        CPlaceholder controller = new CPlaceholder();
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, 0, null, null, null, 0, null, null, 0, null, null, null, null, null, null, false);
        
        view.addController(controller);
        
    }
}
