package au.edu.swin.waa;

import java.util.*;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import au.edu.swin.waa.Db.DbBook;
import au.edu.swin.waa.Db.DbStudentBorrow;

/**
 * UnilibBook is the class that implement book rest services
 *
 * @author XC8184
 */
public class Ass02BookSoap {

	/**
	 * get all book in unilib
	 *
	 * @return all book in String format
	 */
	public String getAllBook() {

		String result = "";
		try {
			Db.DbBook dbBook = new Db("").new DbBook();
			ResultSet myRs = dbBook.getAllBooks();
			while (myRs.next()) {
				result += "" + myRs.getInt("id") + "/#"
						+ myRs.getString("title") + "/#"
						+ myRs.getString("authorList") + "/#"
						+ myRs.getString("isbn") + "/#"
						+ myRs.getString("publisher") + "/#"
						+ myRs.getString("publishDate") + "/#"
						+ myRs.getString("status") + "##";
				// lstBook.add(new
				// Book(myRs.getInt("id")/#myRs.getString(2),myRs.getString(3),myRs.getString(4),myRs.getString("publisher"),myRs.getString("publishDate"),myRs.getString("status"),myRs.getInt("student_id")));
			}

			System.out.println("myNotegetallbookunibbbb \n" + result);
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/**
	 * get records of one specific student
	 *
	 * @param studentId
	 * @return student details in String format
	 */
	public String getRecordsStudent(Integer studentId) {
		String result = "";
		try {
			Db.DbStudentBorrow dbborrow = new Db("").new DbStudentBorrow();
			ResultSet myRs = dbborrow.getRecordsOfStudent(studentId);
			while (myRs.next()) {
				result += "" + myRs.getInt("id") + ","
						+ myRs.getInt("student_id") + ","
						+ myRs.getInt("book_id") + ","
						+ myRs.getString("action") + "##";
				// lstBook.add(new
				// Book(myRs.getInt("id"),myRs.getString(2),myRs.getString(3),myRs.getString(4),myRs.getString("publisher"),myRs.getString("publishDate"),myRs.getString("status"),myRs.getInt("student_id")));
			}

			System.out
					.println("myNotegetrecordssttt specific student records \n"
							+ result);
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public boolean isIsbnExist(String isbn) {
		boolean result = false;
		try {
			Db.DbBook dbbook = new Db("").new DbBook();
			result = dbbook.isIsbnExist(isbn);

			System.out
					.println("myNotegetrecordssttt specific student records \n"
							+ result);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;

	}

	/**
	 * get records of one specific student just different version and it gives
	 * more infor
	 *
	 * @param studentId
	 * @return student details in String format
	 */
	public String getRecordsStudent2(Integer studentId) {
		String result = "";
		try {
			Db.DbStudentBorrow dbborrow = new Db("").new DbStudentBorrow();
			ResultSet myRs = dbborrow.getRecordsOfStudent2(studentId);
			while (myRs.next()) {
				result += "" + myRs.getInt("br.id") + ","
						+ myRs.getInt("br.student_id") + ","
						+ myRs.getInt("br.book_id") + ","
						+ myRs.getString("bk.title") + ","
						+ myRs.getString("bk.status") + ","
						+ myRs.getString("action") + "##";
				// lstBook.add(new
				// Book(myRs.getInt("id"),myRs.getString(2),myRs.getString(3),myRs.getString(4),myRs.getString("publisher"),myRs.getString("publishDate"),myRs.getString("status"),myRs.getInt("student_id")));
			}

			System.out
					.println("myNotegetrecordssttt specific student records \n"
							+ result);
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/**
	 * get all student details
	 *
	 * @param studentId
	 * @return all student details in string format
	 */
	public String getAllStudentRecords() {
		String result = "";
		try {
			Db.DbStudentBorrow dbborrow = new Db("").new DbStudentBorrow();
			ResultSet myRs = dbborrow.getAllStudentRecords();
			while (myRs.next()) {
				result += "" + myRs.getInt("id") + "/#"
						+ myRs.getInt("student_id") + "/#"
						+ myRs.getInt("book_id") + "/#"
						+ myRs.getString("action") + "##";
				// lstBook.add(new
				// Book(myRs.getInt("id"),myRs.getString(2),myRs.getString(3),myRs.getString(4),myRs.getString("publisher"),myRs.getString("publishDate"),myRs.getString("status"),myRs.getInt("student_id")));
			}

			System.out
					.println("myNotegetrecordssttt specific student records \n"
							+ result);
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/**
	 * view details of a specific book by book id
	 *
	 * @param bookId
	 * @return detail of that specific book in string format
	 */
	public String getBook(Integer bookId) {
		String result = "";
		try {
			Db.DbBook dbBook = new Db("").new DbBook();
			ResultSet myRs = dbBook.getBook(bookId);
			while (myRs.next()) {
				result += "" + myRs.getInt("id") + ","
						+ myRs.getString("title") + ","
						+ myRs.getString("authorList") + ","
						+ myRs.getString("publisher") + ","
						+ myRs.getString("publishDate") + ","
						+ myRs.getString("status") + "##";
				// lstBook.add(new
				// Book(myRs.getInt("id"),myRs.getString(2),myRs.getString(3),myRs.getString(4),myRs.getString("publisher"),myRs.getString("publishDate"),myRs.getString("status"),myRs.getInt("student_id")));
			}

			System.out.println("myNotegetallbookunibbbb \n" + result);

			return result;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/**
	 * update book detail by bookid
	 *
	 * @param bookid
	 * @param title
	 * @param authorList
	 * @param isbn
	 * @param publishDate
	 * @param status
	 * @return String message if it is successfull
	 * @throws BookException
	 */
	public String updateBook(Integer bookid, String title, String authorList,
			String isbn, String publishDate, String publisher, String status)
			throws BookException {
		String result = "";
		try {
			DbBook dbbook = new Db().new DbBook();
			if (!dbbook.findBook(bookid))
				throw new BookException("there is no book with id=" + bookid
						+ " in our database");
			if (!Book.isStatusValid(status))
				throw new BookException(
						"status is not valid. it has to be either(available,on loan,back order)");
			if (!Book.isIsbnValid(isbn))
				throw new BookException("isbn has to be 13 or 10 digit number");

			dbbook.updateBook(bookid, title, authorList, isbn, publishDate,
					publisher, status);

			result = " Book id " + bookid + " been updated successfully";

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

	public boolean orderBookByBpel(Integer studentId, String bookinfo) {
		boolean result = false;
		try {

			String[] strArr = bookinfo.split("/#");

			System.out.println("myarray= " + strArr[0] + "," + strArr[1]);
			addBook(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4],
					"back order");
			DbBook dbbook = new Db().new DbBook();
			Integer bookid = dbbook.getLastIdinserted();
			insertStudentrecords(studentId, bookid, "back order");

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * function to add book with all details
	 *
	 * @param bookTitle
	 * @param authorList
	 * @param isbn
	 * @param publisher
	 * @param publishDate
	 * @param status
	 * @return string of successful or error message
	 * @throws BookException
	 */
	public String addBook(String bookTitle, String authorList, String isbn,
			String publisher, String publishDate, String status)
			throws BookException {
		try {
			DbBook dbbook = new Db().new DbBook();

			if (!Book.isIsbnValid(isbn))
				throw new BookException("isbn has to be 13 or 10 digit number");
			if (dbbook.isBookWithIsbnExist(isbn))
				throw new BookException(
						"this isbn already exists in our system");
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			// Date pd = df.parse(publishDate);

			// Book objb = new Book(bookTitle, authorList, isbn, publisher,
			// publishDate, status, 0);

			dbbook.insretBook2(bookTitle, authorList, isbn, publisher,
					publishDate, status);
			Integer id = dbbook.getLastIdinserted();
			// readAllBooksFromDb();
			String result = "Book has been added successfully. book Id is:"
					+ id;
			System.out.print(result);
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();

		}
	}

	/**
	 * easier way of adding book just for test other elements are default
	 *
	 * @param bookTitle
	 * @param isbn
	 * @return String that shows if book inserted successfully
	 * @throws BookException
	 */
	public String addBook2(String bookTitle, String isbn) throws BookException {

		try {
			DbBook dbbook = new Db().new DbBook();
			if (!Book.isIsbnValid(isbn))
				throw new BookException("isbn has to be 13 or 10 digit number");

			if (dbbook.isBookWithIsbnExist(isbn))
				throw new BookException(
						"this isbn already exists in our system");
			Book objb = new Book(bookTitle, "my author list", isbn,
					"publisher", "22/03/2016", "available", 0);

			dbbook.insretBook(objb);
			Integer id = dbbook.getLastIdinserted();
			// readAllBooksFromDb();
			String result = "Book has been added successfully. book Id is:"
					+ id;
			return result;
		} catch (Exception ex) {
			return ex.getMessage();
		}

	}

	/**
	 * delete the book with book id
	 *
	 * @param bookId
	 * @return if it is deleted shows bookid... deleted successfully
	 * @throws BookException
	 */
	public String deleteBook(Integer bookId) throws BookException {
		String result = "";
		try {
			DbBook dbbook = new Db().new DbBook();
			if (!dbbook.findBook(bookId))
				throw new BookException("there is no book with id=" + bookId
						+ " in our database");

			dbbook.deleteBook(bookId);

			result = " Book id " + bookId + " been deleted successfully";

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	/**
	 * action in database has to be borrow request or return (although if a
	 * student return the book we delete the that record)
	 *
	 * @param action
	 * @return
	 */
	private boolean isActionValid(String action) {
		boolean result = false;
		if (action.equals("on loan") || action.equals("back order")
				|| action.equals("available") || action.equals("delete"))
			result = true;
		return result;
	}

	/**
	 * update current student record search by studentid and bookid and change
	 * action(e.g to returned) it just change the action if it exist
	 *
	 * @param studentId
	 * @param bookId
	 * @param action
	 * @return if all good it shows action successfully in string format
	 * @throws BookException
	 */
	public String updateStudentrecords(Integer studentId, Integer bookId,
			String action) throws BookException {

		String result = "";

		try {
			DbBook dbbook = new Db().new DbBook();
			DbStudentBorrow dbStudent = new Db().new DbStudentBorrow();
			if (!dbbook.findBook(bookId))
				throw new BookException("there is no book with id=" + bookId
						+ " in our database");
			if (!isActionValid(action))
				throw new BookException(
						"action has to be (borrow,request or returned)");

			dbStudent.updateRecords(studentId, bookId, action);

			result = "student record has been updated successfully";

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	/**
	 * function to insert student borrow record. so they can update if they have
	 * existing record
	 *
	 * @param studentId
	 * @param bookId
	 * @param action
	 * @return if it insert successfully it return successfull message
	 * @throws BookException
	 */
	public String insertStudentrecords(Integer studentId, Integer bookId,
			String action) throws BookException {

		String result = "";

		try {
			DbBook dbbook = new Db().new DbBook();
			DbStudentBorrow dbStudent = new Db().new DbStudentBorrow();
			if (!dbbook.findBook(bookId))
				throw new BookException("there is no book with id=" + bookId
						+ " in our database");
			if (!isActionValid(action))
				throw new BookException(
						"action has to be (on loan,back order or available)");
			if (dbStudent.isRecordExist(studentId, bookId))
				throw new BookException(
						"already there is a record for student with this id="
								+ studentId + " and book id=" + bookId);

			dbStudent.insertRecords(studentId, bookId, action);

			result = "student record has been entered successfully";

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	/**
	 * delete student record if it exist for that specific studentId and bookId
	 *
	 * @param studentId
	 * @param bookId
	 * @return successfull message if delete student records successfully
	 */
	public String deleteStudentrecords(Integer studentId, Integer bookId) {
		String result = "";

		try {
			DbBook dbbook = new Db().new DbBook();
			DbStudentBorrow dbStudent = new Db().new DbStudentBorrow();
			if (!dbbook.findBook(bookId))
				throw new BookException("there is no book with id=" + bookId
						+ " in our database");

			dbStudent.deleteRecords(studentId, bookId);

			result = "student record has been deleted successfully";

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	/**
	 * function to setBookStatus in case that you gonna change status
	 *
	 * @param bookId
	 * @param bstatus
	 * @return return successfull if it set status for bookdb
	 * @throws BookException
	 */
	public String setBookStatus(String bookId, String bstatus)
			throws BookException {
		try {
			DbBook dbbook = new Db().new DbBook();

			if (!dbbook.findBook(Integer.parseInt(bookId)))
				throw new BookException("there is no book with id=" + bookId
						+ " in our database");
			if (!Book.isStatusValid(bstatus))
				throw new BookException(
						"status is not valid. it has to be either(available,on loan,back order)");

			Integer bid = Integer.parseInt(bookId);

			dbbook.setStatus(bid, bstatus);
			return " Book id " + bookId + " status has been updated to "
					+ bstatus;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
