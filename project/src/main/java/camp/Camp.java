package camp;

import misc.*;
import user.*;

import java.time.LocalDate;
import java.io.*;

/** 
 * Represents a Camp created in the system. A camp contains information related to the camp such as remaining slots left, 
 * Camp Name, Staff in Charge.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class Camp implements Serializable
{
    /**
     * The name of this camp.
     */
    private String campName;

    /**
     * The starting date of this camp.
     */
    private LocalDate startDate;

    /**
     * The ending date of this camp.
     */
    private LocalDate endDate;

    /**
     * The registration closing date of this camp.
     */
    private LocalDate regClosingDate;

    /**
     * The visibility status of this camp.
     */
    private boolean visibility;

    /**
     * The location of this camp.
     */
    private String location;

    /**
     * The total number of slots available for this camp.
     */
    private int totalSlots;

    /**
     * The total number of attendee slots available for this camp.
     */
    private int attendeeSlots;

    /**
     * The total number of camp committee slots available for this camp.
     */
    private int campComSlots;

    /**
     * The remaining number of camp committee slots available for this camp.
     */
    private int availableCampComSlots;

    /**
     * The remaining number of attendee slots available for this camp.
     */
    private int availableAttendeeSlots;

    /**
     * The description of this camp.
     */
    private String description;

    /**
     * The name of the staff in charge of this camp.
     */
    private String staffInCharge;

    /**
     * The name of the faculty that this camp is open to.
     */
    private Faculty openTo;

    /**
     * The filtered status of this camp, which is set on every call to generate report or viewing of camps, only
     * camps that are not filtered out will be displayed.
     */
    private boolean isFilteredOut;

    /**
     * Creates a new Camp with the given attributes. The dates should follow the following format: DD/MM/YYYY
     * @param campName This Camp's name.
     * @param startDate This Camp's starting date.
     * @param endDate This Camp's ending date.
     * @param regClosingDate This Camp's registration closing date.
     * @param visibility This Camp's visibility status.
     * @param location This Camp's location.
     * @param attendeeSlots This Camp's total attendee slots.
     * @param campComSlots This Camp's total camp committee slots.
     * @param description This Camp's description.
     * @param user The user who is trying to create this camp.
     * @param openTo The faculties that this camp is open to.
     */
    public Camp(String campName, String startDate, String endDate, String regClosingDate, boolean visibility,
            String location, int attendeeSlots, int campComSlots, String description, User user, Faculty openTo) {
        // Consider error checking and throwing exception if dates not in proper format,
        // or startDate>endDate, etc.
        LocalDate lStartDate = DateUtils.stringToDate(startDate);
        LocalDate lEndDate = DateUtils.stringToDate(endDate);
        LocalDate lRegClosingDate = DateUtils.stringToDate(regClosingDate);
        this.campName = campName;
        this.startDate = lStartDate;
        this.endDate = lEndDate;
        this.regClosingDate = lRegClosingDate;
        this.visibility = visibility;
        this.location = location;
        this.attendeeSlots = attendeeSlots;
        this.campComSlots = campComSlots;
        this.description = description;
        this.staffInCharge = user.getName();
        this.openTo = openTo;
        this.availableAttendeeSlots = attendeeSlots;
        this.availableCampComSlots = campComSlots;
        this.totalSlots = campComSlots + attendeeSlots;
        this.isFilteredOut = false;
    }

    /**
     * Prints the details of a camp.
     */
    public void printCamp() {
        System.out.printf("|| Camp name: %s | Staff in charge: %s ||\n", this.getCampName(), this.getStaffInCharge());
        System.out.printf("|| Start Date: %s | End Date: %s ||\n", this.getStringStartDate(), this.getStringEndDate());
        System.out.printf("|| Registration Closing Date: %s | Visibility: %b ||\n", this.getStringRegClosingDate(),
                this.getVisibility());
        System.out.printf("|| Location: %s | Total Slots: %d ||\n", this.getLocation(), this.getTotalSlots());
        System.out.printf("|| Total Camp Attendee Slots: %d ||\n", this.getAttendeeSlots());
        System.out.printf("|| Total Camp Committee Slots: %d ||\n", this.getCampComSlots());
        System.out.printf("|| Description: %s ||\n", this.getDescription());
        System.out.printf("|| Open To: %s ||\n", this.getOpenTo().toString());
        System.out.printf("|| Available Attendee Slots: %s ||\n", this.getAvailableAttendeeSlots());
        System.out.printf("|| Available Camp Committee Slots: %s ||\n\n", this.getAvailableCampComSlots());

    }

    /**
     * Prints the details of this Camp to an output file. 
     * @param printWriter A PrintWriter object that writes to the desired specified output file.
     */
    public void printCampToFile(PrintWriter printWriter) {
        printWriter.printf("|| Camp name: %s | Staff in charge: %s ||\n", this.getCampName(), this.getStaffInCharge());
        printWriter.printf("|| Start Date: %s | End Date: %s ||\n", this.getStringStartDate(), this.getStringEndDate());
        printWriter.printf("|| Registration Closing Date: %s | Visibility: %b ||\n", this.getStringRegClosingDate(),
                this.getVisibility());
        printWriter.printf("|| Location: %s | Total Slots: %d ||\n", this.getLocation(), this.getTotalSlots());
        printWriter.printf("|| Total Camp Attendee Slots: %d ||\n", this.getAttendeeSlots());
        printWriter.printf("|| Total Camp Committee Slots: %d ||\n", this.getCampComSlots());
        printWriter.printf("|| Description: %s ||\n", this.getDescription());
        printWriter.printf("|| Open To: %s ||\n", this.getOpenTo().toString());
        printWriter.printf("|| Available Attendee Slots: %s ||\n", this.getAvailableAttendeeSlots());
        printWriter.printf("|| Available Camp Committee Slots: %s ||\n\n", this.getAvailableCampComSlots());
    }

    // Setters and getters

    /**
     * Gets the camp name of this Camp.
     * @return This Camp's name.
     */
    public String getCampName() {
        return campName;
    }

    /**
     * Changes the camp name of this Camp.
     * @param campName This Camp's new name.
     */
    public void setCampName(String campName) {
        this.campName = campName;
    }

    /**
     * Gets the start date of this Camp in LocalDate format.
     * @return This Camp's start date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the start date of this Camp as a String.
     * @return This Camps's start date. String is in format DD/MM/YYYY.
     */
    public String getStringStartDate() {
        return DateUtils.dateToString(startDate);
    }

    /**
     * Changes the start date of this Camp. 
     * @param startDate This Camp's new start date. String should be in format DD/MM/YYYY.
     */
    public void setStartDate(String startDate) {
        // Consider error checking for format and whether startDate>endDate;
        LocalDate lStartDate = DateUtils.stringToDate(startDate);
        this.startDate = lStartDate;
    }

    /**
     * Gets the end date of this Camp in LocalDate format.
     * @return This Camp's end date.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

     /**
     * Gets the end date of this Camp as a String.
     * @return This Camps's end date. String is in format DD/MM/YYYY.
     */
    public String getStringEndDate() {
        return DateUtils.dateToString(endDate);
    }

    /**
     * Changes the end date of this Camp. 
     * @param endDate This Camp's new start date. String should be in format DD/MM/YYYY.
     */
    public void setEndDate(String endDate) {
        // Consider error checking for format and whether startDate>endDate;
        LocalDate lEndDate = DateUtils.stringToDate(endDate);
        this.endDate = lEndDate;
    }

    /**
     * Gets the registration closing date of this Camp in LocalDate format.
     * @return This Camp's registration closing date.
     */
    public LocalDate getRegClosingDate() {
        return regClosingDate;
    }

    /**
     * Gets the registration closing date of this Camp as a String.
     * @return This Camps's registration closing date. String is in format DD/MM/YYYY.
     */
    public String getStringRegClosingDate() {
        return DateUtils.dateToString(regClosingDate);
    }

    /**
     * Changes the registration closing date of this Camp. 
     * @param regClosingDate This Camp's new registration closing date. String should be in format DD/MM/YYYY.
     */
    public void setregClosingDate(String regClosingDate) {
        LocalDate lRegClosingDate = DateUtils.stringToDate(regClosingDate);
        this.regClosingDate = lRegClosingDate;
    }

    /**
     * Gets the visibility status of this Camp.
     * @return This Camp's visibility status.
     */
    public boolean getVisibility() {
        return visibility;
    }

    /**
     * Changes the visibility status of this Camp.
     * @param visibility This Camp's new visibility status.
     */
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the location of this Camp.
     * @return This Camp's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Changes the location of this Camp.
     * @param location This Camp's new location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the total available slots for this Camp.    
     * @return This Camp's total available slots.
     */
    public int getTotalSlots() {
        return totalSlots;
    }

    /**
     * Changes the total available slots for this Camp.
     * @param totalSlots This Camp's new total available slots.
     */
    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    /**
     * Gets the total camp committee slots for this Camp.
     * @return This Camp's total camp committee slots.
     */
    public int getCampComSlots() {
        return campComSlots;
    }

    /**
     * Changes the total camp committee slots for this Camp.
     * @param campComSlots This Camp's new total camp committee slots.
     */
    public void setCampComSlots(int campComSlots) {
        this.campComSlots = campComSlots;
    }

    /**
     * Gets the description of this Camp.
     * @return This Camp's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description of this Camp.
     * @param description This Camp's new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the name of the staff in charge of this Camp.
     * @return The name of this Camp's staff in charge.
     */
    public String getStaffInCharge() {
        return staffInCharge;
    }

    /**
     * Changes the name of the staff in charge of this Camp.
     * @param staffInCharge The new name of this Camp's staff in charge.
     */
    public void setStaffInCharge(String staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    /**
     * Gets the faculty that this Camp is open to as a Faculty enumeration.
     * @return The faculty that this camp is open to.
     */
    public Faculty getOpenTo() {
        return openTo;
    }

    /**
     * Gets the faculty that this Camp is open to as a String.
     * @return The string name of the faculty that this Camp is open to.
     */
    public String getStringOpenTo() {
        return openTo.toString();
    }

    /**
     * Changes the faculty that this Camp is open to.
     * @param openTo The new faculty that this Camp is open to.
     */
    public void setOpenTo(Faculty openTo) {
        this.openTo = openTo;
    }

    /**
     * Gets the remaining available attendee slots for this Camp.
     * @return This Camp's remaining available attendee slots.
     */
    public int getAvailableAttendeeSlots() {
        return availableAttendeeSlots;
    }

    /**
     * Changes the remaining available attendee slots for this Camp.
     * @param availableAttendeeSlots This Camp's new remaining available attendee slots.
     */
    public void setAvailableAttendeeSlots(int availableAttendeeSlots) {
        this.availableAttendeeSlots = availableAttendeeSlots;
    }

    /**
     * Gets the remaining available camp committee slots for this camp.
     * @return This Camp's remaining available camp committee slots.
     */
    public int getAvailableCampComSlots() {
        return availableCampComSlots;
    }

    /**
     * Changes the remaining available camp committee slots for this camp.
     * @param availableCampComSlots This Camp's new remaining available camp committee slots.
     */
    public void setAvailableCampComSlots(int availableCampComSlots) {
        this.availableCampComSlots = availableCampComSlots;
    }

    /**
     * Gets the total attendee slots for this Camp.
     * @return This Camp's total attendee slots.
     */
    public int getAttendeeSlots() {
        return attendeeSlots;
    }

    /**
     * Changes the total attendee slots for this Camp.
     * @param newAttendeeSlots This Camp's new total attendee slots.
     */
    public void setAttendeeSlots(int newAttendeeSlots) {
        attendeeSlots = newAttendeeSlots;
    }

    /**
     * Gets the current filtered status of this Camp.
     * @return This Camp's filtered status.
     */
    public boolean getIsFilteredOut() {
        return isFilteredOut;
    }

    /**
     * Changes the current filtered status of this Camp.
     * @param isFilteredOut This Camp's new filtered status.
     */
    public void setIsFilteredOut(boolean isFilteredOut) {
        this.isFilteredOut = isFilteredOut;
    }
}
