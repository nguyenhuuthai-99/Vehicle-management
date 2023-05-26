/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass2_retriever;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author thainguyen
 */
@Entity
@Table(name = "Customer")
@NamedQueries({
    @NamedQuery(name = "findAllCustomers", query = "SELECT c from Customer c"),
    @NamedQuery(name = "findCustomer", query = "SELECT c FROM Customer c WHERE c.name = :customerName")
})

public class Customer implements Serializable {

    //attributes
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;
    private String name;
    private String phone;
    private List<Allocation> allocations;

    //construction
    public Customer() {
    }

    //construction
    public Customer(String name, String phone, List<Allocation> allocations) {
        this.name = name;
        this.phone = phone;
        this.allocations = allocations;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    
}
