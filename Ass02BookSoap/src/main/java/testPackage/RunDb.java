package testPackage;

import java.sql.ResultSet;

import au.edu.swin.waa.Ass02BookSoap;
import au.edu.swin.waa.Book;
import au.edu.swin.waa.Db;
import au.edu.swin.waa.Db.DbStudentBorrow;

public class RunDb {

	public static void main(String[] args) {// ToDO
		try {
			// testReadBook();
			// testReadStudent();
			// testinsertBook();
			// testgetLastid();
			// testdeleteBook();
			// testUniLibgetAllBook();
			// testUniLibgetStudentRecord();
			// testUniLibgetStudentRecord2();
			// testUniLibgetspecificBook();
			// testUniLibupdateBook("my title", "0000000012");
			testIsbnExist();

			// testUniLibaddBook("tet", "1234444446");
			// testInsertIntoborrow();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testIsbnExist() {
		Ass02BookSoap ubook = new Ass02BookSoap();
		if (ubook.isIsbnExist("1234567987798")) {
			System.out.println("yyyyyyisbn exist");
		} else {
			System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		}

	}

	public static void testInsertIntoborrow() {
		try {
			DbStudentBorrow dbbrw = new Db().new DbStudentBorrow();
			dbbrw.insertRecords(2, 2, "borrow");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testUniLibaddBook(String title, String isbn) {
		try {
			Ass02BookSoap ubook = new Ass02BookSoap();
			ubook.addBook(title, "authortest", isbn, "testPublisher",
					"22/08/1980", "available");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testUniLibupdateBook(String title, String isbn) {
		try {
			Ass02BookSoap ubook = new Ass02BookSoap();
			ubook.updateBook(1, title, "", isbn, "nothin", "publisher",
					"on loan");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testUniLibgetspecificBook() {
		Ass02BookSoap ubook = new Ass02BookSoap();
		ubook.getBook(2);

	}

	public static void testUniLibgetStudentRecord2() {
		Ass02BookSoap ubook = new Ass02BookSoap();
		ubook.getRecordsStudent2(1);

	}

	public static void testUniLibgetStudentRecord() {
		Ass02BookSoap ubook = new Ass02BookSoap();
		ubook.getRecordsStudent(1);

	}

	public static void testUniLibgetAllBook() {
		Ass02BookSoap ubook = new Ass02BookSoap();
		ubook.getAllBook();

	}

	public static void testgetLastid() {
		try {

			Db.DbBook dbBook = new Db("").new DbBook();
			Integer bookid = dbBook.getLastIdinserted();

			System.out.println(bookid);

		} catch (Exception e) {
			System.out.println("11122");
			e.printStackTrace();
		}

	}

	public static void testdeleteBook() {
		try {
			System.out.println("##### delete last element#####");
			Db.DbBook dbBook = new Db("").new DbBook();

			Integer bookid = dbBook.getLastIdinserted();
			dbBook.deleteBook(bookid);

		} catch (Exception e) {
			System.out.println("11122");
			e.printStackTrace();
		}

	}

	public static void testinsertBook() {
		try {
			System.out.println("##### insert book#####");
			Db.DbBook dbBook = new Db("").new DbBook();
			Book objBook = new Book("title", "author list", "1234567892",
					"mypublisher", "22/09/2008", "available", 1);

			dbBook.insretBook(objBook);

		} catch (Exception e) {
			System.out.println("11122");
			e.printStackTrace();
		}

	}

	public static void testReadBook() {
		try {
			System.out.println("##### list of all book#####");
			Db.DbBook dbBook = new Db("").new DbBook();
			ResultSet myRs = dbBook.getAllBooks();

			while (myRs.next()) {
				System.out.println("book name:" + myRs.getString("title")
						+ " isbn:" + myRs.getString("isbn"));
			}
		} catch (Exception e) {
			System.out.println("11122");
		}

	}

}
