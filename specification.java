import java.util.*;

public class specification {
    List<String> data = new ArrayList<String>();
    public List<String> specfunc(Map<String, String> data1, String data2){
        for(Map.Entry<String, String> entry: data1.entrySet()){
            String keys = entry.getKey();
            String values = entry.getValue();
            System.out.println(keys);
            System.out.println(values);
            data.add(values);
            data.add(keys);
        }
        return data;
    }
}

