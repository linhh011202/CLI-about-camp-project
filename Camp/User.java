package camp;

public class User {
    private String name;
    private ISortCamps iSortCamps;
    private String filterString;

    public User(String name,ISortCamps iFilterCamps)
    {
        this.name=name;
        this.iSortCamps=iFilterCamps; //default is by campName, maybe need to add some logic to set it to that if there isnt any prexisting info in DB? 
                                        //Or maybe in DB preset is alr Alpha so error checking should be here anyways??..

        this.filterString=null;
    }

    public void setCampFilter(ISortCamps iFilterCamps)
    {
        this.iSortCamps=iFilterCamps;
    }

    public ISortCamps getSortCamps()
    {
        return iSortCamps;
    }

    public String getName(){return name;}

    public String getFilterString(){return filterString;}
    public void setFilterString(String filterString){this.filterString=filterString;}
}
