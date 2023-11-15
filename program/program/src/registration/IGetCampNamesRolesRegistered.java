package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

import java.util.ArrayList;

public interface IGetCampNamesRolesRegistered 
{
    public ArrayList<ArrayList<String>> getRegisteredCampNamesRoles(String studentName);
}
