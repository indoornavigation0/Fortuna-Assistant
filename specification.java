import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class specification extends sentencebreak{
    int noofsteps = 0;
    String walkState = " ";
    String turnState = " ";
    String sitSpec = " ";
    String obstacleState =" ";
    String speakState =" ";
    Map<String, List<String>> datamap= new HashMap<>();
    HashMap<String, String> specificationmap = new HashMap<String, String>();
    public HashMap<String, String> specfunc(Map<String, String> data1, String data, List<String> data2){
        sentencebreak sentencebreak;
        sentencebreak = new sentencebreak();
        sentencebreak.dataPre(data);

        if(sentencebreak.arr.contains("walk ")){
            noofsteps = noofsteps + 1;
            String[] walkReqArr = sentencebreak.walkReq.split("\\s+");
            int taps=0;
            taps = walkReqArr.length-2;
            walkState = "Specification: if the detected screen taps are" +" " + walkReqArr[taps] +"," + "Theia notifies with voice message that" +" "+ walkReqArr[taps] +" " + "steps are walked.";
            specificationmap.put("walkstate", walkState);
        }
        else if(sentencebreak.getData().isEmpty()){
            speakState = "Specification: Theia asks steve to pass an action";
            //System.out.println(speakState);
            specificationmap.put("speakstate", speakState);
        }
        if(sentencebreak.arr.contains("turn")){
            turnState="Specification: if the orientation of the magnetometer is in the direction of the turn.Theia indicates steve with voice message to take the turn";
            //System.out.println(turnState);
            specificationmap.put("turnstate", turnState);
        }
        else{
            String turnSpec = "Specification: Theia should indicate steve to continue walking until turn arrives";
            specificationmap.put("turnspec", turnSpec);
            //System.out.println("Specification: Theia should indicate steve to continue walking until turn arrives");
        }
        if(sentencebreak.arr.contains("sit")){
            if(sentencebreak.arr.contains("chair")){
                sitSpec="Specification: if the image of the chair is found,Theia pass an voice message indicating steve to sit carefully";
                specificationmap.put("sitspec", sitSpec);
                //System.out.println(sitSpec);
            }
        }
	/*if(sentencebreak.getData().isEmpty()){
			speakState = "Theia asks steve to pass an action";
			System.out.println(speakState);
		}*/
        if(sentencebreak.arr.contains("avoid")){
            if(sentencebreak.arr.contains("obstacle")){
                obstacleState = "Specification: if the camera detects the obstacle-, Theia notifies with a voice message that Avoid the obstacle in your way";
                specificationmap.put("obstaclestate", obstacleState);
                //System.out.println(obstacleState);
            }
        }
        return specificationmap;
    }
}