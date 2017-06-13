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
            this.updateOwnerRTI(Double.toString(new MVCFractionTool().returnDouble()));
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
            boolean Active,
            int RecordIdentification,
            int ownerRTI,
            String Status,
            String Name1,
            String Name2,
            String Name3,
            String Name4,
            String Address,
            String City ,
            String State ,
            String ZipCode,
            String ContactNumber){
        model.setValues(Active, RecordIdentification, ownerRTI, Status, Name1, Name2, Name3, Name4, Address, City, State, State, ContactNumber);
    }
    
    void updateModel(){

    }
    
    void addDocument(MDocument Document){
        model.addDocument(Document);
    }
    
    void updateOwnerRTI(String RTI){
        view.setOwnerRTI(RTI);
    }
}
