package com.example.SpringMongoCRUD.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuoraController extends BaseController {


    //example call
    //http://localhost:8080/zuora/payment?paymentMethodId=123&country=Hrvatska

    @RequestMapping("/zuora/payment")
    public String payment(@RequestParam String paymentMethodId,
                          @RequestParam String country,
                          @RequestParam(required = false) String city){

        print("payment _____________________");
        print(paymentMethodId);
        print(country);
        print(city);

        String result = null;

        return result;
    }

}
