package user;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;

import java.util.ArrayList;

public class Staff extends User {
    private ICreateCamp staffCampCreator;
    private IDeleteCamp staffCampDeleter;
    private IEditCamp staffCampEditor;
    private IViewOwnCamps staffViewOwnCamps;
    private IGenerateStudentReport staffStudentReportGenerator;
    private IGetCampsCreated listCampsStaffCreatedGetter;
    private IGeneratePerformanceReport staffPerformanceReportGenerator;

    public Staff(String name, ICreateCamp staffCampCreator, IDeleteCamp staffCampDeleter, IEditCamp staffCampEditor,
            IViewAllCamps staffViewAllCamps, IViewOwnCamps staffViewOwnCamps, ISortCamps iSortCamps,
            IFilterCamps iFilterCamps, IGenerateStudentReport staffStudentReportGenerator,
            IGetCampsCreated listCampsStaffCreatedGetter, UserDataBase userDataBase,
            IGeneratePerformanceReport staffPerformanceReportGenerator) {
        super(name, iSortCamps, iFilterCamps, userDataBase, staffViewAllCamps);
        this.staffCampCreator = staffCampCreator;
        this.staffCampDeleter = staffCampDeleter;
        this.staffCampEditor = staffCampEditor;
        this.staffViewOwnCamps = staffViewOwnCamps;
        this.staffStudentReportGenerator = staffStudentReportGenerator;
        this.listCampsStaffCreatedGetter = listCampsStaffCreatedGetter;
        this.staffPerformanceReportGenerator = staffPerformanceReportGenerator;
    }

    public void createCamp(String campName, String startDate, String endDate, String regClosingDate, boolean visibility,
            String location, int attendeeSlots, int campComSlots, String description, Faculty openTo) {
        staffCampCreator.createCamp(campName, startDate, endDate, regClosingDate, visibility, location, attendeeSlots,
                campComSlots, description, this, openTo);
    }

    public void deleteCamp(String campName) {
        staffCampDeleter.deleteCamp(this, campName);
    }

    public void changeCampName(String campName, String newCampName) {
        staffCampEditor.changeCampName(this, campName, newCampName);
    }

    public void changeVisibility(String campName, boolean newVisibility) {
        staffCampEditor.changeVisibility(this, campName, newVisibility);
    }

    public void changeCampComSlots(String campName, int newCampComSlots) {
        staffCampEditor.changeCampComSlots(this, campName, newCampComSlots);
    }

    public void changeAttendeeSlots(String campName, int newAttendeeSlots) {
        staffCampEditor.changeAttendeeSlots(this, campName, newAttendeeSlots);
    }

    public void viewOwnCamps() {
        staffViewOwnCamps.viewOwnCamps(this, super.getSortCamps(), getFilterCamps(), getFilterString());
    }

    public void generateStudentReport() {
        staffStudentReportGenerator.generateStudentReport(this, getSortCamps(), getFilterCamps(), getFilterString());
    }

    public ArrayList<String> getCampsCreated() {
        return listCampsStaffCreatedGetter.getListCampStaffCreated(this.getName());
    }

    public void generatePerformanceReport() {
        staffPerformanceReportGenerator.generatePerformanceReport(getUserDataBase(), this, getSortCamps(),
                getFilterCamps(), getFilterString());
    }

}
