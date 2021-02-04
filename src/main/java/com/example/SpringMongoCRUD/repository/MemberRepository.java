package com.example.SpringMongoCRUD.repository;

import com.example.SpringMongoCRUD.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member,String> {
}
