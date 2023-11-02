package camp;

public class Camp 
{
    private String campName;
    private String startDate;
    private String endDate;
    private String regClosingDate;
    private boolean visibility;
    private String location;
    private int totalSlots;
    private int campComSlots;
    private String description;
    private String staffInCharge;
    private Faculty openTo;

    public Camp(String campName,String startDate,String endDate, String regClosingDate,boolean visibility, String location, int totalSlots,int campComSlots,String description,User user,Faculty openTo)
    {
        this.campName=campName;
        this.startDate=startDate;
        this.endDate=endDate;
        this.regClosingDate=regClosingDate;
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

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) {this.startDate=startDate;}

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) {this.endDate=endDate;}

    public String getRegClosingDate() { return regClosingDate; }
    public void setregClosingDate(String regClosingDate) {this.regClosingDate=regClosingDate;}

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
