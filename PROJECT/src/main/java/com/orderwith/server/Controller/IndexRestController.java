package com.orderwith.server.Controller;

import com.orderwith.server.DAO.IndexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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




