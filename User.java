//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Access Control
// Course: CS 300 Spring 2022
//
// Author: Harshet Anand
// Email: hanand2@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////


/**
 * This class creater includes multiple constructors and sets a username, password, and
 * administrator and checks if it is a valid login with correct password input and checks if the
 * user is an admin.
 * 
 * @author Harshet Anand
 */

public class User {
  private final String USERNAME;
  private String password;
  private boolean isAdmin;


  /**
   * This method creates a new user with the given username, password, and admin status.
   * 
   * @param username The username that will be created along with the new user being added
   * @param password The password that will be assigned to the specified user just created
   * @param isAdmin  Checks if the user is an admin or not
   */
  public User(String username, String password, boolean isAdmin) {
    this.USERNAME = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }


  /**
   * This method reports whether the password is correct or not
   * 
   * @param password compared with actual password that is assigned with the username inputted
   * @return true if password is correct else false if password is incorrect
   */
  public boolean isValidLogin(String password) {
    if (this.password == password) {
      return true;
    }
    return false;
  }


  /**
   * This method returns the name of the user
   * 
   * @return the name of the user
   */
  public String getUsername() {
    return USERNAME;
  }


  /**
   * This method reports whether the user is an admin or not
   * 
   * @return whether the user is an admin or not
   */
  public boolean getIsAdmin() {
    return isAdmin;
  }


  /**
   * This method sets the new password
   * 
   * @param password sets a new password for the specified username
   */
  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * This method sets the new admin status
   * 
   * @param isAdmin the new admin status of the user
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
}
