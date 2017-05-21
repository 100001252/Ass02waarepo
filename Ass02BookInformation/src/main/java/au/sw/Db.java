package au.sw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 * class DB to connect to db for book database and student record database
 *
 * @author XC8184
 *
 */
public class Db {

	// private static String url="jdbc:mysql://localhost::3306/oztutor123";
	private String url;
	private String user;
	private String pass;
	private Connection myConn;
	private Statement myStmt;
	private ResultSet myRs;
	private String dbName;

	/**
	 * constructor to connect to db
	 *
	 * @param dbName
	 *            database name
	 */
	public Db(String dbName) {
		try {
			if (dbName.equals(""))
				dbName = "waa";
			this.url = "jdbc:mysql://localhost:3306/" + dbName;
			this.user = "admin2";
			this.pass = "admin2";
			myConn = DriverManager
					.getConnection(this.url, this.user, this.pass);
		} catch (Exception e) {
			System.out.println("erro" + e.getMessage());
		}
	}

	/**
	 * constructor to connect to db
	 *
	 *
	 */
	public Db() {
		try {

			dbName = "waa";
			this.url = "jdbc:mysql://localhost:3306/" + dbName;
			this.user = "root";
			this.pass = "";
			myConn = DriverManager
					.getConnection(this.url, this.user, this.pass);
		} catch (Exception e) {
			System.out.println("erro" + e.getMessage());
		}
	}

	public class DbBookInformation {
		private String tableName = "bookshop";

		public DbBookInformation() {
		}

		/**
		 * check if isbn exist in bookshop
		 *
		 * @param isbn
		 * @return
		 * @throws BookException
		 */
		public boolean isIsbnExist(String isbn) throws BookException {
			boolean result = false;
			try {
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("select count(*) from " + tableName
						+ " where isbn like '%" + isbn + "%' ");

				while (myRs.next()) {
					if (myRs.getInt(1) > 0)
						result = true;
					else
						result = false;
				}

				return result;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" bookinfodbbbbb database there is issue with our database query="
								+ "select count(*) from " + tableName
								+ " where isbn=" + isbn);

			}

		}

