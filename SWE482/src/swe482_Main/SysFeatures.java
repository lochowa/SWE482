package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class SysFeatures {
    
    private enum Features{

        ADD_PROPERTY,
//        ADD_PLACEHOLDER_PROPERTY,
        ADD_LEASE,
//        DISTRIBUTE_OWNERSHIP_RTI,
//        MODIFY_OWNER_RECORD,
//        CREATE_PROJECT_REPORT,
//        CREATE_LEASE_PURCHASE_REPORT,
//        PROJECT_CONFIGURATION,
//        QUERY_RECORDS
    }

    private static final String[] List = new String[Features.values().length];
    
    String[] buildList(){
        int index = 0;
        for(Features f : Features.values()){
            List[index] = f.name().replaceAll("_", " "); index++;
   
        }      return List;
    }

}
