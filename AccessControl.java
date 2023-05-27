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
 * This class allows us to implement constructors, exception handlings, and arraylists to program a
 * simple access control system. An access control system maintains a record of valid users and
 * their properties. In order to gain access to the machine, a user must accurately report their
 * matching name and password.
 * 
 * @author Harshet Anand
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AccessControl {

  private static ArrayList<User> users;
  private User currentUser;
  private static final String DEFAULT_PASSWORD = "changeme";


  /**
   * This is the main method.
   * 
   * @param args String
   */
  public static void main(String[] args) {
  }


  /**
   * This is a no-argument constructor and this creates a new arraylist containing a single user
   * with the username as admin and the password as root with the isAdmin being set to true.
   */
  public AccessControl() {
    if (users == null) {
      users = new ArrayList<User>();
      users.add(new User("admin", "root", true));
    }
    currentUser = null;
  }


  /**
   * This method reports whether a given username/password pair is a valid login where if it is not
   * a valid login meaning the password and username is incorrect, this will not be valid.
   * 
   * @param username password will be checked again username that has been inputted in order for
   *                 pair to return true
   * @param password compared with username inputted to see if it is a valid pair and valid login
   * @return true if password is correct with username else false if does not match
   */
  public static boolean isValidLogin(String username, String password) {
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)
          && users.get(j).isValidLogin(password) == true) {
        return true;
      }
    }
    return false;
  }


  /**
   * This method changes the password of the current user.
   * 
   * @param newPassword the new password that is being set to replace the old password of the
   *                    current user
   */
  public void changePassword(String newPassword) {
    currentUser.setPassword(newPassword);
  }


  /**
   * This method logs out the current user.
   */
  public void logout() {
    currentUser = null;
  }


  /**
   * A mutator that you can use to write tests without simulating user input. It sets the current
   * user to the user from the users list whose username matches the string provided as input to the
   * method (exact match case sensitive).
   * 
   * @param username sets current user to the user from the string provided as input for username
   *                 and is case sensitive
   */
  public void setCurrentUser(String username) {
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        currentUser = users.get(j);
      }
    }
  }


  /**
   * This method creates a new user with the default password and isAdmin==false and adds it to the
   * users ArrayList.
   * 
   * @param username used to check if it is acceptable to be used as a username and is added to
   *                 arraylist if it is acceptable
   * @return true if the current user has Admin power and the new user was successfully added else
   *         false if the current user is null or does not have admin power
   * @throws IllegalArgumentException with a descriptive error message if username is null or if its
   *                                  length is less than 5 ( < 5), or if a user with the same
   *                                  username is already in the list of users (usernames must be
   *                                  unique).
   */
  public boolean addUser(String username) throws IllegalArgumentException {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    if (username.length() < 5 || username.equals(null)) {
      throw new IllegalArgumentException("Error! Username is not long enough.");
    }
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        throw new IllegalArgumentException("Error! Username is already taken.");
      }
    }
    currentUser = new User(username, DEFAULT_PASSWORD, false);
    users.add(currentUser);
    if (currentUser.getIsAdmin() == true) {
      return true;
    }
    return false;
  }


  /**
   * This method creates a new user, specifies their admin status, and add it to the list of users.
   * 
   * @param username used to check if it is acceptable to be used as a username and is added to
   *                 arraylist if it is acceptable
   * @param isAdmin  specifies the admin status
   * @return true if the current user has Admin power and the new user was successfully added else
   *         false if the the current user is null or does not have Admin power
   * @throws IllegalArgumentException with a descriptive error message if username is null or if its
   *                                  length is less than 5 ( < 5), or if a user with the same
   *                                  username is already in the list of users
   */
  public boolean addUser(String username, boolean isAdmin) throws IllegalArgumentException {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    if (username.length() < 5 || username.equals(null)) {
      throw new IllegalArgumentException("Error! Username is not long enough.");
    }
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        throw new IllegalArgumentException("Error! Username is already taken.");
      }
    }
    currentUser = new User(username, DEFAULT_PASSWORD, isAdmin);
    users.add(currentUser);
    if (currentUser.getIsAdmin() == true) {
      return true;
    }
    return false;
  }


  /**
   * This method removes a user given their unique username.
   * 
   * @param username used to check if username is in the arraylist for the user to be removed
   * @return true if the current user has Admin powers and the user whose username is passed as
   *         input was successfully removed else false if the the current user is null or does not
   *         have Admin power
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean removeUser(String username) throws NoSuchElementException {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        users.remove(j);
        return true;
      }
    }
    throw new NoSuchElementException("Error! This username does not exist.");
  }


  /**
   * This method gives a user admin power.
   * 
   * @param username used to provided specified user inputted with admin power
   * @return true if this operation terminates successfully else false if the current user is null
   *         or does not have admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean giveAdmin(String username) throws NoSuchElementException {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        users.get(j).setIsAdmin(true);
        return true;
      }
    }
    throw new NoSuchElementException("Error! This username does not exist.");
  }


  /**
   * This method removes the admin power of a user given their username.
   * 
   * @param username provided so that admin power can be removed from that specified username
   * @return true if this operation terminates successfully else false if the current user is null
   *         or does not have admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean takeAdmin(String username) throws NoSuchElementException {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        users.get(j).setIsAdmin(false);
        return true;
      }
    }
    throw new NoSuchElementException("Error! This username does not exist.");
  }


  /**
   * This method resets the password of a user given their username.
   * 
   * @param username provided so that the password can be reset for that specified username
   * @return true if this operation terminates successfully else false if the current user is null
   *         or does not have admin powers
   * @throws NoSuchElementException with a descriptive error message if no match with username is
   *                                found in the list of users
   */
  public boolean resetPassword(String username) throws NoSuchElementException {
    if (currentUser == null || currentUser.getIsAdmin() == false) {
      return false;
    }
    for (int j = 0; j < users.size(); j++) {
      if (users.get(j).getUsername().equals(username)) {
        users.get(j).setPassword(DEFAULT_PASSWORD);
        return true;
      }
    }
    throw new NoSuchElementException("Error! This username does not exist.");
  }
}
