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
public class MLeasehold extends java.util.Observable {

    MLeasehold() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Leasehold()");
    }

    void incrementValue() {
        ++counter;
    } // incrementValue()

    int getCounter() {
        return counter;
    } // getCounter()

    // Variable Declaration Area:  Do not change.
    private int counter;
    private int dbRecordID;
    private String lessor;
    private String lessee;
    private int primaryTerm;
    private String primaryTermExpiration;
    private int optionalTerm;
    private String optionalTermExpiration;
    private boolean isOptional;
    private int leasedAcreage;
    private String currentLessee;
    private String currentShallowDepthRights;
    private String specificShallowDepthRestrictions;
    private String currentDeepDepthRights;
    private String specificDeepDepthRestrictions;

    void setValues(
            int dbRecordID,
            String lessor,
            String lessee,
            int primaryTerm,
            String primaryTermExpiration,
            int optionalTerm,
            String optionalTermExpiration,
            boolean isOptional,
            int leasedAcreage,
            String currentLessee,
            String currentShallowDepthRights,
            String specificShallowDepthRestrictions,
            String currentDeepDepthRights,
            String specificDeepDepthRestrictions
    ) {
        this.dbRecordID = dbRecordID;
        this.lessor = lessor;
        this.lessee = lessee;
        this.primaryTerm = primaryTerm;
        this.primaryTermExpiration = primaryTermExpiration;
        this.optionalTerm = optionalTerm;
        this.optionalTermExpiration = optionalTermExpiration;
        this.isOptional = isOptional;
        this.leasedAcreage = leasedAcreage;
        this.currentLessee = currentLessee;
        this.currentShallowDepthRights = currentShallowDepthRights;
        this.specificShallowDepthRestrictions = specificShallowDepthRestrictions;
        this.currentDeepDepthRights = currentDeepDepthRights;
        this.specificDeepDepthRestrictions = specificDeepDepthRestrictions;

    }
}
