package bean;

public class ResponseBean{
	private int ThreadID;
	private int ResponseID;
	private String name;
	private String comments;
	private String ResponseDate;

	public void setThreadID(final int ThreadID){
		this.ThreadID=ThreadID;
	}
	public int getThreadID(){
		return ThreadID;
	}
	public void setResponseID(final int ResponseID){
		this.ResponseID = ResponseID;
	}
	public int getResponseID(){
		return ResponseID;
	}
	public void setComments(final String comments){
		this.comments = comments;
	}
	public String getComments(){
		return comments;
	}
	public void setName(final String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setResponseDate(final String ResponseDate){
		this.ResponseDate = ResponseDate;
	}
	public String getResponseDate(){
		return ResponseDate;
	}
}
