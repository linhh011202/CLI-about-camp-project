package registration;

import camp;
import enquiries;
import misc;
import suggestions;
import user;

import java.util.ArrayList;

public interface IGetCampsRegistered 
{
    public ArrayList<String> getRegisteredCampNames(String studentName);
    
}
