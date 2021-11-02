package Application;

import model.dao.SellerDao;
import model.entities.Seller;
import model.dao.DaoFactory;
public class App {
    public static void main(String[] args) throws Exception {
       
        SellerDao sellerdao = DaoFactory.createSellerDao();
        
    
        Seller seller = sellerdao.findbyId(3);

        System.out.println(seller);
    
    }
}
