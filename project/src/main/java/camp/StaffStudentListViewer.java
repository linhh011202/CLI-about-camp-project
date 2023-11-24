package camp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import registration.IGetStudentNamesRolesRegistered;

/** 
 * Represents a class prints the list of students and their respective roles for a specified camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffStudentListViewer implements IViewStudentList
{
    /**
     * This StaffStudentListViewer's associated camp dataabase object.
     */
    private CampDataBase campDataBase;

    /**
     * The interface this StaffStudentListViewer needs to retrieve the student names and roles from the registration database.
     */
    private IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter;

    /**
     * Creates a new StaffStudentListViewer with the required interfaces and associated camp database.
     * @param campDataBase This StaffStudentListViewer's associated camp database.
     * @param registeredStudentNamesRolesGetter The interface from Registration database that his StaffStudentListViwer uses to obtain the student roles list.
     */
    public StaffStudentListViewer(CampDataBase campDataBase, IGetStudentNamesRolesRegistered registeredStudentNamesRolesGetter)
    {
        this.campDataBase=campDataBase;
        this.registeredStudentNamesRolesGetter=registeredStudentNamesRolesGetter;
    }

    public void viewStudentList(String staffName, String campName)
    {
        ArrayList<Camp> allCamps=campDataBase.getAllCamps();
        Camp foundCamp=null;
        for(int i=0;i<allCamps.size();++i)
        {
            if(allCamps.get(i).getStaffInCharge().equals(staffName) && allCamps.get(i).getCampName().equals(campName))
            {
                foundCamp=allCamps.get(i);
            }
        }
        //Ensure staff had valid access to that camp first.
        if(foundCamp==null)
        {
            System.out.printf("Error! Camp not found. Camp either does not exist or is not created by you!\n");
            return;
        }

        ArrayList<ArrayList<String>> studentsRoles=registeredStudentNamesRolesGetter.getRegisteredStudentNamesRoles(foundCamp.getCampName());

        //Check if there is anything to print.
        if(studentsRoles.size()==0)
        {
            System.out.printf("There are no students registered for that camp!\n");
            return;
        }
        System.out.printf("Here are the list of registered students and their roles for that camp:\n");
        System.out.printf("---------------------------------------------\n");
        
        for(int i=0;i<studentsRoles.size();++i)
        {
            System.out.printf("|Name: %s ||Role: %s |\n",studentsRoles.get(i).get(0),studentsRoles.get(i).get(1));
        }

        System.out.printf("-----------------END OF LIST-----------------\n\n");

    }
}