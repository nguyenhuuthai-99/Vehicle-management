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
@Table(name = "Vehicle")
@NamedQuery(name = "findVehicle", query = "SELECT v FROM Vehicle v WHERE v.id = :vehicleId")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle implements Serializable {

    //attributes
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Long id;
    private String make;
    private String model;
    private int mileage;
    private String description;
    private String plateNumber;
    private boolean isRented;
    private Allocation allocation;

    //construction
    public Vehicle(String make, String model, int mileage, String description, String plateNumber, boolean isRented, Allocation allocation) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.description = description;
        this.plateNumber = plateNumber;
        this.isRented = isRented;
        this.allocation = allocation;
    }


    //construction
    public Vehicle() {
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }
    
    

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }
    
    

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
