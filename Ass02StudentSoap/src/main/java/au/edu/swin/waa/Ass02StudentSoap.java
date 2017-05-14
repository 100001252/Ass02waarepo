package au.edu.swin.waa;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * this class is main class to run soap student services
 * @author XC8184
 *
 */
public class Ass02StudentSoap{


    
    //variables
//    private ArrayList<Student> lstStudent=new ArrayList<Student>();
//    private static Integer mystudentId=1;
    
//    private SimpleDateFormat dformater=new SimpleDateFormat("dd/MM/yyyy");
    
	/**this function get all student and return in format of string
	 * 
	 * @return string all student details line by line(it has been used inside application)
	 */
    public String getAllStudent()
    {
    	  String result="";
          try{
      		Db.DbStudent dbStudent=new Db("").new DbStudent();
   	       ResultSet myRs=dbStudent.selectAllStudent();
   	       while(myRs.next())
   	       {
   	    	   result+=""+myRs.getInt("id")+"/#"+myRs.getString("fullName")+"/#"+myRs.getString("pin")+"##";

   	       }
  				    
  				    System.out.println("myNotegetallbookunibbbb only next line will be return \n"+result);
  				    
  				    
  				    
  				    
  				    
  				    return result;
          }catch(Exception e)
          {			System.out.println("");
          			return e.getMessage();
          }
      
    }
    /**this function add a new student into database
     * 
     * @param fullName
     * @param pin
     * @return
     * @throws StudentException
     */
    public String addStudent(String fullName,String pin) throws StudentException
    {
    	String result="";
    	if(fullName.equals("") || pin.equals(""))
    		throw new StudentException("please enter name and pin as they are compulsery fields for a student");
    	try{
    		
    		Db.DbStudent dbStudent=new Db("").new DbStudent();
    	       boolean ins=dbStudent.insertStudent(fullName, pin);
    	       Integer lastInt=dbStudent.getLastStudentEntered();

   				    if(ins)
   				    result="student record has been entered successfully with student id="+lastInt+" \n";
   				    else
   				    	result="there is a problem in student database and we could not insert this record \n";
   				    
   				    System.out.println(result);
   				    return result;
    		
    		
    		
    	}catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    		return e.getMessage();
    	}
    	
    }
    /** this function remove student from database
     * 
     * @param studentId
     * @return
     * @throws StudentException
     */
    public String deleteStudent(Integer studentId) throws StudentException
    {
    	String result="";
try{
    		
    		Db.DbStudent dbStudent=new Db("").new DbStudent();
    		
    		if(!dbStudent.isStudentExist2(studentId))
    			throw new StudentException("there is no student with this studentid in our database");
    		
    	       boolean ins=dbStudent.deleteStudent(studentId);
    	       
    	       
    	       

   				    if(ins)
   				    result="student with  id="+studentId+" has been deleted \n";
   				    else
   				    	result="there is a problem in student database and we could not insert this record \n";
   				    
   				    System.out.println(result);
   				    return result;
    		
    		
    		
    	}catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    		return e.getMessage();
    	}
    	
    }
    /**this function get student via studentId
     * 
     * @param studentId
     * @return
     */
    public String getStudent(Integer studentId)
    {
    	String result="";
        try{
    		Db.DbStudent dbStudent=new Db("").new DbStudent();
    		if(!dbStudent.isStudentExist2(studentId))
    			throw new StudentException("there is no student with this studentid in our database");
 	       ResultSet myRs=dbStudent.selectStudent(studentId);
 	       while(myRs.next())
 	       {
 	    	   result+="## student Id="+myRs.getInt("id")+"| fullName:"+myRs.getString("fullName")+"| pin:"+myRs.getString("pin")+"##\n ";

 	       }
				    
				    System.out.println("student result \n"+result);
				    
				    
				    
				    
				    
				    return result;
        }catch(Exception e)
        {			System.out.println("");
        			return e.getMessage();
        }
    	
    }
    /**this function is for authentication it checks 
     *  if student with the student id and pin exists in database
     * 
     * @param studentId
     * @param pin
     * @return
     */
    public String isStudentExist(Integer studentId,String pin)
    {
    	try{
    		String result="";
    		Db.DbStudent dbStudent=new Db("").new DbStudent();
    	       boolean ins=dbStudent.isStudentExist(studentId, pin);
    	       

   				    if(ins)
   				    result="student exist";
   				    else
   				    	result="student does not exist";
   				    
   				    System.out.println(result);
   				    return result;
    		
    		
    		
    	}catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    		return e.getMessage();
    	}
    	
    }
    
//    public String addStudent(String studentId,String fullName,String pin)
//    {
//        try{
//        Student stu=new Student(studentId,fullName, pin);
//        lstStudent.add(stu);
//        return "Student with id="+stu.getStudentId()+" has been added successfully";
//        }catch(Exception ex)
//        { return ex.getMessage();
//        }
//        
//    }
//    
//    public String getStudent(String studentId)
//    {
//    	Integer stId=Integer.valueOf(studentId);
//        String result="there is no Student id= "+studentId;
//       for (Iterator<Student> it = lstStudent.iterator(); it.hasNext();) {
//           Student objStudent = it.next();
//           if(objStudent.getStudentId().equals(studentId))
//           {
//               return objStudent.toString();
//           }
//       }
//       return result;
//    	
//    }
//    
//    public String authenticateStudent(String studentId,String pin)
//    {
//    	for(Student objStudent:lstStudent)
//    	{
//    		if(objStudent.getStudentId().equals(studentId) && objStudent.getPinNumber().equals(pin))
//    			return "successful login";
//    	}
//    	return "failed login";
//    }
//    
//    public String updateStudent(String id,String fullName,String pin)
//    {
//        for(Student objStudent:lstStudent)
//        {
//            if(objStudent.getStudentId().equals(id))
//            {
//                objStudent.setFullName(fullName);
//                objStudent.setPinNumber(pin);
//                return "Student detail updated successfully";
//            }
//            
//        }
//        return "there is no Student with id of "+id;
//    }
    
	
}