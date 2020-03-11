public class ResponseBean{
	private int ThreadID;
	private int ResponseID;
	private String name;
	private String comments;
	private String ResponseDate;

	public void setThreadID(int ThreadID){
		this.ThreadID=ThreadID;
	}
	public int getThreadID(){
		return ThreadID;
	}
	public void setResponseID(int ResponseID){
		this.ResponseID = ResponseID;
	}
	public int getResponseID(){
		return ResponseID;
	}
	public void setComments(String comments){
		this.comments = comments;
	}
	public String getComments(){
		return comments;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setResponseDate(String ResponseDate){
		this.ResponseDate = ResponseDate;
	}
	public String getResponseDate(){
		return ResponseDate;
	}
}
