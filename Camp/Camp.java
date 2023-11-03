package camp;

import java.time.LocalDate;

public class Camp 
{
    private String campName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate regClosingDate;
    private boolean visibility;
    private String location;
    private int totalSlots;
    private int campComSlots;
    private String description;
    private String staffInCharge;
    private Faculty openTo;

    public Camp(String campName,String startDate,String endDate, String regClosingDate,boolean visibility, String location, int totalSlots,int campComSlots,String description,User user,Faculty openTo)
    {
        //Consider error checking and throwing exception if dates not in proper format, or startDate>endDate, etc.
        LocalDate lStartDate=DateUtils.stringToDate(startDate);
        LocalDate lEndDate=DateUtils.stringToDate(endDate);
        LocalDate lRegClosingDate=DateUtils.stringToDate(regClosingDate);
        this.campName=campName;
        this.startDate=lStartDate;
        this.endDate=lEndDate;
        this.regClosingDate=lRegClosingDate;
        this.visibility=visibility;
        this.location=location;
        this.totalSlots=totalSlots;
        this.campComSlots=campComSlots;
        this.description=description;
        this.staffInCharge=user.getName();
        this.openTo=openTo;
    }

    public String getCampName() { return campName; }
    public void setCampName(String campName) {this.campName=campName;}

    public LocalDate getStartDate() { return startDate; }
    public String getStringStartDate(){return DateUtils.dateToString(startDate);}
    public void setStartDate(String startDate) 
    {
        //Consider error checking for format and whether startDate>endDate;
        LocalDate lStartDate=DateUtils.stringToDate(startDate);
        this.startDate=lStartDate;
    }

    public LocalDate getEndDate() { return endDate; }
    public String getStringEndDate(){return DateUtils.dateToString(endDate);}
    public void setEndDate(String endDate) 
    {
        //Consider error checking for format and whether startDate>endDate;
        LocalDate lEndDate=DateUtils.stringToDate(endDate);
        this.startDate=lEndDate;
    }

    public LocalDate getRegClosingDate() { return regClosingDate; }
    public String getStringRegClosingDate(){return DateUtils.dateToString(regClosingDate);}
    public void setregClosingDate(String regClosingDate) 
    {
        LocalDate lRegClosingDate=DateUtils.stringToDate(regClosingDate);
        this.regClosingDate=lRegClosingDate;
    }

    public boolean getVisibility() { return visibility; }
    public void setVisibility(boolean visibility) {this.visibility=visibility;}

    public String getLocation() { return location; }
    public void setLocation(String location) {this.location=location;}

    public int getTotalSlots() { return totalSlots; }
    public void setTotalSlots(int totalSlots) {this.totalSlots=totalSlots;}

    public int getCampComSlots() { return campComSlots; }
    public void setCampComSlots(int campComSlots) {this.campComSlots=campComSlots;}

    public String getDescription() { return description; }
    public void setDescription(String description) {this.description=description;}

    public String getStaffInCharge() { return staffInCharge; }
    public void setStaffInCharge(String staffInCharge) {this.staffInCharge=staffInCharge;}

    public Faculty getOpenTo() { return openTo; }
    public void setOpenTo(Faculty openTo) {this.openTo=openTo;}
}