		public boolean isRatingInRange(String isbn) throws BookException {
			boolean result = false;
			String query = "";
			try {
				myStmt = myConn.createStatement();
				query = "select * from " + tableName + " where isbn like'%"
						+ isbn + "%' ";
				ResultSet myRs1 = myStmt.executeQuery(query);
				// System.out.println(myRs1.getInt("rating"));
				String result2 = "";
				Integer rating = null;
				while (myRs1.next()) {
					result2 += " result" + myRs1.getInt("rating");
					rating = myRs1.getInt("rating");

				}
				System.out.println(rating);
				if (rating > 2) {
					result = true;
				}

				return result;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" bookinfodbbbbb database there is issue with our database query="
								+ query);

			}

		}

		public boolean isAvailableInAustralia(String isbn) throws BookException {
			boolean result = false;
			String query = "";
			try {
				myStmt = myConn.createStatement();
				query = "select * from " + tableName + " where isbn like'%"
						+ isbn + "%' ";
				ResultSet myRs1 = myStmt.executeQuery(query);
				// System.out.println(myRs1.getInt("rating"));
				String result2 = "";
				Integer available = null;
				while (myRs1.next()) {
					result2 += " result" + myRs1.getInt("availabilityaus");
					available = myRs1.getInt("availabilityaus");

				}
				System.out.println(available);
				if (available == 1) {
					result = true;
				}

				return result;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" bookinfodbbbbb database there is issue with our database query="
								+ query);

			}

		}
	}

	public class DbStudentBorrow {
		private String tableName = "student_borrow";

		/**
		 * constructor for student records table
		 */
		public DbStudentBorrow() {

		}

		/**
		 * function to check if a record for specific student_id and book_id
		 * exist(we should not have more than one book_id in db records)
		 *
		 * @param studentId
		 * @param bookId
		 * @return if it exist it return true
		 * @throws BookException
		 */
		public boolean isRecordExist(Integer studentId, Integer bookId)
				throws BookException {
			boolean result = false;
			try {
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("select count(*) from " + tableName
						+ " where book_id=" + bookId + " and student_id="
						+ studentId);
				while (myRs.next()) {
					if (myRs.getInt(1) > 0)
						result = true;
					else
						result = false;
				}

				return result;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" StudentBorrow database there is issue with our database");

			}
		}

		/**
		 * function to retrive records of specific student with student id
		 *
		 * @param studentId
		 * @return it return resultset of that row
		 * @throws Exception
		 */
		public ResultSet getRecordsOfStudent(Integer studentId)
				throws Exception {
			try {
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("select * from " + tableName
						+ " where student_id=" + studentId);
				return myRs;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" book database there is issue with our database");

			}
		}

		/**
		 * it return records of specific student in detail of book
		 *
		 * @param studentId
		 * @return resultset record row
		 * @throws Exception
		 */
		public ResultSet getRecordsOfStudent2(Integer studentId)
				throws Exception {
			try {
				myStmt = myConn.createStatement();
				myRs = myStmt
						.executeQuery("select * from "
								+ tableName
								+ " br inner join waa.books bk on bk.id=br.book_id  where student_id="
								+ studentId);
				return myRs;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" book database there is issue with our database");

			}
		}

		/**
		 * this function return records of all student in db
		 *
		 * @return resultset of all records in db borrowrecords
		 * @throws Exception
		 */
		public ResultSet getAllStudentRecords() throws Exception {
			try {
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery("select * from " + tableName);
				return myRs;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						" book database there is issue with our database");

			}
		}

		/**
		 * function that update records of borrow for student_id and book_id
		 * (change action)
		 *
		 * @param studentId
		 * @param bookId
		 * @param action
		 * @return
		 * @throws Exception
		 */
		public boolean updateRecords(Integer studentId, Integer bookId,
				String action) throws Exception {
			boolean result = false;
			try {

				myStmt = myConn.createStatement();
				String sql = "update " + tableName + " set action='" + action
						+ "' where student_id=" + studentId + " book_id="
						+ bookId + " ";
				System.out.println(sql);
				myStmt.executeUpdate(sql);

				result = true;

				return result;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						"4044-updateStudent- database there is issue with our database");

			}

		}

		/**
		 * function to insert borrow record for student_id and book_id
		 *
		 * @param studentId
		 * @param bookId
		 * @param action
		 * @return if action is successfull return true otherwise return false
		 * @throws Exception
		 */
		public boolean insertRecords(Integer studentId, Integer bookId,
				String action) throws Exception {
			boolean result = false;
			try {

				myStmt = myConn.createStatement();
				String sql = "insert into " + tableName
						+ "(student_id,book_id," + "action,createdTime)"
						+ " values(" + studentId + "," + bookId + ",'" + action
						+ "',now())";
				System.out.println(sql);
				myStmt.executeUpdate(sql);

				result = true;

				return result;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw new BookException(
						"4045-insertStudentrecords- database there is issue with our database");

			}

		}

		/**
		 * delete records for student_borrrowing tabale
		 *
		 * @param studentId
		 * @param bookId
		 * @param action
		 * @return if action is successfull return true otherwise return false
		 * @throws Exception
		 */
		public boolean deleteRecords(Integer studentId, Integer bookId)
				throws Exception {
			boolean result = false;
			try {

				myStmt = myConn.createStatement();
				String sql = "delete from " + tableName + " where student_id="
						+ studentId + " and book_id=" + bookId;
				System.out.println(sql);
				myStmt.executeUpdate(sql);

				result = true;

				return result;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new BookException(
						"4049-deleteStudentrecords- database there is issue with our database");

			}

		}

	}

}
