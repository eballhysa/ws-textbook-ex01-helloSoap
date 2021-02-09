/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eltonb.ws;

import java.util.Calendar;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author elton.ballhysa
 */
@WebService(serviceName = "HelloService")
public class HelloService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "echo")
    public String echo(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "greet")
    public HelloResponse greeting(@WebParam(name="request") HelloRequest request) {
        HelloResponse response = new HelloResponse();
        String greeting = computeGreeting();
        response.setGreeting(greeting + " " + request.getName().toUpperCase() + " " + request.getSurname().toUpperCase() + "!");
        response.setDate(new Date());
        return response;
    }

    private String computeGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour < 12)
            return "Good morning";
        if (hour < 17)
            return "Good afternoon";
        if (hour < 21)
            return "Good evening";
        return "Good night";
    }

}
