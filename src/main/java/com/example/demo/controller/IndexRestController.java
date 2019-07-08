package com.example.demo.controller;

import com.example.demo.dao.IndexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexRestController {
    @Autowired
    private IndexDAO indexDAO;

    @GetMapping("/index")
    public List getCustomers() {
        return indexDAO.list();
    }

}
