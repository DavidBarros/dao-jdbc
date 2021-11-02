package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    Connection conn = DB.getConnection();

    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Seller findbyId(Integer id) {
        
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT seller.*, department.Name as DepName " + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?";

            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

                Department dep = instantiateDeparment(rs);
               
                Seller obj = instantiateSeller(rs, dep);
               

                return obj;

            } else {
                return null;
            }

        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

  
        

    @Override
    public List<Seller> findAll() {
        
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT seller.*, department.Name as DepName " + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id ";

            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            List<Seller> list = new ArrayList<>();

            if (rs.next()) {
                
                do {
                
                    Department dep = instantiateDeparment(rs);
                    
                    Seller obj = instantiateSeller(rs, dep);
                    
                    list.add(obj);

                } while (rs.next());

                return list;

            } else {
                return null;
            }

        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDeparment(ResultSet rs) throws SQLException{
        
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        
        return dep;
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException{

        Seller obj = new Seller();
        obj.setId(rs.getInt("seller.Id"));
        obj.setName(rs.getString("seller.Name"));
        obj.setEmail(rs.getString("seller.Email"));
        obj.setBirthDate(rs.getDate("seller.BirthDate"));
        obj.setBaseSalary(rs.getDouble("seller.BaseSalary"));
        obj.setDepartment(dep);
        
        return obj;
    }

}   