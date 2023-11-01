package staff;

public class SuggestionOperator implements IViewSuggestions,IApproveSuggestions
{
    /*PENDING KAIXUAN CODE:
    private Staff staff; //Corresponding staff object that this belongs to.
    private IHisInterfaceName hisInterface;
    
    public SuggestionOperator(Staff staff, IHisInterface hisInterface)
    {
        this.staff=staff;
        this.IHisInterface=hisInterface; we can use this to call all his implemented funcs.
    }
    */

    public void viewSuggestions(Staff staff,int campId)
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
        hisInterface.viewSuggestions(staff,campId);
    }
    

    public void approveSuggestions(Staff staff,int campId,SOMESUGGESTIONIDENTIFIER? suggestionIdentifier)
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

        hisInterface.approveSuggestions(staff,campId,suggestionIdentifier); //HOW IS THIS GONN WORK? will the camp class handle suggestions too and give us an interface to work with?
    }
}
