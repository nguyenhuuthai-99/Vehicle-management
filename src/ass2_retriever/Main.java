/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ass2_retriever;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

/**
 *
 * @author thainguyen
 */
public class Main {

    private static final String LINE = "=============================================";
    
    //Entity Manager Factory, Entity Manager and Transaction
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;
    
    public static void main(String[] args) {
        
        // asign Entity Manager Factory, Entity Manager and Transaction
        emf = Persistence.createEntityManagerFactory("ass2_retrieverPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
        //execute the main function of the program
        functions();
        
    }
    
    private static void functions(){
       
        int userSelection = 0;

        boolean programRunning = true;

        //program will not stop until programRunning variable is false
        while (programRunning) {

            try {
                //declare a scanner
                Scanner input = new Scanner(System.in);

                System.out.println(LINE);

                System.out.println("Welcome to vehicle rental company data retrieval");

                System.out.println("Search customer by name.............1");
                System.out.println("Search vehicle by ID................2");
                System.out.println("Exit................................3");

                System.out.println(LINE);

                //get user selection
                System.out.println("Select your option:");
                userSelection = input.nextInt();

                
                switch (userSelection) {
                    case 1:
                        //option 1
                        customerSearch();
                        break;
                    case 2:
                        //option 2
                        vehicleSearch();
                        break;
                    case 3:
                        //option 3
                        programRunning = false;
                        break;
                    default:
                        //else
                        System.out.println("Error!!!: Invalid input");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error!!!: Invalid input");

            }

        }       
    }
    
    private static void customerSearch(){
        //declare a scanner
        Scanner input = new Scanner(System.in);
        System.out.println("\nCustomer Search");
        System.out.println(LINE);
        System.out.println("Return to the Main Menu............99");
        System.out.println(LINE);
        System.out.println("Customer name:");
        //get user input
        String userInput = input.nextLine();
        if ("99".equals(userInput)) {
            //return to menu
        } else {
            
            try{
            
            //begin transaction
            tx.begin();
            
            //query to get customer data from database with customer name
            TypedQuery<Customer> query = em.createNamedQuery("findCustomer", Customer.class);
            query.setParameter("customerName", userInput);
            
            //result
            Customer customer = query.getSingleResult();
            
            //transaction commit
            tx.commit();
            
            
            //print out result
            System.out.println("Customer Name: "+ customer.getName());
            System.out.println("Phone: "+ customer.getPhone());
            List<Allocation> allocations = customer.getAllocations();
            //print out customer's allocations
            for(int i = 0; i<allocations.size(); i++){
                System.out.println();
                Allocation allocation = allocations.get(i);
                System.out.println("Allocated Vehicle ID: "+ allocation.getVehicle().getId());
                System.out.println("Vehicle Model: "+ allocation.getVehicle().getModel()
                +" "+allocation.getVehicle().getMake());
                
            }
            System.out.println();
            }catch(NoResultException e){
                tx.commit();
                System.out.println("Error!!! Invalid Customer's name. Please try again\n");
            }
        }        
    }
    
    private static void vehicleSearch(){
        //declare a scanner
        Scanner input = new Scanner(System.in);
        System.out.println("\nVehicle Search");
        System.out.println(LINE);
        System.out.println("Return to the Main Menu.......99");
        System.out.println(LINE);
        System.out.println("Vehicle ID:");
        //get user input
        String userInput = input.nextLine();
        if ("99".equals(userInput)) {
            //return to main menu
        } else {
            
            try{
            //transaction begin
            tx.begin();
            
            //query to get vehicle from database with vehicle id
            TypedQuery<Vehicle> query = em.createNamedQuery("findVehicle", Vehicle.class);
            query.setParameter("vehicleId", Long.parseLong(userInput));
            
            //result
            Vehicle vehicle = query.getSingleResult();
            
            //transaction commit
            tx.commit();
            
            //print out result
            System.out.println("Vehicle ID: "+ vehicle.getId());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Description: " + vehicle.getDescription());
            System.out.println("Plate Number: " + vehicle.getPlateNumber());
            System.out.println("Mileage: " + vehicle.getMileage());
            System.out.println("IsRented: " + vehicle.isIsRented());
            System.out.println();
            }catch(NoResultException e){
                tx.commit();
                System.out.println("Error!!! Invalid Vehicle ID. Please try again\n");
            }
        }        
    }
    
}
