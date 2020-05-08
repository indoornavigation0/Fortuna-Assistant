import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generatequestions {
    String question = "What if";
    String datareplaced;
    List<String> data3=new ArrayList<>();
    public String replacefunc(String data2){
//        String data1 = data.replaceAll("\\.|,",  "\n");
//        List<String> data2 = Arrays.asList(data1.split("\n"))
        //for(int i = 0;i<data2.size()-1;i++){
            if(data2.contains("are")) {
                datareplaced = data2.replaceAll("are", "are not");
            }
            else if(data2.contains("notifies")){
                datareplaced = data2.replaceAll("notifies", "does not notify");
            }
            else if(data2.contains("is")){
                datareplaced = data2.replaceAll("is", "is not");
            }
            else if(data2.contains("Theia")){
                datareplaced = data2.replaceAll("Theia", "Theia does not");
            }
            else if(data2.contains("pass")){
                datareplaced = data2.replaceAll("pass", "did not pass");
            }
            else if(data2.contains("detects")){
                datareplaced = data2.replaceAll("detects", "did not detect");
            }

        return datareplaced;
}
    public List<String> gqfunc(String data){
        String data1 = data.replaceAll("\\.|,",  "\n");
        List<String> data2 = Arrays.asList(data1.split("\n"));
        for(int i = 0;i<data2.size()-1;i++) {
            String datarep = replacefunc(data2.get(i));
            data3.add(datarep);
        }
        return data3;
    }
}
