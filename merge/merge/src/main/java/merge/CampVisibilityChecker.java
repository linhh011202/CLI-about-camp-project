package merge;

public class CampVisibilityChecker implements ICheckCampVisibility
{
    private CampDataBase campDataBase;
    
    public CampVisibilityChecker(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public boolean isCampVisible(String campName)
    {
        //Check if camp is visible.
        for(int i=0;i<campDataBase.getAllCamps().size();++i)
        {
            if(campDataBase.getAllCamps().get(i).getCampName().equals(campName))
            {
                if(campDataBase.getAllCamps().get(i).getVisibility())
                {
                    return true;
                }
                else
                {
                    System.out.println("Registration failed! Unable to find camp.\n");
                    return false;
                }
            }
        }

        //Camp doesnt exist. return false.
        System.out.println("Registration failed! Unable to find camp.\n");
        return false;
    }

}
