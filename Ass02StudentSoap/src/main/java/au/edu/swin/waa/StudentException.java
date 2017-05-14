/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.swin.waa;

/** specific exception for all issue happening inside retrive or wroking with student DB
 * with some common overwritten functions
 *
 * @author XC8184
 */
public class StudentException extends Exception {
        public StudentException(String mess) { super(mess); }
  public StudentException(String message, Throwable cause) { super(message, cause); }
  public StudentException(Throwable cause) { super(cause); }
    
}
