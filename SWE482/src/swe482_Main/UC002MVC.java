package swe482_Main;

/**
 *
 * @author Michael Barth
 UC-002 UC002MVC Launch Class Object
 */
public class UC002MVC {
        public static void main(String[] args) {
                UC002View view = new UC002View();
            UC002Model model = new UC002Model();
             UC002Controller controller = new UC002Controller();
            controller.addModel(model);
            controller.addView(view);
            view.addController(controller);
}
}