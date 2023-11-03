package camp;

public class User {
    private String name;
    private IFilterCamps iFilterCamps;

    public User(String name,IFilterCamps iFilterCamps)
    {
        this.name=name;
        this.iFilterCamps=iFilterCamps; //default is by campName, maybe need to add some logic to set it to that if there isnt any prexisting info in DB? 
                                        //Or maybe in DB preset is alr Alpha so error checking should be here anyways??..
    }

    public void setCampFilter(IFilterCamps iFilterCamps)
    {
        this.iFilterCamps=iFilterCamps;
    }

    public IFilterCamps getFilterCamps()
    {
        return iFilterCamps;
    }

    public String getName(){return name;}
}
