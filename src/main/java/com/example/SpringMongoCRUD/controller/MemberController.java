package com.example.SpringMongoCRUD.controller;

import com.example.SpringMongoCRUD.model.Member;
import com.example.SpringMongoCRUD.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;


    @RequestMapping(method= RequestMethod.GET,value="/members")
    public ResponseEntity getAllMembers(){
        List<Member> members = memberRepository.findAll();

        if(members.size() > 0){
            return new ResponseEntity(members, HttpStatus.OK);
        }else {
            return  new ResponseEntity("No members found", HttpStatus.NOT_FOUND);
        }
    }

}
