/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass2_retriever;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author thainguyen
 */
@Entity
@Table(name = "Truck")
@NamedQuery(name = "findAllTrucks", query = "SELECT t from Truck t")
public class Truck extends Vehicle{

    //attribute
    private double capacity;

    //construction
    public Truck() {
        
    }

    //construction
    public Truck(double capacity, String make, String model, int mileage, String description, String plateNumber, boolean isRented, Allocation allocation) {
        super(make, model, mileage, description, plateNumber, isRented, allocation);
        this.capacity = capacity;
    }


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    
    
    
}
