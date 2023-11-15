package staff;

import java.util.ArrayList;

public class StaffCampEditor implements IEditCamp {
    private CampDataBase campDataBase;

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

    // TBC: PROBABLY NEED TO UPDATE the regsitrationDB if we change campName so go
    // and change there too.
    public boolean changeCampName(User user, String campName, String newCampName) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setCampName(newCampName);
        return true;
    }

    public boolean changeStartDate(User user, String campName, String newStartDate) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setStartDate(newStartDate);
        return true;
    }

    public boolean changeEndDate(User user, String campName, String newEndDate) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setEndDate(newEndDate);
        return true;
    }

    public boolean changeRegClosingDate(User user, String campName, String newRegClosingDate) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setregClosingDate(newRegClosingDate);
        return true;
    }

    public boolean changeVisibility(User user, String campName, boolean newVisibility) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setVisibility(newVisibility);
        return true;
    }

    public boolean changeLocation(User user, String campName, String newLocation) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setLocation(newLocation);
        return true;
    }

    public boolean changeAttendeeSlots(User user, String campName, int newAttendeeSlots) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
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
        return true;
    }

    public boolean changeCampComSlots(User user, String campName, int newCampComSlots) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
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
        return true;
    }

    public boolean changeDescription(User user, String campName, String newDescription) {
        Camp campToEdit = findCamp(user.getName(), campName);
        if (campToEdit == null) {
            return false;
        } // Unable to find camp under that editor to change.

        campToEdit.setDescription(newDescription);
        return true;
    }

    // Possibly add a ChangeOpenTo? Will need error checking if some peeps alr
    // registered maybe... coz sch change might invalidate them

}
