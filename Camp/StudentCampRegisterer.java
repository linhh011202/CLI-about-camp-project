package camp;

import java.util.ArrayList;


public class StudentCampRegisterer implements IRegisterCamp
{
    private RegistrationDataBase registrationDataBase;
    private IGetCampSlots campStudentSlotChecker;
    private IReduceCampSlots campStudentSlotReducer;
    

    public StudentCampRegisterer(RegistrationDataBase registrationDataBase,IGetCampSlots campStudentSlotChecker,IReduceCampSlots campStudentSlotReducer)
    {
        this.registrationDataBase=registrationDataBase;
        this.campStudentSlotChecker=campStudentSlotChecker;
        this.campStudentSlotReducer=campStudentSlotReducer;
    }

    public void RegisterCamp(Student student,String campName)
    {
        //Before creating a registration entry, uses Interface from campDB to check to see if camp has enough REGULAR slots.
        int slots=campStudentSlotChecker.getCampSlots(campName);
        if(slots==IntErrorCodes.CAMP_NOT_FOUND)
        {
            System.out.println("Failed to register. There is no such camp with this camp name!");
            return;
        }
        if(slots==IntErrorCodes.INSUFFICIENT_STUDENT_SLOTS)
        {
            System.out.println("Failed to register. There are no more student slots left!");
            return;
        }

        //Check existing registration database if student has already registered before.
        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();
        for(int i=0;i<allRegistrations.size();++i)
        {
            if(allRegistrations.get(i).getCampName().equals(campName) && allRegistrations.get(i).getStudentName().equals(student.getName()))
            {
                System.out.println("Failed to register. You have deregistered from this camp before! Unable to register again.");
                return;
            }
        }

        //Slots avail since it passed error checking, registration created and added to database. Reduce avail camp attendee slots.
        registrationDataBase.getAllRegistrations().add(new Registration(student.getName(), campName,"Camp Attendee")); 
        campStudentSlotReducer.reduceCampSlots(campName);
    }
}

