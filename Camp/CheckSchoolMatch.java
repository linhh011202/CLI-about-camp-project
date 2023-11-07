package camp;

public class CheckSchoolMatch implements ICheckSchoolMatch
{
    private CampDataBase campDataBase;
    
    public CheckSchoolMatch(CampDataBase campDataBase){this.campDataBase=campDataBase;}

    public boolean checkSchoolMatch(Student student,String campName)
    {
        //Try to find camp. If found, check if its open to the student's school.
        for(int i=0;i<campDataBase.getAllCamps().size();++i)
        {
            if(campDataBase.getAllCamps().get(i).getCampName().equals(campName))
            {
                if(student.getFaculty()==campDataBase.getAllCamps().get(i).getOpenTo()||campDataBase.getAllCamps().get(i).getOpenTo()==Faculty.NTU)
                {
                    return true;
                }
                else
                {
                    System.out.println("That camp is not open to students from your school!");
                    return false;
                }
            }
        }

        //Camp doesnt exist. Cant match.
        System.out.println("Could not find Camp!");
        return false;
    }
}
