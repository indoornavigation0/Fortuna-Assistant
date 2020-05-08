import java.util.HashMap;

public class Domain extends sentencebreak {
	String walkDom = " ";
	String turnDom = " ";
	String sitState = " ";
	String speakDom = " ";
	String avoidDom = " ";
	HashMap<String, String> domainmap = new HashMap<String, String>();
	public HashMap<String, String> domain(String data){
	{
		sentencebreak sentencebreak;
		sentencebreak = new sentencebreak();
		sentencebreak.dataPre(data);
	if(sentencebreak.arr.contains("walk ")){
		walkDom = "Steve should tap screen for every step";
		domainmap.put("walkdomain", walkDom);
	}
	if(sentencebreak.arr.contains("turn")){
		turnDom = "Steve should hold phone in his hands";
        domainmap.put("turndomain", turnDom);
		//System.out.println(turnDom);
	}
	if(sentencebreak.arr.contains("sit")){
		sitState = "Steve turns the camera on before starting to walk";
		domainmap.put("sitdomain", sitState);
		//System.out.println(sitState);
	}
	if(sentencebreak.getData().isEmpty()){
		speakDom = "Steve should tap screen for every step";
		domainmap.put("speaddomain", speakDom);
		//System.out.println(speakDom);
	}
	if(sentencebreak.arr.contains("avoid")){
		avoidDom = "Steve turns the camera on before starting to walk";
		domainmap.put("avoiddomain", avoidDom);
		//System.out.println(avoidDom);
	}
}
    return domainmap;
}
}