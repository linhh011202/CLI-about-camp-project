package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

import java.util.ArrayList;

public interface IGetStudentNamesRolesRegistered 
{
    public ArrayList<ArrayList<String>> getRegisteredStudentNamesRoles(String campName);
}
