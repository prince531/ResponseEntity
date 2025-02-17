package com.example.index25_response_entity_http_status.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    //Combining multiple response types
    @GetMapping("/result")
    public ResponseEntity<?> responseExample(){
        
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Prince");

        Map<String,String>responseBody = new HashMap<>();
        responseBody.put("name","Raj Kumar");
        responseBody.put("age","25");

        Map<String, Object> combinedResponse = new HashMap<>();
        combinedResponse.put("list", list);
        combinedResponse.put("responseBody", responseBody);
        return ResponseEntity.ok().body(combinedResponse);
    }

    @GetMapping("/notfound")
    public ResponseEntity<Void> getNotFound(){
        return ResponseEntity.status(404).build();
    }
    @GetMapping("/badrequest")
    public ResponseEntity<Void> getBadRequest(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/badrequest2")
    public ResponseEntity<?> getBadRequest2(){
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.set(HttpHeaders.AUTHORIZATION, "Prince Auth");
        headers.add("Custom Name","Hidden information");
        //set url of new location
        headers.setLocation(URI.create("http://www.google.com"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body("Bad Request");
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
    }

    @GetMapping("/error")
    public ResponseEntity<Void> getError(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
    }

    @GetMapping("/headers")
    public ResponseEntity<?> getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        //set catch-control header
        //cookie ki expire time set karne ke liye
        //set url of new location
        //set auth
        headers.set(HttpHeaders.AUTHORIZATION , "Bearer <token xyz>");
        //set type of content
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        //cookies set
        headers.set(HttpHeaders.SET_COOKIE, "cookie=cookiePrince; Secure; HttpOnly");
        headers.add("Custom Name","Hidden information");
        return ResponseEntity.status(200).headers(headers).body("Headers set successfully");
    }
    
    @GetMapping("/string")
    public ResponseEntity<String> getString(){
        String str = "Hello World";
        return ResponseEntity.ok().body(str);
    }

    @GetMapping("/json")
    public ResponseEntity<Map<String, String>> getJson(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "Kaushal");
        map.put("age", "25");
        return ResponseEntity.ok().body(map);
    }

    @GetMapping("/array")
    public ResponseEntity<ArrayList<String>> getArray(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("India");
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/map")
    public ResponseEntity<Map<String, String>> getMap(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "Kaushal");
        map.put("age", "30");
        return ResponseEntity.ok().body(map);
    }

    @GetMapping("/combined")
    public ResponseEntity<?> getCombined(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("India");

        Map<String, String> map = new HashMap<>();
        map.put("name", "Kaushal");
        map.put("age", "30");

        Map<String, Object> combinedResponse = new HashMap<>();
        combinedResponse.put("list", list);
        combinedResponse.put("map", map);
        return ResponseEntity.ok().body(combinedResponse);
    }

    @GetMapping("/status")
    public ResponseEntity<?> getStatus(){
        return ResponseEntity.status(200).body("Status code 200");
    }

    @GetMapping("/status2")
    public ResponseEntity<?> getStatus2(){
        return ResponseEntity.status(HttpStatus.OK).body("Status code 200");
    }

    @GetMapping("/status3")
    public ResponseEntity<?> getStatus3(){
        return ResponseEntity.ok().body("Status code 200");
    }

    @GetMapping("/response")
    public ResponseEntity<?> getResponse(){
        return ResponseEntity.ok().body("Response Entity");
    }

    @GetMapping("/empty")
    public ResponseEntity<Void> getEmpty(){
        return ResponseEntity.noContent().build();
    }

    
}
