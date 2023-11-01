package staff;

public class CampOperator implements ICreateCamp,IDeleteCamp,IEditCamp
{
    //REMEMBER MIGHT NEED TO INCLUDE OPTION TO EDIT THE CAMP DETAILS.NOT J TOGGLE VISIBILITY.
    
    /*PENDING KAIXUAN CODE:
    private Staff staff; //Corresponding staff object that this belongs to.
    private IHisInterfaceName hisInterface;
    
    public CampOperator(Staff staff, IHisInterface hisInterface)
    {
        this.staff=staff;
        this.IHisInterface=hisInterface; we can use this to call all his implemented funcs.
    }


     */

    public void createCamp(Staff staff,CampInformation?? campInformation)
    {
        hisInterface.createCamp(staff,campInformation);
    }

    public void deleteCamp(Staff staff,int campId)
    {
        hisInterface.deleteCamp(staff,campId); //Possibly implement by calling getter for Array in staff and removing the campID? 
    }

    public void toggleVisibility(Staff staff,int campId)
    {
        hisInterface.toggleVisibility(staff,campId);//Similar to above
    }

}
