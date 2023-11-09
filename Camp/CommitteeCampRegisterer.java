package camp;

import java.util.ArrayList;

//IMPORTANT- to utilise the method to register as campCom, you must assign the old student reference to its return value.
//This is to allow the returning of a promoted CampCom object, or the Student Object again(only if function fails to register as campCom)
//Use as such: 
//Student student=new Student(insert constructor)
//student=student.registerCampCommittee(campName)
//must assign return value to old student reference

public class CommitteeCampRegisterer implements IRegisterCommittee
{
    private RegistrationDataBase registrationDataBase;
    private IGetCampSlots campCommitteeSlotChecker;
    private ICheckSchoolMatch checkSchoolMatch;
    private ICheckRegistrationClosed registrationClosedChecker;
    private IGetCampsRegistered registeredCampNamesGetter;
    private ICheckNoClash clashWithRegisteredChecker;
    private IReduceCampSlots campCommitteeSlotReducer;

    public CommitteeCampRegisterer(RegistrationDataBase registrationDataBase,IGetCampSlots campCommitteeSlotChecker, ICheckSchoolMatch checkSchoolMatch,ICheckRegistrationClosed registrationClosedChecker, IGetCampsRegistered registeredCampNamesGetter,ICheckNoClash clashWithRegisteredChecker,IReduceCampSlots campCommitteeSlotReducer)
    {
        this.registrationDataBase=registrationDataBase;
        this.campCommitteeSlotChecker=campCommitteeSlotChecker;
        this.checkSchoolMatch=checkSchoolMatch;
        this.registrationClosedChecker=registrationClosedChecker;
        this.registeredCampNamesGetter=registeredCampNamesGetter;
        this.clashWithRegisteredChecker=clashWithRegisteredChecker;
        this.campCommitteeSlotReducer=campCommitteeSlotReducer;
    }

    //We return a new CampCommittee object but with a student reference upon success. 
    //If fail, we simply return the original student reference. The result can be assigned to the old student reference in main.
    public Student registerCamp(Student student, String campName)
    {
        /*
         * Error checks:
         * 1.Check IF HES ALR A CAMPCOMM
         * 2.Check its open to his school
         * 3.Check if he alr registered to camp/dereged before
         * 4.Check if closed reg
         * 5.Check if clash
         * 6.Check if have campcom slot
         * 
         * Any of the above fails, return student himself.
         * Else Register Campcom by creating the registration entry and put into DB, 
         * then create and return a CAMPCOM object with said string and IsCampCommittee=true.
         */
        
         //If already a campcom,can't register to be another
         if(student.getIsCommittee()==true)
         {
            System.out.println("Registration failed! You cannot be a Camp Committee member for more than one camp!");
            return student;
         }

        //Error checks if the camp is even open to the student, or exists.
        boolean returnVal=checkSchoolMatch.checkSchoolMatch(student, campName);
        if(!returnVal)//means mismatch occured, or school doesn't exist. Error message printed by checkSchoolMatch.
        {
            return student;
        }

        //Check if student has already registered/deregistered from this camp before
        ArrayList<Registration> allRegistrations=registrationDataBase.getAllRegistrations();
        for(int i=0;i<allRegistrations.size();++i)
        {
            if(allRegistrations.get(i).getCampName().equals(campName) && allRegistrations.get(i).getStudentName().equals(student.getName()))
            {
                if(allRegistrations.get(i).getDeregistered())
                {
                    System.out.println("Failed to register. You have deregistered from this camp before! Unable to register again.");
                }
                else
                {
                    System.out.println("Failed to register. You are already registered for this camp!");
                }
                return student;
            }
        }

        //Checks if past register closing date.
        if(registrationClosedChecker.isRegistrationClosed(campName))
        {
            System.out.println("Failed to register. Registration has already been closed!");
            return student;
        }


        //Checks if dates clash
        ArrayList<String> allRegisteredCamps=registeredCampNamesGetter.getRegisteredCampNames(student.getName());
        if(!clashWithRegisteredChecker.checkNoClash(allRegisteredCamps, campName))
        {
            System.out.println("Failed to register. Dates clash with existing registered camp!");
            return student;
        }

        //Check if there are avail campComm slots
        int slots=campCommitteeSlotChecker.getCampSlots(campName);
        if(slots==IntErrorCodes.CAMP_NOT_FOUND)
        {
            System.out.println("Failed to register. There is no such camp with this camp name!");
            return student;
        }
        if(slots==IntErrorCodes.INSUFFICIENT_COMMITTEE_SLOTS)
        {
            System.out.println("Failed to register. There are no more Camp Committee slots left!");
            return student;
        }

        //Passed all error checking, create entry for campcom registration, and promote student to campcom, return that campcom object.
        registrationDataBase.getAllRegistrations().add(new Registration(student.getName(),campName,"Camp Committee"));
        campCommitteeSlotReducer.reduceCampSlots(campName);
        System.out.printf("You have successfully registered for the camp as an committee member! Camp Name: %s\n",campName);
        return new CampCommittee(student, campName);
        
    }
}