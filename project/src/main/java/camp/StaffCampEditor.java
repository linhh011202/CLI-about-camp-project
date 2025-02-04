package camp;

import misc.*;
import user.*;

import java.util.ArrayList;

import java.time.LocalDate;

/** 
 * Represents a class that performs edits on a camp within the camp database associated with this StaffCampEditor.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffCampEditor implements IEditCamp {
    /**
     * The Camp Database that this StaffCampEditor manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new StaffCampEditor with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This StaffCampEditor's associated Camp Database.
     */
    public StaffCampEditor(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    // Looks for the specific camp object to return.
    private Camp findCamp(String staffName, String campName) {
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();

        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)
                    && allCamps.get(i).getStaffInCharge().equals(staffName)) {
                return allCamps.get(i);
            }
        }
        return null;
    }

    public boolean changeCampName(User user, String campName, String newCampName) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        for(int i=0;i<campDataBase.getAllCamps().size();++i)
        {
            if(campDataBase.getAllCamps().get(i).getCampName().equals(newCampName))
            {
                System.out.printf("Error! Can't change a camp's name to that. That camp name already exists.\n");
                return false;
            }
        }

        campToEdit.setCampName(newCampName);
        System.out.printf("Changes made successfully!\n");
        return true;
    }

    public boolean changeStartDate(User user, String campName, String newStartDate) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.
        if(DateUtils.stringToDate(newStartDate).isBefore(LocalDate.now()))
        {
            System.out.printf("Edit failed! Start date cannot be set before the current date!\n");
            return false;
        }

        System.out.printf("Changes made successfully!\n");
        campToEdit.setStartDate(newStartDate);
        return true;
    }

    public boolean changeEndDate(User user, String campName, String newEndDate) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        if(DateUtils.stringToDate(newEndDate).isBefore(campToEdit.getStartDate()) || DateUtils.stringToDate(newEndDate).isBefore(LocalDate.now()))
        {
            System.out.printf("Edit failed! Camp end date cannot be set before the camp start date!\n");
            return false;
        }

        System.out.printf("Changes made successfully!\n");
        campToEdit.setEndDate(newEndDate);
        return true;
    }

    public boolean changeRegClosingDate(User user, String campName, String newRegClosingDate) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        if(DateUtils.stringToDate(newRegClosingDate).isAfter(campToEdit.getEndDate()))
        {
            System.out.printf("Edit failed! Registration closing date cannot be set after the camp end date!\n");
            return false;
        }
        System.out.printf("Changes made successfully!\n");
        campToEdit.setregClosingDate(newRegClosingDate);
        return true;
    }

    public boolean changeVisibility(User user, String campName, boolean newVisibility) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        if(campToEdit.getTotalSlots()!=(campToEdit.getAvailableAttendeeSlots()+campToEdit.getAvailableCampComSlots()))
        {
            System.out.printf("Can't change visibility if a student has already registered for camp!\n");
            return false;
        }

        System.out.printf("Changes made successfully!\n");
        campToEdit.setVisibility(newVisibility);
        return true;
    }

    public boolean changeLocation(User user, String campName, String newLocation) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        System.out.printf("Changes made successfully!\n");
        campToEdit.setLocation(newLocation);
        return true;
    }

    public boolean changeAttendeeSlots(User user, String campName, int newAttendeeSlots) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        // If new attendee slots < number of students that already registered as
        // attendees, fail.
        int numAttendeesRegistered = campToEdit.getAttendeeSlots() - campToEdit.getAvailableAttendeeSlots();
        if (newAttendeeSlots < numAttendeesRegistered) {
            System.out.println("Number of already registered attendees is greater than your new size! Edit failed.");
            return false;
        }

        // Error checks passed, set new slots.

        campToEdit.setAttendeeSlots(newAttendeeSlots);
        campToEdit.setAvailableAttendeeSlots(newAttendeeSlots - numAttendeesRegistered);
        campToEdit.setTotalSlots(newAttendeeSlots + campToEdit.getCampComSlots());
        System.out.printf("Changes made successfully!\n");
        return true;
    }

    public boolean changeCampComSlots(User user, String campName, int newCampComSlots) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        // If new attendee slots < number of students that already registered as
        // attendees, fail.
        int numCampComRegistered = campToEdit.getCampComSlots() - campToEdit.getAvailableCampComSlots();
        if (newCampComSlots < numCampComRegistered) {
            System.out.println(
                    "Number of already registered Camp Committee members is greater than your new size! Edit failed.");
            return false;
        }

        // Error checks passed, set new slots.

        campToEdit.setCampComSlots(newCampComSlots);
        campToEdit.setAvailableCampComSlots(newCampComSlots - numCampComRegistered);
        campToEdit.setTotalSlots(newCampComSlots + campToEdit.getAttendeeSlots());
        System.out.printf("Changes made successfully!\n");
        return true;
    }

    public boolean changeDescription(User user, String campName, String newDescription) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            System.out.printf("Unable to find that camp!\n");
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setDescription(newDescription);
        System.out.printf("Changes made successfully!\n");
        return true;
    }

    // Possibly add a ChangeOpenTo? Will need error checking if some peeps alr
    // registered maybe... coz sch change might invalidate them

}
