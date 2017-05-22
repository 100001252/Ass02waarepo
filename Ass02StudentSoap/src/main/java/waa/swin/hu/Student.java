/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waa.swin.hu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/** this is student class in case of temprary storing student details(main student class has been used in application)
 *
 * @author XC8184
 */
public class Student// implements Comparable<Student> if we wanted to compare student together 
{
    
    
    //------------------------------------------variable
    private String studentId;
    private String fullName;
    private String pinNumber; // has to be 4 digit throw exception if it is not
//    private ArrayList<Book> lstborrow;
//    private ArrayList<Book> lstorder;
    
    
    //--------------------------------------
    
    /**
     * constructor
     * @param stid
     * @param fn
     * @throws Exception 
     */
    public Student(String stid,String fn,String pn)throws StudentException
    {
        if(stid==null)
            throw new StudentException("student id is empty.");
        if(fn==null)
            throw new StudentException("full name is empty..");
        
        this.fullName=fn;
        this.studentId=stid;
        this.pinNumber=pn;
//        this.lstborrow=new ArrayList<Book>();
//        this.lstorder=new ArrayList<Book>();
    }
    
    
    
    

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the pinNumber
     */
    public String getPinNumber() {
        return pinNumber;
    }

    /**
     * @param pinNumber the pinNumber to set
     */
    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

  
    /* to string class overwrite of the main one to return all details of student in String format
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
    	return "#student name"+this.fullName+" # studentID:"+this.studentId+" # studentpin:"+this.pinNumber;
    }
}
