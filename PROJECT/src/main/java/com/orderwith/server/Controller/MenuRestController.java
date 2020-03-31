package com.orderwith.server.Controller;

import com.orderwith.server.DAO.MenuDAO;
import com.orderwith.server.Model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuRestController {

    @Autowired
    private MenuDAO menuDAO;

    @GetMapping("/menu")
    public HashMap getCustomers() {
        HashMap<String, List> hashMap = new HashMap<>();
        hashMap.put("Menus", menuDAO.list());
        return hashMap;
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
