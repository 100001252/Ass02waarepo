package au.edu.swin.waa;
import com.mysql.jdbc.Driver;

import java.sql.*;


public class Db {
	

	   // private static String url="jdbc:mysql://localhost::3306/oztutor123";
	    private String url;
	    private String user;
	    private String pass;
	    private Connection myConn;
	    private Statement myStmt;
	    private ResultSet myRs;
	    private String  dbName;
	    /**constructor to connect to db 
	     * 
	     * @param dbName database name
	     */
	    public Db(String dbName)
	    {
	        try{
	        if(dbName.equals(""))
	            dbName="waa";
	        this.url="jdbc:mysql://localhost:3306/"+dbName;
	        this.user="admin2";
	        this.pass="admin2";
	        myConn=DriverManager.getConnection(this.url,this.user,this.pass);
	        }catch(Exception e){
	            System.out.println("erro"+e.getMessage());
	        }
	    }
	    
	    /**constructor to connect to db 
	     * 
	     * 
	     */
	    public Db()
	    {
	        try{
	        
	          dbName="waa";
	        this.url="jdbc:mysql://localhost:3306/"+dbName;
	        this.user="root";
	        this.pass="";
	        myConn=DriverManager.getConnection(this.url,this.user,this.pass);
	        }catch(Exception e){
	            System.out.println("erro"+e.getMessage());
	        }
	    }
	    
	    
	    
	
	    /** inner class DBStudent for database student
	     * 
	     * @author XC8184
	     *
	     */
	    public class DbStudent{
	    	private String tableName="students";
	    	private String dbName="waa";
	    	/**constructor for DBSTUDENT CLASS
	    	 * 
	    	 */
	    	public DbStudent() {
				// TODO Auto-generated constructor stub
			}
	    	/** this function return all student as resultset
	    	 * 
	    	 * @return studentrecords as resultset
	    	 * @throws StudentException
	    	 */
	    	public ResultSet selectAllStudent() throws StudentException
	    	{
	    		try{
		            myStmt = myConn.createStatement();
		            myRs = myStmt.executeQuery("select * from "+tableName);
		            return myRs;
		        
		        }catch(Exception e)
		        {
		            System.out.println(e.getMessage());
		            throw new StudentException(" Student database there is issue with our database");
		            
		        }
	    		
	    	}
	    	/** you can select specific student by id and it returns that student result set
	    	 * 
	    	 * @param studentId
	    	 * @return studentresultset
	    	 * @throws StudentException
	    	 */
	    	public ResultSet selectStudent(Integer studentId) throws StudentException
	    	{
	    		try{
		            myStmt = myConn.createStatement();
		            myRs = myStmt.executeQuery("select * from "+tableName+" where id="+studentId);
		            return myRs;
		        
		        }catch(Exception e)
		        {
		            System.out.println(e.getMessage());
		            throw new StudentException(" Student database there is issue with our database");
		            
		        }
	    		
	    	}
	    	/** it delete student from database by studentid
	    	 * 
	    	 * @param studentId
	    	 * @return if it delete successfully it returns true otherwise false
	    	 * @throws StudentException
	    	 */
	    	public boolean deleteStudent(Integer studentId) throws StudentException
	    	{
	    		try{
	    			myStmt = myConn.createStatement();
		            String sql = "delete from "+dbName+"."+tableName+" where id="+studentId;
		            System.out.println(sql);
		            myStmt.executeUpdate(sql);

		            return true;
	    			
	    		}catch(Exception e){
	    			System.out.println(e.getMessage());
		            throw new StudentException("err408: Student database there is issue with our database");
	    		}
	    		
	    		
	    	}
	    	/** it check authentication user if studentid and correspondence pin exists in database
	    	 * 
	    	 * @param studentId
	    	 * @param pin
	    	 * @return true if it exists and false if it does not exist
	    	 * @throws StudentException
	    	 */
	    	public boolean isStudentExist(Integer studentId,String pin) throws StudentException
	    	{
	    		boolean result=false;
	    		try{
		            myStmt = myConn.createStatement();
		            
		            myRs = myStmt.executeQuery("select count(*) from "+dbName+"."+tableName+" where "
		            		+ "id="+studentId+" and pin="+pin);
		            while(myRs.next())
		            {
		            	if(myRs.getInt(1)>0)
		            	{
		            		result=true;
		            	}
		            	
		            	
		            }
		        
		        }catch(Exception e)
		        {
		            System.out.println(e.getMessage());
		            throw new StudentException(" Student database there is issue with our database");
		            
		        }
	    		return result;
	    		
	    	}
	    	/** it check student id in database without pin to see if we have that student id in database
	    	 * 
	    	 * @param studentId
	    	 * @return true if it exists, and false if it does not
	    	 * @throws StudentException
	    	 */
	    	public boolean isStudentExist2(Integer studentId) throws StudentException
	    	{
	    		boolean result=false;
	    		try{
		            myStmt = myConn.createStatement();
		            
		            myRs = myStmt.executeQuery("select count(*) from "+dbName+"."+tableName+" where "
		            		+ "id="+studentId+"");
		            while(myRs.next())
		            {
		            	if(myRs.getInt(1)>0)
		            	{
		            		result=true;
		            	}
		            	
		            	
		            }
		        
		        }catch(Exception e)
		        {
		            System.out.println(e.getMessage());
		            throw new StudentException(" Student database there is issue with our database");
		            
		        }
	    		return result;
	    		
	    	}
	    	/** create a new student records in database 
	    	 * 
	    	 * @param fullName
	    	 * @param pin
	    	 * @return true if inserted successfully and false if not successfull
	    	 * @throws StudentException
	    	 */
	    	public boolean insertStudent(String fullName,String pin) throws StudentException
	    	{
	    		try{
	    			myStmt = myConn.createStatement();
		            String sql = "insert into "+dbName+"."+tableName+"(`fullName`,`pin`,`createdTime`)"
		            		+ " values('"+fullName+"','"+pin+"',now())";
		            System.out.println(sql);
		            myStmt.executeUpdate(sql);

		            return true;
	    			
	    		}catch(Exception e){
	    			System.out.println(e.getMessage());
		            throw new StudentException("err408: Student database there is issue with our database");
	    		}
	    	}
	    	/**this function help to show student id after i entered student into db. so we can show student id after creation
	    	 * 
	    	 * @return student_id as integer
	    	 * @throws StudentException
	    	 */
	    	public Integer getLastStudentEntered() throws StudentException
	    	{
	    		Integer result=null;
	    		try{
		            myStmt = myConn.createStatement();
		            myRs = myStmt.executeQuery("select id from "+tableName+" order by id desc limit 1");
		            while(myRs.next())
		            {
		            	result=myRs.getInt(1);
		            }
		            
		            return result;
		        
		        }catch(Exception e)
		        {
		            System.out.println(e.getMessage());
		            throw new StudentException(" Student database there is issue with our database");
		            
		        }
	    		
	    	}
	    }
	    
	    

	    
	    

}
