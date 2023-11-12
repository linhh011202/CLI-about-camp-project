package merge;

public class User {
    private UserDataBase userDataBase;
    private String name;
    private ISortCamps iSortCamps;
    private String filterString;
    private IFilterCamps iFilterCamps;

    public User(String name,ISortCamps iSortCamps,IFilterCamps iFilterCamps,UserDataBase userDataBase)
    {
        this.name=name;
        this.iSortCamps=iSortCamps; //default is by campName, maybe need to add some logic to set it to that if there isnt any prexisting info in DB? 
                                        //Or maybe in DB preset is alr Alpha so error checking should be here anyways??..

        this.filterString=null;
        this.iFilterCamps=iFilterCamps;
        this.userDataBase=userDataBase;
    }

    
    public ISortCamps getSortCamps()
    {
        return iSortCamps;
    }

    public void setCampSorter(ISortCamps iSortCamps)
    {
        this.iSortCamps=iSortCamps;
    }

    public IFilterCamps getFilterCamps()
    {
        return iFilterCamps;
    }
    public void setCampFilter(IFilterCamps iFilterCamps)
    {
        this.iFilterCamps=iFilterCamps;
    }

    public String getName(){return name;}

    public String getFilterString(){return filterString;}
    public void setFilterString(String filterString){this.filterString=filterString;}

    public UserDataBase getUserDataBase(){return userDataBase;}
}
