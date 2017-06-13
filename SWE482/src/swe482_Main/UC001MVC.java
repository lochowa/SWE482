package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class UC001MVC {
    
    public static void main(String[] args) {
        // TODO code application logic here
        UC001MVC uC001MVC = new UC001MVC();
    }
    

    public UC001MVC(){
        
        UC001Model model = new UC001Model();
        UC001View view = new UC001View();
        
        UC001Controller controller = new UC001Controller();
        controller.addModel(model);
        controller.addView(view);
        view.addController(controller);
        //  Initialise Model attribute values.
        controller.initModel(null, 0, null, null, null, 0, null, null, 0, null, null, null, null, null, null);
                
    }
}
