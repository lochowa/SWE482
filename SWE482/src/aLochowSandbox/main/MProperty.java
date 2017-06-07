package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MProperty extends java.util.Observable {

    MProperty() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Property()");

    }   // MProperty()

    // Variable Declaration Area:  Do not change.

    private int dbRecordID;
    private int parcelID;
    private String taxMapID;
    private String county;
    private String state;
    private int acreage;
    private String township;
    private String range;
    private int section;
    private String PM;
    private String description;
    private final String[] bounders = new String[4];
    // TO DO: Create List<E> to hold RTI MInterest recods
    // END Variable Declaration Area
 
    void setValues(
            int dbRecordID,
            int parcelID,
            String taxMapID,
            String county,
            String state,
            int acreage,
            String township,
            String range,
            int section,
            String PM,
            String description,
            String b_north,
            String b_east,
            String b_south,
            String b_west
    // TO DO: Integrate List<E>
    ) {

        this.dbRecordID = dbRecordID;
        this.parcelID = parcelID;
        this.taxMapID = taxMapID;
        this.county = county;
        this.state = state;
        this.acreage = acreage;
        this.township = township;
        this.range = range;
        this.section = section;
        this.PM = PM;
        this.description = description;
        this.bounders[0] = b_north;
        this.bounders[1] = b_east;
        this.bounders[2] = b_south;
        this.bounders[3] = b_west;
        // TO DO: Create List<E> to hold RTI MInterest recods

    }
    // setValues()

}
