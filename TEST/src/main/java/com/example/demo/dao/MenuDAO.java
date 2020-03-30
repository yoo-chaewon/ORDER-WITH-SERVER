package com.example.demo.dao;

import com.example.demo.model.Menu;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MenuDAO {
    public static List menus;

    //    {
//        menus = new ArrayList();
//        menus.add(new Menu("불고기 덮밥", "2000"));
//        menus.add(new Menu("불고기 김밥", "5000"));
//        menus.add(new Menu("떡볶이", "100"));
//    }
    {
        menus = new ArrayList();
        try {
            File file = new File("/Users/yoochaewon/Documents/CODING/SERVER-PROJECT/ORDER-WITH-SERVER/src/main/resources/raw/miso_menu.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int num = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < num; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                String menu = input[0];
                String price = input[1];
                menus.add(new Menu(i,menu, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List list() {
        return menus;
    }

    public Menu get(Long id) {
        /*
        for (Menu c : menus) {
            if (c.getId().equals(id)) {
                return c;
            }
        }*/
        return null;
    }

    public Menu create(Menu menu) {
        /*
        customer.setId(System.currentTimeMillis());
        customers.add(customer);*/
        return menu;
    }

    public Long delete(Long id) {
        /*
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customers.remove(c);
                return id;
            }
        }*/
        return null;
    }

    public Menu update(Long id, Menu customer) {
        /*
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }*/
        return null;
    }
}
