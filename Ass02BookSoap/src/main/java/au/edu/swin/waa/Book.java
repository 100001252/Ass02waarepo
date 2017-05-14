/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.swin.waa;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/** book class to store some of data structure temprarily in book(actual use is in application)
 *
 * @author XC8184
 */
public class Book {
    //------------------------------------------------------------variable
   // private Integer bookId;
    private String bookTitle;
    private String authorList;
    private String isbn; //in both formate of 10digit and 13digit is only valid
    private String publisher;
    private Date publishDate;
    private String status; //it should be only available onloan or backOrder
    private Integer Student_id;
    
    private SimpleDateFormat dformater;
    
    
    //---------------------------------------------------------------end variable
    /** constructor for book class
     * 
     * @param bookTitle
     * @param authorList
     * @param isbn
     * @param publisher
     * @param publishDate
     * @param status
     * @param stid
     * @throws BookException
     */
    public Book(String bookTitle,String authorList,String isbn,
            String publisher,String publishDate,String status,Integer stid) throws BookException
    {
        dformater=new SimpleDateFormat("dd/MM/yyyy");
        
     
        this.bookTitle=bookTitle;
        this.authorList=authorList;
        if(!isIsbnValid(isbn))
            throw new BookException("isbn has to be 13 or 10 digit number");
        this.isbn=isbn;
        this.publisher=publisher;
        
        Date pdate=this.convertStringTodate(publishDate);
        this.publishDate=pdate;
        if(!isStatusValid(status))
            throw new BookException("Error: status has to be either (available, on loan, back order)");
        this.status=status;
        
        this.Student_id=stid;
        
        
    }
    /** function to check if status is one of the valu (available,on loan, back order)
     * 
     * @param status
     * @return if the value is one of those accepted values return true otherwise false
     */
    public static boolean isStatusValid(String status)
    {
    	boolean result=false;
    	if(status.equals("available") || status.equals("on loan") || status.equals("back order"))
            result=true;
    	return result;
    }
    /** function to check if isbn is numeric and exactly 10digit or 13 digit
     * 
     * @param s
     * @return if that is valid it returns true otherwise it returns false
     */
    public static boolean isIsbnValid(String s)
    {
        

int count = 0;
for (int i = 0, len = s.length(); i < len; i++) {
    if (Character.isDigit(s.charAt(i))) {
        count++;
    }
}
if(count==10 || count==13)
    return true;
else
    return false;


    }
    
    /** function to convert string date format(dd/mm/yy) to Date format
     * 
     * @param date2
     * @return DATE in DATE FORMAT
     */
    public Date convertStringTodate(String date2)
    {
        try{
        Date date1=dformater.parse(date2);
        return date1;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        
        
    }
    
    

  
    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the authorList
     */
    public String getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(String authorList) {
        this.authorList = authorList;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) throws BookException {
        if(!isIsbnValid(isbn))
            throw new BookException("isbn has to be 13 or 10 digit number");
        this.isbn = isbn;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the publishDate
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public void setPublishDate(String publishd){
     Date pdate=this.convertStringTodate(publishd);
     this.publishDate=pdate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) throws BookException {
        if(!status.equals("available") && !status.equals("on loan") && !status.equals("back order"))
            throw new BookException("Error: status has to be either (available, on loan, back order)");    
        this.status = status;
    }
    /* toString function to return String format of all details reletaed to that book
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return " bookTitle:"+this.bookTitle+" isbn:"+this.isbn+" Publisher:"+this.publisher+" authorList:"+this.authorList+" status:"+this.status+"#\n";
    }

	private Integer getStudent_id() {
		return Student_id;
	}

	private void setStudent_id(Integer student_id) {
		Student_id = student_id;
	}

   
}
