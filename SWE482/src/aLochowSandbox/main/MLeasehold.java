package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MLeasehold extends java.util.Observable {

    MLeasehold() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Leasehold()");
    }

    // Variable Declaration Area:  Do not change.
    private int dbRecordID;
    private String lessor;
    private String lessee;
    private int primaryTerm;
    private String primaryTermExpiration;
    private int optionalTerm;
    private String optionalTermExpiration;
    private boolean isOptional;
    private double royalty;
    private int leasedAcreage;
    private String currentLessee;
    private String currentShallowDepthRights;
    private String specificShallowDepthRestrictions;
    private String currentDeepDepthRights;
    private String specificDeepDepthRestrictions;
    // TO DO: Add List<E> to contain Recorded Document REF numbers.

    void setValues(
            int dbRecordID,
            String lessor,
            String lessee,
            int primaryTerm,
            String primaryTermExpiration,
            int optionalTerm,
            String optionalTermExpiration,
            boolean isOptional,
            double royalty,
            int leasedAcreage,
            String currentLessee,
            String currentShallowDepthRights,
            String specificShallowDepthRestrictions,
            String currentDeepDepthRights,
            String specificDeepDepthRestrictions
            // TO DO: Add code to include Recorded Document objects.
    ) {
        this.dbRecordID = dbRecordID;
        this.lessor = lessor;
        this.lessee = lessee;
        this.primaryTerm = primaryTerm;
        this.primaryTermExpiration = primaryTermExpiration;
        this.optionalTerm = optionalTerm;
        this.optionalTermExpiration = optionalTermExpiration;
        this.isOptional = isOptional;
        this.royalty = royalty;
        this.leasedAcreage = leasedAcreage;
        this.currentLessee = currentLessee;
        this.currentShallowDepthRights = currentShallowDepthRights;
        this.specificShallowDepthRestrictions = specificShallowDepthRestrictions;
        this.currentDeepDepthRights = currentDeepDepthRights;
        this.specificDeepDepthRestrictions = specificDeepDepthRestrictions;
        // TO DO: Add code to include Recorded Document objects.
    }
}
