package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*; 
import user.*;

import java.time.LocalDate;
import java.io.PrintWriter;
import java.io.*;

public class Camp implements Serializable
{
    private String campName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate regClosingDate;
    private boolean visibility;
    private String location;
    private int totalSlots;
    private int attendeeSlots;
    private int campComSlots;
    private int availableCampComSlots;
    private int availableAttendeeSlots;
    private String description;
    private String staffInCharge;
    private Faculty openTo;
    private boolean isFilteredOut;

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

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getStringStartDate() {
        return DateUtils.dateToString(startDate);
    }

    public void setStartDate(String startDate) {
        // Consider error checking for format and whether startDate>endDate;
        LocalDate lStartDate = DateUtils.stringToDate(startDate);
        this.startDate = lStartDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStringEndDate() {
        return DateUtils.dateToString(endDate);
    }

    public void setEndDate(String endDate) {
        // Consider error checking for format and whether startDate>endDate;
        LocalDate lEndDate = DateUtils.stringToDate(endDate);
        this.startDate = lEndDate;
    }

    public LocalDate getRegClosingDate() {
        return regClosingDate;
    }

    public String getStringRegClosingDate() {
        return DateUtils.dateToString(regClosingDate);
    }

    public void setregClosingDate(String regClosingDate) {
        LocalDate lRegClosingDate = DateUtils.stringToDate(regClosingDate);
        this.regClosingDate = lRegClosingDate;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public int getCampComSlots() {
        return campComSlots;
    }

    public void setCampComSlots(int campComSlots) {
        this.campComSlots = campComSlots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaffInCharge() {
        return staffInCharge;
    }

    public void setStaffInCharge(String staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    public Faculty getOpenTo() {
        return openTo;
    }

    public String getStringOpenTo() {
        return openTo.toString();
    }

    public void setOpenTo(Faculty openTo) {
        this.openTo = openTo;
    }

    public int getAvailableAttendeeSlots() {
        return availableAttendeeSlots;
    }

    public void setAvailableAttendeeSlots(int availableAttendeeSlots) {
        this.availableAttendeeSlots = availableAttendeeSlots;
    }

    public int getAvailableCampComSlots() {
        return availableCampComSlots;
    }

    public void setAvailableCampComSlots(int availableCampComSlots) {
        this.availableCampComSlots = availableCampComSlots;
    }

    public int getAttendeeSlots() {
        return attendeeSlots;
    }

    public void setAttendeeSlots(int newAttendeeSlots) {
        attendeeSlots = newAttendeeSlots;
    }

    public boolean getIsFilteredOut() {
        return isFilteredOut;
    }

    public void setIsFilteredOut(boolean isFilteredOut) {
        this.isFilteredOut = isFilteredOut;
    }
}
