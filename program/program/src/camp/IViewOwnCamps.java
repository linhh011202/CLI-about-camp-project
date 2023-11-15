package camp;

public interface IViewOwnCamps {
    // TBC Probably need to implement a student ViewOwnCamps as well for his
    // registered camps.
    // Should student be able to see campDetails? assignment says show slots avail
    // only, but doesn't make sense right? Dont they need to know
    // registration dates etc??
    public void viewOwnCamps(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString);
}