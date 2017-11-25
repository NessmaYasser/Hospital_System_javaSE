
package com.nesma.hospital.db.dao;

import com.nesma.hospital.db.vo.UserDetailsVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;



public class UserDetailsDao extends Dao implements DaoList <UserDetailsVo> {
    
    private static UserDetailsDao userdetailsdao;
    public static UserDetailsDao getInstance()
    {
        if(userdetailsdao==null)
            userdetailsdao=new UserDetailsDao();
        return userdetailsdao;
    }
    

    @Override
    public List loadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps;
        int isInsert = 0;
        try
        {
            con=getConnection();
            String sql="INSERT INTO users_details( User_ID, FIRST_NAME,FATHER_NAME, MOBILE) VALUES(?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setInt(1, udv.getUserid().getId());
            ps.setString(2, udv.getFirstname());
            ps.setString(3, udv.getFathername());
            ps.setString(4, udv.getMobile());
            isInsert=ps.executeUpdate();
            ps.close();
            
        }
        catch(Exception ex)
        {   
        }
        finally
        {
         closeConnection(con);   
        }
        return isInsert;
    }

    @Override
    public int update(UserDetailsVo udv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delet(UserDetailsVo udv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetailsVo getData(UserDetailsVo udv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
