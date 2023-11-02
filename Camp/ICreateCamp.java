package camp;

public interface ICreateCamp 
{
    public void createCamp(String campName,String startDate,String endDate, String regClosingDate,boolean visibility, String location, int totalSlots,int campComSlots,String description,User user,Faculty openTo);
}
