package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class CMineralRTI implements java.awt.event.ActionListener {
    
    MMineralRTI model;
    VMineralRTI view;

    CMineralRTI(){
        
    }
    public enum Actions {
        ADDLEASEBURDEN,
        SEARCHNAME,
        CONVERTFRACTION,
        ADDINSTRUMENT,
        SAVEINTEREST,
        CLOSEWINDOW
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("MineralRTI Controller: The " + e.getActionCommand()
        + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());
        
        System.out.println("Controller: Acted on MineralRTI Model");
        model.incrementValue();
        
        if (e.getActionCommand().equals(Actions.CLOSEWINDOW.name())) {
            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
        
        if(e.getActionCommand().equals(Actions.ADDLEASEBURDEN.name())){
            new MVCLeasehold();
        }
        if(e.getActionCommand().equals(Actions.ADDINSTRUMENT.name())){
            new MVCDocument();
        }
        if(e.getActionCommand().equals(Actions.CONVERTFRACTION.name())){
            new MVCFractionTool();
        }
    }
    
    void addModel(MMineralRTI m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding MineralRTI Model");
        this.model = m;
    }

    void addView(VMineralRTI v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding MineralRTI View");
        this.view = v;
    } 
    
    void initModel(
            int dbRecordID,
            int interest,
            String status,
            String name1,
            String name2,
            String name3,
            String name4,
            String address,
            String city ,
            String state ,
            int zipcode,
            String phone ,
            // TO DO:  Insert List<E> to contain Recorded Documents
            boolean active){
            model.setValues(0, 0, null, null, null, null, null, null, null, null, 0, null, false);
        
    }
}