package epam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Order {

    static TreeMap <String, LinkedHashMap<Clothing, Integer>> orderMap = new TreeMap<>();
    String myDate = "11.08.2016 11:33";  //можно сделать ввод с консоли, но уже впадлу


    void printAllOrders() {

        if (orderMap.isEmpty()) {
            System.out.println("Текущих заказов нет.");
        } else {
            Set<Map.Entry<String, LinkedHashMap<Clothing, Integer>>> se = orderMap.entrySet();

            for (Map.Entry<String, LinkedHashMap<Clothing, Integer>> me : se) {
                System.out.println();
                System.out.println("Дата заказа: " + me.getKey() + " ");
                Set<Map.Entry<Clothing, Integer>> se1 = me.getValue().entrySet();
                System.out.println("Заказ:");
                for (Map.Entry<Clothing, Integer> me1 : se1) {
                    System.out.print(me1.getKey() + " - ");
                    System.out.println(me1.getValue() + "шт.");
                }
            }
        }
    }

    void printClosestOrder() {
        if (orderMap.isEmpty()) {
            System.out.println("Текущих заказов нет.");
        } else {
            System.out.println();
            System.out.println("Ближайший к дате заказ:");
            String s1 = orderMap.floorKey(myDate);
            Set<Map.Entry<Clothing, Integer>> se2 = orderMap.get(s1).entrySet();
            System.out.println("Заказ:");
            for (Map.Entry<Clothing, Integer> me1 : se2) {
                System.out.print(me1.getKey() + " - ");
                System.out.println(me1.getValue() + "шт.");
            }

        }

    }

}

