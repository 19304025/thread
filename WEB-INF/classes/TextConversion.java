public class TextConversion {
	public String TextReplace(String text){
		String afterText=text.replace("&","&amp").replace("<","&lt").replace(">","&gt").replace("\"","&quot").replace("'","&#39").replace("\r\n","<br>");
		return afterText;
	}
}
