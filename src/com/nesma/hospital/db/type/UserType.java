
package com.nesma.hospital.db.type;

/**
 *
 * types of users and their id
 * users_type table in database
 */
public enum UserType {
    //people who use the system
    ADMIN(1,"admin"), DOCTOR(2,"doctor"), Nurse(3,"nurse");
    
    //user id
    private int id;
    //user type
    private String type;
    
    //construct user id and type 
    private UserType(int _id, String _type){
        this.id= _id;
        this.type= _type;
    }   
    //get id value
    public int getId() {
        return id;
    }
    //set id value
    public void setId(int _id) {
        this.id = _id;
    }
    //get user type value
    public String getType() {
        return type;
    }
    //set user type value
    public void setType(String _type) {
        this.type = _type;
    }
    //get user by id
     public static UserType getUserTypeByType(String type)
    {
        for(UserType userOfTheType:UserType.values())
        {
            if(userOfTheType.getType().equals(type))
                return userOfTheType;
        }
        return null;
    }
     
      public static UserType getUserTypeById(int id)
    {
        for(UserType userOfTheId:UserType.values())
        {
            if(userOfTheId.getId()==id)
                return userOfTheId;
        }
        return null;
    }
    
    
    
}
