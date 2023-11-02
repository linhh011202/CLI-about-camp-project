package camp;

public interface IEditCamp 
{
    public boolean changeCampName(User user,String campName,String newCampName);
    public boolean changeStartDate(User user,String campName,String newStartDate);
    public boolean changeRegClosingDate(User user,String campName,String newRegClosingDate);
    public boolean changeVisibility(User user,String campName,boolean newVisibility);
    public boolean changeLocation(User user,String campName,String newLocation);
    public boolean changeTotalSlots(User user,String campName,int newTotalSlots);
    public boolean changeCampComSlots(User user,String campName,int newCampComSlots);
    public boolean changeDescription(User user,String campName,String newDescription);

    /*  DO WE ALLOW TO CHANGE WHO ITS OPEN TO?? what if alr registered then change away.
    public boolean changeOpenTo()
    */
}
