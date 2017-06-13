package swe482_Main;

import java.util.ArrayList;
/**
 *
 * @author by Michael Barth
 */
public class MMineralRTI extends java.util.Observable {

    MMineralRTI() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model MineralRTI()");
    }

    // Variable Declaration Area:  Do not change.
    private boolean _Active;
    private int _RecordIdentification;
    private double _OwnerRTI;
    private String _Status;
    private final String[] _OwnerNames = new String[4];
    /*
     * _OwnerName[0] = Name_1
     * _OwnerName[1] = Name_2
     * _OwnerName[2] = Name_3
     * _OwnerName[3] = Name_4
    */
    private final String[] _OwnerAddress = new String[4];
    /*
     * _OwnerAddress[0] = Street Address
     * _OwnerAddress[1] = City
     * _OwnerAddress[2] = State
     * _OwnerAddress[3] = ZipCode
    */
    private String _ContactNumber;
    private ArrayList<MDocument> Documents = new ArrayList<>();

    // END Variable Declaration Area
    void setValues(
            boolean Active,
            int RecordIdentification,
            double ownerRTI,
            String Status,
            String Name1,
            String Name2,
            String Name3,
            String Name4,
            String Address,
            String City,
            String State,
            String ZipCode,
            String ContactNumber) {
        this._Active = Active;
        this._OwnerRTI = ownerRTI;
        this._Status = Status;
        this._OwnerNames[0] = Name1;
        this._OwnerNames[1] = Name2;
        this._OwnerNames[2] = Name3;
        this._OwnerNames[3] = Name4;
        this._OwnerAddress[0] = Address;
        this._OwnerAddress[1] = City;
        this._OwnerAddress[2] = State;
        this._OwnerAddress[3] = ZipCode;
    }

    void addDocument(MDocument Document){
        Documents.add(Document);
    }
}
