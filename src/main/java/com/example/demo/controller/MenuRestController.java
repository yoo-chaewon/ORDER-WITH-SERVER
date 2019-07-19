package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.dao.MenuDAO;
import com.example.demo.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MenuRestController {

    @Autowired
    private MenuDAO menuDAO;

    @GetMapping("/menu")
    //@RequestMapping("/menu")
    public List getCustomers() {
        return menuDAO.list();
    }


    @RequestMapping("/index")
    public List getIndex() {
        return menuDAO.getMenuIndex();
    }




    @GetMapping("/menu/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {
        Menu menu = menuDAO.get(id);
        if (menu == null) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(menu, HttpStatus.OK);
    }

    @PostMapping(value = "/menu")
    public ResponseEntity createCustomer(@RequestBody Menu menu) {
        menuDAO.create(menu);
        return new ResponseEntity(menu, HttpStatus.OK);
    }


    @DeleteMapping("/menu/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        if (null == menuDAO.delete(id)) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Menu menu) {
        menu = menuDAO.update(id, menu);
        if (null == menu) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(menu, HttpStatus.OK);
    }

}