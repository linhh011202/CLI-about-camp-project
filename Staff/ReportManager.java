import java.io.File;
import java.io.IOException;

public class ReportManager {
  public ReportManager(){
  }
  public File createFile(String s) {
    s += ".csv";
    try {
      File myObj = new File(s);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        return myObj;
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
  }
  public void report(String s, Filter filter, Staff staff){
    File f = this.createFile(s);
    if (f == null) return;
    throws IOException {
    FileWriter fileWriter = new FileWriter(f);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    printWriter.printf("%s, ", placeholder);
    printWriter.close();
  }
  }
  public void performanceReport(Staff staff){
    for
  }
}
