package staff;

import java.util.ArrayList;

public class Staff extends User
{
    private ArrayList<Camp> camps; //seems like a bad idea to directly composition the camps to the staff with nothing in between though.
    private CampOperator campOperator;
    private SuggestionOperator suggestionOperator;
    private EnquiryOperator enquiryOperator;
    
    public Staff()
    {
        this.campOperator=new CampOperator(this);
        this.suggestionOperator=new SuggestionOperator(this);
        this.enquiryOperator= new EnquiryOperator(this);
    }
    public Staff(String name, String password, String facultyInformation) {
        super(String name, String password, String facultyInformation);
        this.camps = new ArrayList<>();
        this.campOperator=new CampOperator(this);
        this.suggestionOperator=new SuggestionOperator(this);
        this.enquiryOperator= new EnquiryOperator(this);
    }

    public ArrayList<Camp> getCamps()
    {
        return this.camps;
    }

}
