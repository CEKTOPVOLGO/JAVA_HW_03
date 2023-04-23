import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Введите номер задачи (1 - 3): ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number){
        case 1:
            task1();
            break;
        case 2:
            task2();
            break;
        case 3:
            task3();
            break;
        }

    }
    public static void task1() {
    /*
    Пусть дан произвольный список целых чисел, удалить из него четные числа
     */    
        List<Integer> list = createList(20, 0, 10);
        System.out.println(list);
        delEven(list);
        System.out.println(list);
    }

    public static void task2() {
        /*
         * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()
         */
        List<Integer> list = createList(20, 0, 100);
        System.out.println(list);
        System.out.println("Минимальное значение - " + Collections.min(list));
        System.out.println("Максимальное значение - " + Collections.max(list));
        System.out.println("Среднее значение - " + avrVal(list));
    }

    public static void task3() {
        /*
         * Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
         * Вывести название каждой планеты и количество его повторений в списке.
         * Меркурий, Венера, Земля, Марс, Юпитер, Сатурн, Уран, Нептун, Плутон
         */
        List<String> list = Arrays.asList("Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон");
        System.out.println(list);
        List<String> planets = fillPlanet(list, 20);
        System.out.println(planets);
        counterPlanet(list, planets, 20);
    }

    public static List<Integer> createList(int size, int min, int max) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add((int)(Math.random() * (max - min + 1) + min));            
        }
        return list;
    }

    public static void delEven(List<Integer> list) {
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            int temp = (int)iterator.next();
            if (temp % 2 == 0){
                iterator.remove();
            }
        }        
    }

    public static double avrVal(List<Integer> list) {
        int temp = 0;
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            temp += (int)iterator.next();
        }        
        return (double)temp / list.size();
    }

    public static List<String> fillPlanet(List<String> list, int size) {
        List<String> planets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            planets.add(list.get(randomPlanet()));
        }
        return planets;        
    }
    public static int randomPlanet() {
        return (int)(Math.random() * 9);
    }

    public static void counterPlanet(List<String> list, List<String> planets, int size) {
       int temp = 0;
       for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < planets.size(); j++) {
                if (list.get(i) == planets.get(j)){
                    temp++;
                }
            }
            System.out.println(list.get(i) + " - " + temp);
            temp = 0;
        }
    }
}