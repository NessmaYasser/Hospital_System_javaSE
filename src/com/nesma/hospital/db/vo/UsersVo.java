
package com.nesma.hospital.db.vo;

import com.nesma.hospital.db.type.UserType;

/**
 *
 * log in to the system
 * users table in database
 */
public class UsersVo {
    //user id
   private int id;
   //user name
   private String username;
   //user password
   private String password;
   /**
    * user type
    * object from UserType class
    * foreign key in the users_type table in database
    */
   private UserType usertype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public UsersVo() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }
   
}
