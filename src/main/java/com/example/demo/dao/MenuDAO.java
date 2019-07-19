package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.model.IndexMenu;
import com.example.demo.model.Menu;
import org.apache.poi.ss.formula.functions.Index;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class MenuDAO {
    //private static List menus;
    private static List<Menu> menuArrayList;
    String input_menu;
    int[][] index;
    Map<Character, Integer> indexMenu = new HashMap<>();
    private static List<IndexMenu> menuIndex;

    {
        //menus = new ArrayList();
        try {
            //File file = new File("C:\\Users\\sm-pc\\IdeaProjects\\ORDER-WITH-SERVER-re\\src\\main\\resources\\raw\\miso_menu.txt");
            File file = new File("C:\\Users\\sm-pc\\IdeaProjects\\ORDER-WITH-SERVER-re\\src\\main\\resources\\raw\\miso_menu.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int num = Integer.parseInt(bufferedReader.readLine());

          /* for (int i = 0; i < num; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                String menu = input[0];
                String price = input[1];
                menus.add(new Menu(menu, price));
            } */

            menuArrayList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String[] data = bufferedReader.readLine().split(" ");
                String name = data[0];
                //int price = Integer.parseInt(data[1]);
                String price = data[1];
                menuArrayList.add(new Menu(i, name, price));
            }
            index = new int[55205][num * 2];

            //한글유니코드는 44032(0xAC00)~55203(0xD7A3) 의 범위
            for (int i = 0; i < menuArrayList.size(); i++) {
                char[] menu = menuArrayList.get(i).getName().toCharArray();
                for (int j = 0; j < menu.length; j++) {
                    System.out.print(menu[j] + " ");
                    int char_num = (int) menu[j];
                    System.out.print(menuArrayList.get(i).getNum() + "번째 메뉴 숫자: " + char_num);
                    System.out.print("문자: " + (char) char_num + "\n");
                    index[char_num][0]++;
                    index[char_num][index[char_num][0]] = menuArrayList.get(i).getNum();
                }
            }
            System.out.println();

            menuIndex = new ArrayList<>();
            for (int i = 44032; i < 55204; i++) {
                System.out.print((char) i + ": " + index[i][0] + " ");// count출력

                char character = (char)i;
                int count = index[i][0];
                menuIndex.add(new IndexMenu(character, count));

                ////////////////////////////////////////////////////////////////////////////////////////
                //indexMenu.put((char)i, index[i][0]);
                //int indexCount = indexMenu.get((char)i);
                //System.out.print("indexCount : "  + indexCount);
                //menuIndex.add(new IndexMenu((char)i, indexCount));
            }

            //System.out.print("김 : " + indexMenu.get((char)44608));
            System.out.println("\n" + "------");

            for (int i = 44032; i < 55204; i++) {
                  System.out.print((char) i + ": ");
                for (int j = 1; j <= index[i][0]; j++) {
                       System.out.print(index[i][j] + " ");
                }
            }

            //System.out.print("메뉴 어플에서 입력 받기");

            if(input_menu != null) {
                System.out.print("메뉴를 입력하세요: ");
                DemoApplication da = new DemoApplication();

                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                //String input_menu = bufferedReader.readLine();//라면
                input_menu = da.inputData;
                System.out.println("입력값 : " + input_menu);

                int[] count_arr = new int[menuArrayList.size() + 1];
                for (int i = 0; i < input_menu.length(); i++) {
                    char temp = input_menu.charAt(i);
                    if (index[(int) temp][0] != 0) {
                        for (int j = 1; j < index[(int) temp][0] + 1; j++) {//
                            int menu_num = index[(int) temp][j];
                            count_arr[menu_num]++;
                        }
                    }
                }
                System.out.println("\n " + "-----------");
                int max = 0;
                for (int i = 0; i < menuArrayList.size(); i++) {
                    System.out.println(menuArrayList.get(i).getName() + "(" + i + ")" + ":" + count_arr[i]);
                    if (count_arr[i] > max) {
                        max = count_arr[i];
                    }
                }
                System.out.print("max 값: " + max);

                System.out.println("\n" + "**추천메뉴**");

                for (int i = 0; i < menuArrayList.size(); i++) {
                    if (count_arr[i] == max) {
                        System.out.println(menuArrayList.get(i).getName());
                    }
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List list() {
        //return menus;
        return menuArrayList;
    }

    public List getMenuIndex() {
        return menuIndex;
    }

    public Menu get(Long id) {
        return null;
    }

    public Menu create(Menu menu) {
        return menu;
    }

    public Long delete(Long id) {
        return null;
    }

    public Menu update(Long id, Menu customer) {
        return null;
    }
}
