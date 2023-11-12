package merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//WHole thing is case sensitive for consistency atm, can be altered as we wish.

public class Main {
    public static void main(String[] args) 
    {
        UserDataBase userDataBase=new UserDataBase();
        CampDataBase campDataBase=new CampDataBase();
        RegistrationDataBase registrationDataBase=new RegistrationDataBase();
        CRDBInterfaceInitialiser.InitialiseCRDataBaseInterfaces(campDataBase, registrationDataBase);

        EnquiriesDB enquiriesDB=new EnquiriesDB(campDataBase.getCheckSchoolMatch(),campDataBase.getCampVisibilityChecker());

        Staff staff0=new Staff("animal",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getSortManager().getSortCampByCampName(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getStaffStudentReportGenerator(),campDataBase.getListCampsStaffCreatedGetter(),userDataBase,campDataBase.getStaffPerformanceReportGenerator());
        staff0.createCamp("d", "01/12/2010", "10/12/2010","01/10/2050", true, "ALIBABA", 10, 4, "BEST CAMP" , Faculty.SCSE);

        Staff staff1=new Staff("kaixuan",campDataBase.getStaffCampCreator(),campDataBase.getStaffCampDeleter(),campDataBase.getStaffCampEditor(),campDataBase.getStaffViewAllCamps(),campDataBase.getStaffViewOwnCamps(),campDataBase.getSortManager().getSortCampByCampName(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getStaffStudentReportGenerator(),campDataBase.getListCampsStaffCreatedGetter(),userDataBase,campDataBase.getStaffPerformanceReportGenerator());
        staff1.createCamp("b", "01/12/2010", "10/12/2010","01/10/2050", true, "ALIBABA", 10, 4, "BEST CAMP" , Faculty.SCSE);
        staff1.createCamp("a", "14/12/2010","15/12/2010", "09/11/2050", true, "MOHOR B", 5, 2, "AEST CAMP" , Faculty.SCSE);
        staff1.createCamp("c", "15/12/2012","20/12/2020", "01/10/2050", true, "CLASSSY", 1, 2, "BEST CAMP" , Faculty.NTU);
        
        userDataBase.addUser(new Student("tommy",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),userDataBase));
        userDataBase.addUser(new Student("bob",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),userDataBase));
        userDataBase.addUser(new Student("sam",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),userDataBase));
        userDataBase.addUser(new Student("timothy",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),userDataBase));
        userDataBase.addUser(new Student("marly",campDataBase.getStudentViewAllCamps(),Faculty.SCSE,campDataBase.getSortManager().getSortCampByCampName(),registrationDataBase.getStudentCampRegisterer(),registrationDataBase.getStudentCampDeregisterer(),registrationDataBase.getCommitteeCampRegisterer(),registrationDataBase.getStudentRegisteredCampsViewer(),campDataBase.getFilterManager().getFilterCampByNothing(),campDataBase.getCampComStudentReportGenerator(),userDataBase));
        
        User currentUser=userDataBase.getUser("tommy");
        currentUser=userDataBase.updateUser("tommy",((Student)currentUser).registerCampCommittee("a"));

        currentUser=userDataBase.getUser("bob");
        currentUser=userDataBase.updateUser("bob",((Student)currentUser).registerCampCommittee("a"));

        currentUser=userDataBase.getUser("sam");
        currentUser=userDataBase.updateUser("sam",((Student)currentUser).registerCampCommittee("b"));

        currentUser=userDataBase.getUser("timothy");
        currentUser=userDataBase.updateUser("timothy",((Student)currentUser).registerCampCommittee("b"));
        staff1.generatePerformanceReport();



        /* 
        Testing kx enquiries
        enquiriesDB.sendEnquiry("b", "HOW TO GO", student1);
        enquiriesDB.sendEnquiry("c", "HOW TO GO", student1);
        enquiriesDB.sendEnquiry("c", "WHY THS CAMP SO GOOD", student5);

        enquiriesDB.addReply(1, "DUNNO", staff0.getCampsCreated());


        ArrayList<String> camps=staff1.getCampsCreated();
        Collections.sort(camps);
        enquiriesDB.viewByCamp(camps);
        */
        

        /* 
        student1.registerCampCommittee("a");
        student1.registerCampStudent("b");
        student2.registerCampStudent("b");
        student3.registerCampStudent("b");
        student4.registerCampStudent("b");
        student5.registerCampCommittee("b");
        student4.registerCampStudent("a");  
        student5.registerCampStudent("c");

        staff1.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeName());
        staff1.setFilterString("timothy");
        

        staff1.generateStudentReport();
        */





        /* 
        //Testing generatestudentreport printed version... not made to output text yet.
        student1.registerCampCommittee("b");
        student2.registerCampCommittee("b");
        student3.registerCampStudent("b");
        student4.registerCampStudent("b");
        student5.registerCampStudent("b");

        student4.registerCampStudent("a");

        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeName());
        nextStaff.setFilterString("marly");
        nextStaff.generateStudentReport();
        */

        /* testing new error check for visibility when registering
        student.registerCampCommittee("c");
        student.registerCampStudent("b");
        student.registerCampStudent("a");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        student.setFilterString("a");

        student.viewRegisteredCamps();
        */

        //check filters based on WHO is in the camp (as attendees or committee)
        /* 
        currentStaff.setFilterString("tommy");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeName());
        currentStaff.viewAllCamps();

        student.registerCampStudent("b");
        student.registerCampStudent("a");
        student.deregisterCamp("b");
        currentStaff.setFilterString("tommy");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeName());
        currentStaff.viewAllCamps();
        */
