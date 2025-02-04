package user;

import camp.*;
import registration.*;

import main.user.DataList;
import java.util.ArrayList;

/** 
 * Represents a staff in the system. A staff can interact with the various camp, enquiries, registration and suggestions databases.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class Staff extends User {
    /**
     * This Staff's interface it utilises to create a camp.
     */
    private transient ICreateCamp staffCampCreator;

    /**
     * This Staff's interface it utilises to delete a camp.
     */
    private transient IDeleteCamp staffCampDeleter;

    /**
     * This Staff's interface it utilises to edit a camp.
     */
    private transient IEditCamp staffCampEditor;

    /**
     * This Staff's interface it utilises to view all camps that he can see. (Basically every camp).
     */
    private transient IViewOwnCamps staffViewOwnCamps;
    
    /**
     * This Staff's interface it utilises to generate a student report for all camps that he is in charge of.
     */
    private transient IGenerateStudentReport staffStudentReportGenerator;

    /**
     * This Staff's interface that it utilises to create a list of camp names that were created by him.
     */
    private transient IGetCampsCreated listCampsStaffCreatedGetter;

    /**
     * This Staff's interface it utilises to generate a performance report for all camp committee members of camps
     * that this staff created.
     */
    private transient IGeneratePerformanceReport staffPerformanceReportGenerator;


    /**
     * Creates a new Staff object, with the given name, associated user database, and interfaces it requires from 
     * {@link CampDataBase} and {@link RegistrationDataBase}.
     * @param name This Staff's name.
     * @param email THis Staff's email.
     * @param faculty This Staff's faculty.
     * @param staffCampCreator Interface this Staff uses to create camps.
     * @param staffCampDeleter Interface this Staff uses to delete camps.
     * @param staffCampEditor Interface this Staff uses to edit camps.
     * @param staffViewAllCamps Interface this Staff uses to view all camps.
     * @param staffViewOwnCamps Interface this Staff uses to view all camps created by him.
     * @param iSortCamps Interface this Staff uses to sort all the camps in the associated camp database.
     * @param iFilterCamps Interface this Staff uses to filter all the camps in the associated camp database.
     * @param staffStudentReportGenerator Interface this Staff uses to generate a student report for all the camps he is in charge of.
     * @param listCampsStaffCreatedGetter Interface this Staff uses to generate a list of camp names, consisting of all camps he has created.
     * @param dataList This Staff's associated user databse.
     * @param staffPerformanceReportGenerator Interface this Staff uses to generate a performance report for all camp committee members of
     * all the camps he is in charge of.
     */
    public Staff(String name,String email, Faculty faculty, ICreateCamp staffCampCreator, IDeleteCamp staffCampDeleter, IEditCamp staffCampEditor,
            IViewAllCamps staffViewAllCamps, IViewOwnCamps staffViewOwnCamps, ISortCamps iSortCamps,
            IFilterCamps iFilterCamps, IGenerateStudentReport staffStudentReportGenerator,
            IGetCampsCreated listCampsStaffCreatedGetter, DataList dataList,
            IGeneratePerformanceReport staffPerformanceReportGenerator) {
        super(name,email,faculty,iSortCamps, iFilterCamps, dataList, staffViewAllCamps);
        this.staffCampCreator = staffCampCreator;
        this.staffCampDeleter = staffCampDeleter;
        this.staffCampEditor = staffCampEditor;
        this.staffViewOwnCamps = staffViewOwnCamps;
        this.staffStudentReportGenerator = staffStudentReportGenerator;
        this.listCampsStaffCreatedGetter = listCampsStaffCreatedGetter;
        this.staffPerformanceReportGenerator = staffPerformanceReportGenerator;
    }

    /**
     * Function to initialise the required interfaces after deserialising staff object from storage.
     * @param staffCampCreator Interface this Staff uses to create camps.
     * @param staffCampDeleter Interface this Staff uses to delete camps.
     * @param staffCampEditor Interface this Staff uses to edit camps.
     * @param staffViewAllCamps Interface this Staff uses to view all camps.
     * @param staffViewOwnCamps Interface this Staff uses to view all camps created by him.
     * @param iSortCamps Interface this Staff uses to sort all the camps in the associated camp database.
     * @param iFilterCamps Interface this Staff uses to filter all the camps in the associated camp database.
     * @param staffStudentReportGenerator Interface this Staff uses to generate a student report for all the camps he is in charge of.
     * @param listCampsStaffCreatedGetter Interface this Staff uses to generate a list of camp names, consisting of all camps he has created.
     * @param dataList This Staff's associated user databse.
     * @param staffPerformanceReportGenerator Interface this Staff uses to generate a performance report for all camp committee members of
     */
    public void initialiseAfterDeserialise(ICreateCamp staffCampCreator, IDeleteCamp staffCampDeleter, IEditCamp staffCampEditor,
    IViewAllCamps staffViewAllCamps, IViewOwnCamps staffViewOwnCamps, ISortCamps iSortCamps,
    IFilterCamps iFilterCamps, IGenerateStudentReport staffStudentReportGenerator,
    IGetCampsCreated listCampsStaffCreatedGetter, DataList dataList,
    IGeneratePerformanceReport staffPerformanceReportGenerator)
    {
        super.initialiseAfterDeserialise(iSortCamps, iFilterCamps, dataList, staffViewAllCamps);
        this.staffCampCreator = staffCampCreator;
        this.staffCampDeleter = staffCampDeleter;
        this.staffCampEditor = staffCampEditor;
        this.staffViewOwnCamps = staffViewOwnCamps;
        this.staffStudentReportGenerator = staffStudentReportGenerator;
        this.listCampsStaffCreatedGetter = listCampsStaffCreatedGetter;
        this.staffPerformanceReportGenerator = staffPerformanceReportGenerator;
    }

    /**
     * Creates a new camp.
     * @param campName The Camp's camp name.
     * @param startDate The Camp's start date.
     * @param endDate The Camp's end date.
     * @param regClosingDate The Camp's registration closing date.
     * @param visibility The Camp's visibility status.
     * @param location The Camp's location
     * @param attendeeSlots The Camp's number of attendee slots.
     * @param campComSlots The Camp's number of camp committee slots.
     * @param description The Camp's description.
     * @param openTo The Camp's faculty that it is open to.
     */
    public void createCamp(String campName, String startDate, String endDate, String regClosingDate, boolean visibility,
            String location, int attendeeSlots, int campComSlots, String description, Faculty openTo) {
        staffCampCreator.createCamp(campName, startDate, endDate, regClosingDate, visibility, location, attendeeSlots,
                campComSlots, description, this, openTo);
    }

    /**
     * Deletes a camp that was created by this Staff.
     * @param campName Name of camp to be deleted by this Staff.
     * @return Returns true if camp successfully deleted. Returns false otherwise.
     */
    public boolean deleteCamp(String campName) {
        return staffCampDeleter.deleteCamp(this, campName);
    }

    /**
     * Changes the camp name of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newCampName New camp name.
     * @return Boolean that indicates the success or failure of updating the camp name.
     */
    public boolean changeCampName(String campName, String newCampName) {
        return staffCampEditor.changeCampName(this, campName, newCampName);
    }

    /**
     * Changes the start date of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newStartDate New start date.
     */
    public void changeStartDate(String campName,String newStartDate)
    {
        staffCampEditor.changeStartDate(this,campName,newStartDate);
    }

    /**
     * Changes the end date of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newEndDate New end date.
     */
    public void changeEndDate(String campName,String newEndDate)
    {
        staffCampEditor.changeEndDate(this,campName,newEndDate);
    }

    /**
     * Changes the registration closing date of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newRegClosingDate New camp registration closing date.
     */
    public void changeRegClosingDate(String campName,String newRegClosingDate)
    {
        staffCampEditor.changeRegClosingDate(this,campName,newRegClosingDate);
    }

    /**
     * Changes the location of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newLocation New camp location.
     */
    public void changeLocation(String campName,String newLocation)
    {
        staffCampEditor.changeLocation(this,campName,newLocation);
    }

    /**
     * Changes the description of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newDescription New camp description.
     */
    public void changeDescription(String campName,String newDescription)
    {
        staffCampEditor.changeDescription(this,campName,newDescription);
    }

    /**
     * Changes the visibility status of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newVisibility New camp visibility status.
     */
    public void changeVisibility(String campName, boolean newVisibility) {
        staffCampEditor.changeVisibility(this, campName, newVisibility);
    }

    /**
     * Changes the number of total camp committee slots of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newCampComSlots New camp total camp commitee slots.
     */
    public void changeCampComSlots(String campName, int newCampComSlots) {
        staffCampEditor.changeCampComSlots(this, campName, newCampComSlots);
    }

    /**
     * Changes the total attendee slots of a specified camp owned by this Staff.
     * @param campName Name of camp to be edited.
     * @param newAttendeeSlots New total camp attendee slots.
     */
    public void changeAttendeeSlots(String campName, int newAttendeeSlots) {
        staffCampEditor.changeAttendeeSlots(this, campName, newAttendeeSlots);
    }

    /**
     * Prints details of all the camps created by this Staff.
     */
    public void viewOwnCamps() {
        staffViewOwnCamps.viewOwnCamps(this, super.getSortCamps(), getFilterCamps(), getFilterString());
    }

    /**
     * Generates a student report containing camp details and all registered students and their respective camp roles, for all camps
     * owned by this Staff.
     */
    public void generateStudentReport() {
        staffStudentReportGenerator.generateStudentReport(this, getSortCamps(), getFilterCamps(), getFilterString());
    }

    /**
     * Creates an array of Strings that contains the names of all the camps created by this staff.
     * @return The array of Strings that contains the names of all the camps created by this staff.
     */
    public ArrayList<String> getCampsCreated() {
        return listCampsStaffCreatedGetter.getListCampStaffCreated(this.getName());
    }

    /**
     * Generates a performance report for all of this Staff's camps, which includes the points of all the camp committee members involved
     * in the respective camps owned by this Staff.
     */
    public void generatePerformanceReport() {
        staffPerformanceReportGenerator.generatePerformanceReport(getUserDataList(), this, getSortCamps(),
                getFilterCamps(), getFilterString());
    }

    /**
     * Prints all the camps that the staff can view (In the current implementation, staffs are able to view all camps.)
     */
    public void viewAllCamps() {
        super.getIViewAllCamps().viewAllCamps(this, getSortCamps(), getFilterCamps(), getFilterString());
    }

}
