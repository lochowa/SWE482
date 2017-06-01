/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe482;

/**
 *
 * @author Ubuntu2B
 */
public class MLeasehold extends java.util.Observable {
    
    void incrementValue() {
        ++counter;
    } // incrementValue()

    int getCounter() {
        return counter;
    } // getCounter()

    // Variable Declaration Area:  Do not change.
    private int counter; 
    private int dbRecordID;
    private int dbLeaseID;
    private String _OOPEffectiveDate;
    private int _BonusPNMA;
    private int _PaymentTerms;
    private String _PaymentDueDate;
    private int _TotalBonusPayment;
    private int _Royalty;
    private int _PrimaryTerm;
    private String _PrimaryTermExpiration;
    private int _OptionalTerm;
    private boolean _isOptionalTerm;
    private String _OptionalTermExpiration;
    private String _LessorName;
    private String _LessorAddress;
    private String _LessorCity;
    private String _LessorState;
    private int _LessorZipCode;
    private String _LesseeName;
    private String _LesseeAddress;
    private String _LesseeCity;
    private String _LesseeState;
    private int _LesseeZipCode;
    //TO DO Insert List<E> to contain leased Legal Descriptions
    // END Variable Declaration Area

    void setValues(
            int dbRecordID,
            int dbLeaseholdID,
            String oopEffectiveDate,
            int bonusPNMNA,
            int paymentTerms,
            String paymentDueDate,
            int totalBonusPayment,
            int royalty,
            int primaryTerm,
            String primaryTermExpiration,
            boolean isOptional,
            int optionTerm,
            String optionalTermExpiration,
            String lessorName,
            String lessorAddress,
            String lessorCity,
            String lessorState,
            int lessorZipCode,
            String lesseeName,
            String lesseeAddress,
            String lesseeCity,
            String lesseeState,
            int lesseeZipCode) {
        this.dbRecordID = dbRecordID;
        this.dbLeaseID = dbLeaseholdID;
        this._OOPEffectiveDate = oopEffectiveDate;
        this._BonusPNMA = bonusPNMNA;
        this._PaymentTerms = paymentTerms;
        this._PaymentDueDate = paymentDueDate;
        this._TotalBonusPayment = totalBonusPayment;
        this._Royalty = royalty;
        this._PrimaryTerm = primaryTerm;
        this._PrimaryTermExpiration = primaryTermExpiration;
        this._isOptionalTerm = isOptional;
        this._OptionalTerm = optionTerm;
        this._OptionalTermExpiration = optionalTermExpiration;
        this._LessorName = lessorName;
        this._LessorAddress = lessorAddress;
        this._LessorCity = lessorCity;
        this._LessorState = lessorState;
        this._LessorZipCode = lessorZipCode;
        this._LesseeName = lesseeName;
        this._LesseeAddress = lesseeAddress;
        this._LesseeCity = lesseeCity;
        this._LesseeState = lesseeState;
        this._LesseeZipCode = lesseeZipCode;
    }
            
    

}
