package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

import java.util.ArrayList;

//It prints the camps AND the roles, can consider making the name more specific.
public interface IPrintRegisteredCamps 
{
    public void printRegisteredCamps(ArrayList<ArrayList<String>> registeredCampsRoles);
}
