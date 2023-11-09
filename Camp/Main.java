package camp;

public class Main {
    public static void main(String[] args) 
    {
        CampDataBase campDataBase=new CampDataBase();
        RegistrationDataBase registrationDataBase=new RegistrationDataBase(campDataBase.getCampStudentSlotChecker(), campDataBase.getCampStudentSlotReducer(),campDataBase.getCheckSchoolMatch(),campDataBase.getCampStudentSlotIncreaser(),campDataBase.getClashWithRegisteredChecker(),campDataBase.getRegistrationClosedChecker(),campDataBase.getCampCommitteeSlotChecker(),campDataBase.getCampCommitteeSlotReducer(),campDataBase.getRegisteredCampsPrinter());

        Staff currentStaff=new Staff("animal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getFilterManager().getFilterCampByCampName());
        currentStaff.createCamp("c", "01/12/1000","10/12/1000", "01/10/2050", true, "CLASSSY", 1, 2, "ZEST CAMP" , Faculty.NTU);

        Staff nextStaff=new Staff("notanimal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getFilterManager().getFilterCampByCampName());
        nextStaff.createCamp("b", "01/12/2010", "10/12/2010","01/10/2050", true, "ALIBABA", 10, 1, "BEST CAMP" , Faculty.SCSE);
        nextStaff.createCamp("a", "11/12/2010","15/12/2010", "01/10/2050", true, "MOHOR B", 5, 1, "AEST CAMP" , Faculty.SCSE);
       
        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getFilterManager().getFilterCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer());
        

        //Test view registered camps , with changing filter. 
        student.registerCampCommittee("a");
        student.registerCampStudent("b");
        student.registerCampStudent("c");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        student.viewRegisteredCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        student.viewRegisteredCamps();


        //Testing all campComRegistration cases
        /* Test registration and dereg checks work properly. Only blocks dereg if he is campcom. Allows dereg if hes attendee.
        student=student.registerCampCommittee("b");
        student.registerCampStudent("a");
        student.deregisterCamp("a");
        student.deregisterCamp("b");
        //Test try to be campCom for more than 1.
        /* 
        student=student.registerCampCommittee("a");
        student=student.registerCampCommittee("b");
        registrationDataBase.printDataBase();
        */
        //Test try to be campcom for 1, and attendee for other camps
        /* 
        nextStaff.viewAllCamps();
        student=student.registerCampCommittee("a");
        student.registerCampStudent("b");
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        /* 
        //Test for no campCom slots
        /* 
        nextStaff.viewAllCamps();
        student.registerCampCommittee("a");
        registrationDataBase.printDataBase();
        nextStaff.viewAllCamps();
        */
        //Test for school student is not in
        /* 
        student.registerCampCommittee("a");
        registrationDataBase.printDataBase();
        */
        //Test for registration closed
        /*
        student.registerCampCommittee("c");
        registrationDataBase.printDataBase();
        */
        //Test for clash
        /* 
        student.registerCampStudent("a");
        student.registerCampCommittee("b");
        registrationDataBase.printDataBase();
        */
        //Test if trying to register as attendeee after already being campComm.
        /*
        nextStaff.viewAllCamps();
        student=student.registerCampCommittee("a");
        student.registerCampStudent("a");
        student.deregisterCamp("a");
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        //Check if we indeed managed to convert student to a campcom object. yes.
        System.out.printf("%b, %s\n",student.getIsCommittee(),((CampCommittee)student).getCampName());
        */
    

        //Test registration as ATTENDEE funcs
        /* 
        //Testing if able to detect if user is trying to register to a camp that clashes with already registered camps.
        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getFilterManager().getFilterCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer());
        student.registerCampStudent("a");
        student.registerCampStudent("b");
        //Tests if able to detect if registration date is closed.
        student.registerCampStudent("c");
        //Case for wrong school but somehow he knows camp name
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getFilterManager().getFilterCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer());
        student.registerCampStudent("a");
        //Case for able to accept,check avail slots updated correctly
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        student.registerCampStudent("b");
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        student.registerCampStudent("c");
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        //Case for trying to register to same camp twice
        student.registerCampStudent("c");
        nextStaff.viewAllCamps();
        registrationDataBase.printDataBase();
        //Case for trying to re-register to a deregistered camp.
        student.deregisterCamp("c");
        nextStaff.viewAllCamps();
        student.registerCampStudent("c");
        //test case for nonsense bogus campName
        student.deregisterCamp("HIHIHIH");
       */
      
        

        /* Test editing functions and viewing functions
        nextStaff.viewAllCamps();
        nextStaff.changeAttendeeSlots("b", 200);
        nextStaff.changeCampComSlots("b", 10);
        nextStaff.changeAttendeeSlots("a", 1);
        nextStaff.changeCampComSlots("a", 1);
        nextStaff.viewAllCamps();
        */


        /* test filter functions
        Student student=new Student("TOMMY",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getFilterManager().getFilterCampByCampName());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegDate());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getfilterCampByVisibility());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByTotalSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
        student.viewAllCamps();
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampCommiteeSlots());
        student.viewAllCamps();
        */
        

    }
}
