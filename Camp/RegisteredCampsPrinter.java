package camp;

import java.util.ArrayList;

public class RegisteredCampsPrinter implements IPrintRegisteredCamps
{
    private CampDataBase campDataBase;
    public RegisteredCampsPrinter(CampDataBase campDataBase)
    {
        this.campDataBase=campDataBase;
    }

    public void printRegisteredCamps(ArrayList<ArrayList<String>> registeredCampsRoles)
    {
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();
        //Look through camps, check if its in registered camps list. 
        //If found a matching one, print details, then print corresponding campRole.
        for(int i=0;i<allCamps.size();++i)
        {
            for(int j=0;j<registeredCampsRoles.size();++j)
            {
                if(allCamps.get(i).getCampName().equals(registeredCampsRoles.get(j).get(0)))//index 0 means campName of registered list, index 1 is corresponding role.
                {
                    //Only print if it's not filtered out.
                    if(!allCamps.get(i).getIsFilteredOut())
                    {
                        allCamps.get(i).printCamp();
                        System.out.printf("Your role in the above camp is %s.\n------------------------------------\n\n",registeredCampsRoles.get(j).get(1));
                        break;
                    }
                }
            }
        }
        System.out.println("------------ End of list -----------");
    }


}
