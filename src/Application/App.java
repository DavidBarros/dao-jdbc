package Application;

import model.entities.Department;

public class App {
    public static void main(String[] args) throws Exception {
       
        Department obj = new Department(1, "Book");
        System.out.println(obj);
    }
}
