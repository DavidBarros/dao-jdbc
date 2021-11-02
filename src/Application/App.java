package Application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
       
        Department obj = new Department(1, "Book");
        
    
        Seller seller = new Seller(21, "Luzia","luzia@gmail.com" , new Date(), 3200.00, obj);

        System.out.println(seller);
    
    }
}
