package com.example.SpringMongoCRUD.controller;

import com.example.SpringMongoCRUD.model.Customer;
import com.example.SpringMongoCRUD.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRespository customerRepo;

    @RequestMapping(method= RequestMethod.POST,value="/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer)
    {

        try{
            customerRepo.save(customer);
            return new ResponseEntity("Successfully added customer "+customer.getFirst_name()+" "+customer.getLast_name(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method=RequestMethod.GET,value="/customer")
    public ResponseEntity getAllCustomers()
    {
        List<Customer> customers=customerRepo.findAll();
        if(customers.size()>0)
        {
            return new ResponseEntity(customers,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("No customers found",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/customer/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable("id") String id) {

        try{
            customerRepo.deleteById(id);
            return new ResponseEntity("Succesfully deleteted customer with id"+id, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method=RequestMethod.PUT,value="/customer/{id}")
    public ResponseEntity updateById(@PathVariable("id") String id,@RequestBody Customer newCustomer)
    {
        Optional<Customer> movieOptional =customerRepo.findById(id);
        if(movieOptional.isPresent())
        {
            Customer customerToSave=movieOptional.get();
            customerToSave.setFirst_name(newCustomer.getFirst_name());
            customerToSave.setLast_name(newCustomer.getLast_name());
            customerToSave.setEmail(newCustomer.getEmail());
            customerToSave.setBirth_date(newCustomer.getBirth_date());
            customerRepo.save(customerToSave);
            return new ResponseEntity("Updated Customer with id "+id,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("No Customer with id "+id+" found",HttpStatus.NOT_FOUND);
        }
    }



}
