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
@Table(name = "Car")
@NamedQuery(name = "findAllCars", query = "SELECT c from Car c")
public class Car extends Vehicle{

    //attributes
    private int numberOfSeats;

    //construction
    public Car() {
    }

    //construction
    public Car(int numberOfSeats, String make, String model, int mileage, String description, String plateNumber, boolean isRented, Allocation allocation) {
        super(make, model, mileage, description, plateNumber, isRented, allocation);
        this.numberOfSeats = numberOfSeats;
    }

    

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
}
