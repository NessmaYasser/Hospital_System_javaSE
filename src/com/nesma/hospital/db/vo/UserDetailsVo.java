
package com.nesma.hospital.db.vo;


public class UserDetailsVo {
    private int id;
    //foreign key from users table "UsersVo class"
    private UsersVo userid;
    private String firstname;
    private String fathername;
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsersVo getUserid() {
        return userid;
    }

    public void setUserid(UsersVo userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
    
}
