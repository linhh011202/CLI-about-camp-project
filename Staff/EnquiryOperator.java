package staff;

public class EnquiryOperator 
{
     /*PENDING KAIXUAN CODE:
    private Staff staff; //Corresponding staff object that this belongs to.
    private IHisInterfaceName hisInterface;
    
    public EnquiryOperator(Staff staff, IHisInterface hisInterface)
    {
        this.staff=staff;
        this.IHisInterface=hisInterface; we can use this to call all his implemented funcs.
    }
    */

    public void viewEnquiries(Staff staff,int campId)
    {
        //We can make error checking in this class to ensure staff only views from campID within his owned camps. Or maybe KX wna error check inside his func
        boolean isCampCreatedByHim=false;
        for(Camp camp:staff.getCamps())
        {
            if(camp.getID()==campID) isCampCreatedByHim=true;
        }

        if(!isCampCreatedByHim)
        {
            //Handle error/throwexception
        } 
        hisInterface.viewEnquiries(staff,campId);
    }
    

    public void replyEnquiries(Staff staff,int campId,SOMEENQUIRYIDENTIFIER? enquiryIdentifier,String reply)
    {
        //error checking same as above
         for(Camp camp:staff.getCamps())
        {
            if(camp.getID()==campID) isCampCreatedByHim=true;
        }

        if(!isCampCreatedByHim)
        {
            //Handle error/throwexception
        } 

        hisInterface.replyEnquiries(staff,campId,suggestionIdentifier,reply); //Assuming campclass AGAIN implements the interface for this :/
    }
}
