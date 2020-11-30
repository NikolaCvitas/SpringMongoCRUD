package com.example.SpringMongoCRUD.repository;

import com.example.SpringMongoCRUD.model.Customer;
import com.example.SpringMongoCRUD.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRespository extends MongoRepository<Customer,String> {
}
