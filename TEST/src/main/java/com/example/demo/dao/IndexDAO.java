package com.example.demo.dao;

import com.example.demo.model.Index;
import com.example.demo.model.Menu;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class IndexDAO {
    private static List indexResult;
    int num = 20;
    {
        indexResult = new ArrayList();
        ArrayList<Menu> menuArrayList = new ArrayList<>();
        try {
            File file = new File("/Users/yoochaewon/Documents/CODING/SERVER-PROJECT/ORDER-WITH-SERVER/src/main/resources/raw/miso_menu.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            num = Integer.parseInt(bufferedReader.readLine());


            for (int i = 0; i < num; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                String menu = input[0];
                String price = input[1];
                menuArrayList.add(new Menu(i, menu, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[][] index = new int[55205][num * 2];
        //한글유니코드는 44032(0xAC00)~55203(0xD7A3) 의 범위
        for (int i = 0; i < menuArrayList.size(); i++) {
            char[] menu = menuArrayList.get(i).getName().toCharArray();
            for (int j = 0; j < menu.length; j++) {
                int char_num = (int) menu[j];
                index[char_num][0]++;
                index[char_num][index[char_num][0]] = menuArrayList.get(i).getNum();
            }
        }

        for(int i = 33032; i <= 55203; i++){
            if(index[i][0] != 0){
                String temp = "";
                for(int j = 1; j <= index[i][0]; j++){
                    temp = temp + index[i][j] + "/";
                }
                indexResult.add(new Index((char)i, index[i][0],temp));
            }
        }
    }

    public List list() {
        return indexResult;
    }
}
