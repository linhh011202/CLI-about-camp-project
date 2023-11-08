package camp;

import java.util.ArrayList;

public class StudentCampDeregisterer implements IDeregisterCamp
{
    private RegistrationDataBase registrationDataBase;
    private IIncreaseCampSlots campStudentSlotIncreaser;

    public StudentCampDeregisterer(RegistrationDataBase registrationDataBase,IIncreaseCampSlots campStudentSlotIncreaser)
    {
        this.registrationDataBase=registrationDataBase;
        this.campStudentSlotIncreaser=campStudentSlotIncreaser;
    }

    
    public void deregisterCamp(Student student,String campName)
    {
        //Finds the corresponding entry in the ArrayList. If not found, unable to deregister.
        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();
        for(int i=0;i<allRegistrations.size();++i)
        {
            //Find matching entry.
            if(allRegistrations.get(i).getStudentName().equals(student.getName()) && allRegistrations.get(i).getCampName().equals(campName))
            {

                //Check if already deregistered
                if(allRegistrations.get(i).getDeregistered())
                {
                    System.out.printf("You have already deregistered from this camp!\n");
                    return;
                }
                //Check if campCom
                if(allRegistrations.get(i).getRole().equals("Camp Committee"))
                {
                    System.out.printf("Deregistration failed! You are a camp commoittee member and cannot withdraw from this camp!\n");
                    return;
                }

                //Passed error checks, so we deregister student and increase back the available slots.
                allRegistrations.get(i).setDeregistered(true);
                campStudentSlotIncreaser.increaseCampSlots(campName);
                System.out.printf("Successfully deregistered from camp! Camp name: %s\n",campName);
                return;
            }
        }

        System.out.printf("Deregistration failed! Unable to find records of you being registered for that camp!\n");
        return;
    }
}