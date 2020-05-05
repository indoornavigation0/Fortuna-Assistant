import java.util.*;

public class sentencebreak {
    ArrayList<String> RequirementArray = new ArrayList<String>();
    String input = "";
    String sent = "";
    String sentbr = "";
    String arr = " ";
    String walkReq = " ";
    String data = "";
    String testarr = "";
    String status = "";
    //List<String> input1 = new ArrayList<String>();
    HashMap<String, List<String>> requirementmap = new HashMap<String, List<String>>();
    List<String> requirementlist = new ArrayList<String>();
    List<String> nonrequirementlist = new ArrayList<String>();

    public HashMap dataPre(String data1) {
        //String data1 = data.toString();
        if (data1.contains(".") || data1.contains("When") || data1.contains("What") || data1.contains("Where") || data1.contains("Why") || data1.contains("How") || data1.contains("and")) {
            sent = data1.replace("and", "\n Theia should ask steve to ");
            input = sent.replaceAll("When|What|Where|Why|How|\\.|,", "\n");
        }
        String[] inparr = input.split("\n");
        arr = Arrays.toString(inparr);
        walkReq = inparr[2];
        int i = 1;
       while(i < inparr.length) {
            if (inparr[i].contains("asks") || inparr[i].contains("shall") || inparr[i].contains("should")) {
                //requirementmap.put(input,"This is a requirement");
                //break;
                status = "This is a requirement";
                //System.out.println(status);
                requirementlist.add(inparr[i]);
                requirementmap.put(status, requirementlist);
                //System.out.println(requirementmap);
                //return requirementmap;
            } else {
                //notrequirementmap.put(input,"This is not a requirement");
                status="This is not a requirement";
                //System.out.println(status);
                nonrequirementlist.add(inparr[i]);
                requirementmap.put(status, nonrequirementlist);
                //return nonrequirementmap;
            }
            i++;
            }
	/*for(int j =0; j<RequirementArray.size();j++){
		String arrout=requirementmap.get(j);
		//System.out.println(arrout);
		RequirementArray.add(arrout);
		testarr=RequirementArray.get(j);
		}*/
            //System.out.println(notrequirementmap);
            //System.out.println(requirementmap);
            //}When steve indicates a destination, Theia shall notify steve to walk 10 steps and turn right


        //}
        //System.out.println(requirementmap);
        return requirementmap;
    }
        public void setData (String data){
            this.data = data;
        }
        public String getData () {
            return data;
        }
    }

