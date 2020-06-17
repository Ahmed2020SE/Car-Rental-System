/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RenalSystem;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RentalSystemMaker {
    private Rules car;
    private Rules customer;
    private Rules rental;
    private Rules returncar;
    public RentalSystemMaker() {
        car =new Car();
        customer = new Customer();
        rental= new Rental();
        returncar = new Return();
    }
    public int addCar(ArrayList<String> inputs){
        return car.add(inputs);
    }
    public int updateCar(ArrayList<String> inputs){
        return car.update(inputs);
    }
    public int deleteCar(String id){
        return car.delete(id);
    }
    public int addCustomer(ArrayList<String> inputs){
        return customer.add(inputs);
    }
    public int updateCustomer(ArrayList<String> inputs){
        return customer.update(inputs);
    }
    public int addRental(ArrayList<String> inputs){
        return rental.add(inputs);
    }
    public int updateRental(ArrayList<String> inputs){
        return rental.update(inputs);
    }
    public int addReturn(ArrayList<String> inputs){
        return returncar.add(inputs);
    }
}
