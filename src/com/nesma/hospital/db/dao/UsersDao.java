
package com.nesma.hospital.db.dao;

import com.nesma.hospital.db.type.UserType;
import com.nesma.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * single tone class
 * create one object
 * inherit the connection with database from Dao class
 * user log in and do operations on database
 */
public class UsersDao extends Dao implements DaoList <UsersVo> {
    //declare object from UsersDao class
    private static UsersDao userdao;
    //allow to creat one object only
    public static UsersDao getInstance()
    {
        if(userdao==null)
            userdao=new UsersDao();
        return userdao;
    }
    //impement all methods of DaoList interface
    //override loadAll method 
    @Override
    public List<UsersVo> loadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int insert(UsersVo uv) throws Exception {
        int isInsert=0;
        Connection con = null;
        PreparedStatement ps;
        try{
            //open connection with DB
            con=getConnection();
            //sql statement
            String sql="INSERT INTO users(ID,USER_NAME,PASSWORD,USER_TYPE) VALUES(?,?,?,?)";
            //prepair sql statement and store the combiled statement in object
            ps=con.prepareStatement(sql);
            //set the inserted data
            ps.setInt(1, uv.getId());
            ps.setString(2,uv.getUsername());
            ps.setString(3, uv.getPassword());
            ps.setInt(4, uv.getUsertype().getId());
            //store inserted data in DB & return boolean value, stored or not
            isInsert=ps.executeUpdate();
            //close the perparedStatement
            ps.close();
            
        }
        catch(Exception ex)
        {
        }
        finally
        {
            //close the connection with DB
          closeConnection(con); 
        }
        return isInsert;
    }

    @Override
    public int update(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delet(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    /**
     * @param uv
     * @return
     * @throws Exception 
     * log in to the system
     * check that the entered username & password stored in DB
     */
    @Override
    public UsersVo getData(UsersVo uv) throws Exception {
        
        UsersVo uservo = null;
        Connection con=null;
        String sql;
        PreparedStatement ps;
        //contain set of data
        ResultSet result;
        try{
            //open connection
            con=getConnection();
            //write  sql statement
            sql="SELECT* FROM users WHERE USER_NAME='"+uv.getUsername()+"'AND PASSWORD='"+uv.getPassword()+"'";
            //prepare call and send sql statement to database"store the compiled query" 
            ps=con.prepareStatement(sql);
            //excute the sql query and return the selected data
            result=ps.executeQuery();
            
            /**
             * get user information from result "returned from DB" & set it in UserVo object
             */
            while(result.next())
            {
                //هسأل فيها يارا عبدالحكيم عامر
              uservo = new UsersVo();
              uservo.setId(result.getInt("id")); //ID is the column index in DB
              uservo.setUsername((result.getString("USER_NAME"))); 
              uservo.setPassword(result.getString("BASSWORD"));
              /**
               * static method
               * get the User_Type "number(user id in user type table in DB)" from result
               * get user type name by id from users_type table from DB
               */
              UserType usertype = UserType.getUserTypeById(result.getInt("USER_TYPE"));
              //usertype instance is an object of UerType class
              uservo.setUsertype(usertype);
            }
            result.close();
            ps.close();
            
        }
        catch(Exception ex)
        {
            
        }
        /**
         * close the connection with DB
         */
        finally
        {
            closeConnection(con);
        }
        return uservo;
        
    }
    
}
