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
public class SysFeatures {
    
    private enum Features{
        PROJECT_CONFIGURATION,
        ADD_PROPERTY,
        ADD_PLACEHOLDER_PROPERTY,
        ADD_LEASE,
        DISTRIBUTE_OWNERSHIP_RTI,
        MODIFY_OWNER_RECORD,
        CREATE_PROJECT_REPORT,
        CREATE_LEASE_PURCHASE_REPORT,
        QUERY_RECORDS
    }
    
    private static final String[] List = new String[Features.values().length];
    
    String[] buildList(){
        int index = 0;
        for(Features f : Features.values()){
            List[index] = f.name().replaceAll("_", " "); index++;
   
        }      return List;
    }

}