;

        /* 
        currentStaff.setCampSorter(campDataBase.getSortManager().getSortCampByLocation());
        currentStaff.setFilterString("c");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("d");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("01/12/2010");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("10/12/2010");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("01/10/2050");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegClosingDate());
        currentStaff.viewAllCamps();
           
        currentStaff.setFilterString("false");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByVisibility());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("MOHOR B");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("MOHOR B");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("1");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("1");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("1");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        currentStaff.viewAllCamps();

        student.registerCampCommittee("a");
        student.registerCampStudent("c");
        currentStaff.setFilterString("0");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
        currentStaff.viewAllCamps();

        currentStaff.setFilterString("0");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampComSlots());
        currentStaff.viewAllCamps();
        
        currentStaff.setFilterString("BeST CAMP");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
        currentStaff.viewAllCamps();
        
        currentStaff.setFilterString("notAnimal");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
        currentStaff.viewAllCamps();
        
        currentStaff.setFilterString("ScSE");
        currentStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
        currentStaff.viewAllCamps();
       
        */
        //Check camp Filters
        /* Student viewallcamps
        student.setFilterString("c");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        student.viewAllCamps();

        student.setFilterString("d");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        student.viewAllCamps();

        student.setFilterString("01/12/2010");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
        student.viewAllCamps();

        student.setFilterString("10/12/2010");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
        student.viewAllCamps();

        student.setFilterString("01/10/2050");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegClosingDate());
        student.viewAllCamps();
           
        student.setFilterString("false");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByVisibility());
        student.viewAllCamps();

        student.setFilterString("MOHOR B");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        student.viewAllCamps();

        student.setFilterString("MOHOR B");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        student.viewAllCamps();

        student.setFilterString("1");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
        student.viewAllCamps();

        student.setFilterString("1");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        student.viewAllCamps();

        student.setFilterString("1");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        student.viewAllCamps();

        student.registerCampCommittee("a");
        student.registerCampStudent("c");
        student.setFilterString("0");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
        student.viewAllCamps();

        student.setFilterString("0");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampComSlots());
        student.viewAllCamps();
        
        student.setFilterString("BeST CAMP");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
        student.viewAllCamps();
        
        student.setFilterString("notAnimal");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
        student.viewAllCamps();
        
        student.setFilterString("ScSE");
        student.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
        student.viewAllCamps();
        */

        //Check viewOwnCamps with filters
        /* 
        nextStaff.setFilterString("c");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("d");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampName());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("01/12/2010");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStartDate());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("10/12/2010");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByEndDate());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("01/10/2050");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByRegClosingDate());
        nextStaff.viewOwnCamps();
           
        nextStaff.setFilterString("false");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByVisibility());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("MOHOR B");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("MOHOR B");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByLocation());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("1");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAttendeeSlots());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("1");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("1");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByCampComSlots());
        nextStaff.viewOwnCamps();

        student.registerCampCommittee("a");
        student.registerCampStudent("c");
        nextStaff.setFilterString("0");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableAttendeeSlots());
        nextStaff.viewOwnCamps();

        nextStaff.setFilterString("0");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByAvailableCampComSlots());
        nextStaff.viewOwnCamps();
        
        nextStaff.setFilterString("BeST CAMP");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByDescription());
        nextStaff.viewOwnCamps();
        
        nextStaff.setFilterString("notAnimal");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByStaffIC());
        nextStaff.viewOwnCamps();
        
        nextStaff.setFilterString("ScSE");
        nextStaff.setCampFilter(campDataBase.getFilterManager().getFilterCampByOpenTo());
        nextStaff.viewOwnCamps();
        */



        /* 
        //Test view registered camps , with changing filter. 
        student.registerCampCommittee("a");
        student.registerCampStudent("b");
        student.registerCampStudent("c");
        student.setCampFilter(campDataBase.getSortManager().getSortCampByLocation());
        student.viewRegisteredCamps();
        student.setCampFilter(campDataBase.getSortManager().getSortCampByCampName());
        student.viewRegisteredCamps();
        */


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


        /* test SORTING functions (OLD CODE SO FOR SORTING NOW GOTTA CALL FROM SORTMANGER.)
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
