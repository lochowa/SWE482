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
public class MVCLeasehold {
    public static void main(String[] args) {
        // TODO code application logic here
        new MVCLeasehold();
    }
        public MVCLeasehold(){
            
        MLeasehold model = new MLeasehold();
        VLeasehold view = new VLeasehold();
        model.addObserver(view);
        
        CLeasehold controller = new CLeasehold();
        
        controller.addModel(model);
        controller.addView(view);
        //  Initialise Model attribute values.
        controller.initModel(0, null, null, 0, null, 0, null, false, 0, null, null, null, null, null);
        
        view.addController(controller);    
}
}
