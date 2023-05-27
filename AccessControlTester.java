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
 * This class tests for the methods used in AccessControl.java to check that all methods run
 * successfully and complete each task required. The methods will be tested and will return true if
 * all tests have successfully passed when run in the runAllTests() method.
 * 
 * @author Harshet Anand
 */


public class AccessControlTester {

  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
    AccessControl aControl = new AccessControl();
    aControl.addUser("Jackie", true);
    aControl.addUser("Jeremy", true);
    aControl.setCurrentUser("Jackie");
    aControl.resetPassword("Jeremy");
  }


  /**
   * Checks the correctness of all test methods works successfully by running all tests.
   * 
   * @return true if all test methods pass else false if one or more tests fail printing out the
   *         test and the method which did not pass
   */
  public static boolean runAllTests() {
    boolean allTestsPassed =
        testUserConstructorAndMethods() && testAccessControlIsValidLoginNotValidUser()
            && testAddUserWithNoAdminPowers() && testAddRemoveUserWithAdminPowers();
    // Can only return true if all test cases return true. Will go back to main method to return
    // final result
    return allTestsPassed;
  }


  /**
   * Checks the correctness of the constructors and methods in the User.java class.
   * 
   * @return true if all scenarios pass else false if atleast one scenario has failed with error
   *         specified
   */
  public static boolean testUserConstructorAndMethods() {
    User users = new User("Jackie", "Jeremy", false);
    if (!(users.getUsername() == "Jackie")) {
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of AccessControl.isValidLogin() method when called with incorrect
   * username or not matching (username, password) pair.
   * 
   * @return true if the scenario has passed and the isValidLogin() is correct else false if the
   *         method is incorrect which means incorrect pair still results in valid login
   */
  public static boolean testAccessControlIsValidLoginNotValidUser() {
    AccessControl aControl = new AccessControl();
    if (AccessControl.isValidLogin("Johnny", "Jacob") == false) {
      return true;
    }
    return false;
  }


  /**
   * Creates a new AccessControl object and does not log in an admin. This test must fail if
   * addUser(String username) does not return false or if a user was added to the list of user after
   * the method returns.
   * 
   * @return true if addUser() method is correct with no admin powers else false if method fails to
   *         return correct output with specified scenario
   */
  public static boolean testAddUserWithNoAdminPowers() {
    AccessControl aControl = new AccessControl();
    if (aControl.addUser("Johnny") == true) {
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of addUser and removeUser methods when the current user has admin
   * powers.
   * 
   * @return true if the addUser() and removeUser() methods work correctly whilst current user has
   *         admin else false if either of the methods fail to result in correct output
   */
  public static boolean testAddRemoveUserWithAdminPowers() {
    AccessControl aControl = new AccessControl();
    if ((!(aControl.addUser("Johnny") == true)) && (!(aControl.removeUser("Jacob") == true))) {
      return true;
    }
    return false;
  }
}
