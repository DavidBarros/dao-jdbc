package Application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {

        SellerDao sellerdao = DaoFactory.createSellerDao();

        List<Seller> seller = sellerdao.findAll();

        seller.forEach(System.out::println);

    }
}
