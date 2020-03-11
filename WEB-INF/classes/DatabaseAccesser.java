import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import bean.ThreadBean;
import bean.ResponseBean;

public class DatabaseAccesser{
	// 戻り値変更かも
	public void InsertThread(String title,String name){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");
			Statement st=cn.createStatement();
			// insertでタイトルと名前を入力
            String sql="insert into Thread(ThreadID,title,name,PostDate)values(Thread_sequence.nextval,?,?,default)";
			PreparedStatement pstmt = cn.prepareStatement(sql);

			pstmt.setString(1,title);
			pstmt.setString(2,name);

			ResultSet rs = pstmt.executeQuery();


		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public ArrayList getThread(){
		ArrayList ThreadList = new ArrayList();

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");
			Statement st=cn.createStatement();
			String sql = "select ThreadID,title,name,to_char(PostDate,'YYYY\"年\"MM\"月\"DD\"日\" HH24:MI:SS') from Thread order by ThreadID";
			ResultSet rs = st.executeQuery(sql);
			// ThreadListにThreadBeanの値を入力
			while(rs.next()){
				ThreadBean tb=new ThreadBean();
				int ThreadID = Integer.parseInt(rs.getString(1));
		    	String title = rs.getString(2);
		    	String name = rs.getString(3);
		    	String PostDate = rs.getString(4);

		    	tb.setThreadID(ThreadID);
		    	tb.setTitle(title);
		    	tb.setName(name);
		    	tb.setPostDate(PostDate);
				System.out.println(tb.getThreadID());
				System.out.println(tb.getPostDate());

				ThreadList.add(tb);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		//テスト用
		for(int i = ThreadList.size()-1;i>=0;i--){
			System.out.println(ThreadList.get(i));
		}
		return ThreadList;
	}
		// 最新のThreadIDを返す
	public int lastThreadID(){
		int ThreadID=0;


		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");

			String sql="select max(ThreadID) from Thread";
			Statement st=cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();

			ThreadID=Integer.parseInt(rs.getString(1));

			System.out.print(ThreadID);


		}catch(Exception e){
			e.printStackTrace();
		}

		return ThreadID;

	}
	// response表へのinsertを行う
	public void InsertResponse(int ThreadID,String name,String comments){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");

			String sql = "insert into Response(ThreadID,ResponseID,Name,comments,ResponseDate) values(?,Response_sequence.nextval,?,?,default)";

			PreparedStatement pstmt = cn.prepareStatement(sql);


			pstmt.setInt(1,ThreadID);
			pstmt.setString(2, name);
	 		pstmt.setString(3, comments);

		  ResultSet rs = pstmt.executeQuery();


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//IDが同じスレッドに入れる
	public ArrayList getResponse(int ThreadID){

		ArrayList ResponseList=new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");

			String sql = "select ThreadID,ResponseID,name,comments,to_char(ResponseDate,'YYYY\"年\"MM\"月\"DD\"日\" HH24:MI:SS') from Response where ThreadID = '"+ThreadID+"' order by ResponseID";
			Statement st=cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				ResponseBean rb=new ResponseBean();
				int threadID = Integer.parseInt(rs.getString(1));
				int ResponseID = Integer.parseInt(rs.getString(2));
		    	String name = rs.getString(3);
				String comments = rs.getString(4);
		     	String ResponseDate = rs.getString(5);

		    	rb.setThreadID(threadID);
		    	rb.setComments(comments);
		    	rb.setName(name);
		    	rb.setResponseDate(ResponseDate);

				ResponseList.add(rb);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResponseList;
	}
	//insertでタイトルを入力
	public ArrayList SearchThread(String title){
		ArrayList SearchList = new ArrayList();

		// System.out.println(title);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");
			Statement st=cn.createStatement();
			String sql = "select ThreadID,title,name,to_char(PostDate,'YYYY\"年\"MM\"月\"DD\"日\" HH24:MI:SS') from Thread where title like '%"+title+"%' order by threadid";
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){
				ThreadBean sb = new ThreadBean();
				int ThreadID = Integer.parseInt(rs.getString(1));
		    	String t_title = rs.getString(2);
		    	String name = rs.getString(3);
		    	String PostDate = rs.getString(4);

		    	sb.setThreadID(ThreadID);
		    	sb.setTitle(t_title);
		    	sb.setName(name);
		    	sb.setPostDate(PostDate);

				SearchList.add(sb);
				System.out.println(sb.getTitle());
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return SearchList;

	}
	public String getThreadTitle(int ThreadID){
		String title="reset";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection cn=
				DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl","Matumura ","kouhei");

					Statement st=cn.createStatement();
					String sql = "select title from Thread where ThreadID='"+ThreadID+"'";
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					title=rs.getString(1);





		}catch(Exception e){
			e.printStackTrace();
		}
		return title;

	}
}
