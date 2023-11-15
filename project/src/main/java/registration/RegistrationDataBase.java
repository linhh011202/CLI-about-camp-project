package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RegistrationDataBase {
    private ArrayList<Registration> allRegistrations;

    // Association with the manager classes.
    private StudentCampRegisterer studentCampRegisterer;
    private StudentCampDeregisterer studentCampDeregisterer;
    private RegisteredCampNamesGetter registeredCampNamesGetter;
    private CommitteeCampRegisterer committeeCampRegisterer;
    private RegisteredCampNamesRolesGetter registeredCampNamesRolesGetter;
    private StudentRegisteredCampsViewer studentRegisteredCampsViewer;
    private AttendeeRegistrationChecker attendeeRegistrationChecker;
    private CommitteeRegistrationChecker committeeRegistrationChecker;
    private RegisteredStudentNamesRolesGetter registeredStudentNamesRolesGetter;
    private ListOfCampsIsCommiteeOfGetter listOfCampsIsCommiteeOfGetter;

    public RegistrationDataBase() {
        // Probably read in the data from files, but for now we make it empty at the
        // start every time.
        allRegistrations = new ArrayList<Registration>(0);
        try{
            readFromStorage();
        }catch(Exception exception)
        {
            System.out.printf("No existing Registration information to retrieve from storage!\n");
        }
    }

    // CRDB InterfaceInitialiser will use this function to initialise registrationDB
    // with the CampDB interfaces that it needs.
    public void InitialiseRegistrationDBManagers(IGetCampSlots campStudentSlotChecker,
            IReduceCampSlots campStudentSlotReducer, ICheckSchoolMatch checkSchoolMatch,
            IIncreaseCampSlots campStudentSlotIncreaser, ICheckNoClash clashwithRegisteredChecker,
            ICheckRegistrationClosed registrationClosedChecker, IGetCampSlots campCommitteeSlotChecker,
            IReduceCampSlots campCommitteeSlotReducer, IPrintRegisteredCamps registeredCampsPrinter,
            ICheckCampVisibility campVisibilityChecker) {
        registeredCampNamesGetter = new RegisteredCampNamesGetter(this);
        studentCampRegisterer = new StudentCampRegisterer(this, campStudentSlotChecker, campStudentSlotReducer,
                checkSchoolMatch, clashwithRegisteredChecker, registrationClosedChecker, registeredCampNamesGetter,
                campVisibilityChecker);
        studentCampDeregisterer = new StudentCampDeregisterer(this, campStudentSlotIncreaser);
        committeeCampRegisterer = new CommitteeCampRegisterer(this, campCommitteeSlotChecker, checkSchoolMatch,
                registrationClosedChecker, registeredCampNamesGetter, clashwithRegisteredChecker,
                campCommitteeSlotReducer, campVisibilityChecker);
        registeredCampNamesRolesGetter = new RegisteredCampNamesRolesGetter(this);
        studentRegisteredCampsViewer = new StudentRegisteredCampsViewer(this, registeredCampNamesRolesGetter,
                registeredCampsPrinter);
        attendeeRegistrationChecker = new AttendeeRegistrationChecker(this);
        committeeRegistrationChecker = new CommitteeRegistrationChecker(this);
        registeredStudentNamesRolesGetter = new RegisteredStudentNamesRolesGetter(this);
        listOfCampsIsCommiteeOfGetter = new ListOfCampsIsCommiteeOfGetter(this);

    }

    //Read and write to storage
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\RegInfo");
    
        // Create the necessary directories if they don't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\RegInfo\\RegInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < allRegistrations.size(); ++i) {
                objectOutputStream.writeObject(allRegistrations.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\RegInfo\\RegInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Registration registration = (Registration) objectInputStream.readObject();
                allRegistrations.add(registration);
            }
        }
    }


    // Getters for the manager classes, to be used to initialise User classes in
    // Main.java so they can utilise said interface functions.

    public StudentCampRegisterer getStudentCampRegisterer() {
        return studentCampRegisterer;
    }

    public StudentCampDeregisterer getStudentCampDeregisterer() {
        return studentCampDeregisterer;
    }

    public RegisteredCampNamesGetter getRegisteredCampNamesGetter() {
        return registeredCampNamesGetter;
    }

    public CommitteeCampRegisterer getCommitteeCampRegisterer() {
        return committeeCampRegisterer;
    }

    public RegisteredCampNamesRolesGetter getRegisteredCampNamesRolesGetter() {
        return registeredCampNamesRolesGetter;
    }

    public StudentRegisteredCampsViewer getStudentRegisteredCampsViewer() {
        return studentRegisteredCampsViewer;
    }

    public AttendeeRegistrationChecker getAttendeeRegistrationChecker() {
        return attendeeRegistrationChecker;
    }

    public CommitteeRegistrationChecker getCommitteeRegistrationChecker() {
        return committeeRegistrationChecker;
    }

    public RegisteredStudentNamesRolesGetter getRegisteredStudentNamesRolesGetter() {
        return registeredStudentNamesRolesGetter;
    }

    public ListOfCampsIsCommiteeOfGetter getListOfCampsIsCommiteeOfGetter() {
        return listOfCampsIsCommiteeOfGetter;
    }

    // debugging func
    public void printDataBase() {
        for (int i = 0; i < allRegistrations.size(); ++i) {
            allRegistrations.get(i).printRegistration();
        }
    }

    public ArrayList<Registration> getAllRegistrations() {
        return allRegistrations;
    }

}