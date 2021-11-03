package Application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {

        SellerDao sellerdao = DaoFactory.createSellerDao();

        

        Department dep = new Department(1, null);

        List<Seller> seller = sellerdao.findByDepartment(dep);
        


        seller.forEach(System.out::println);

    }
}
