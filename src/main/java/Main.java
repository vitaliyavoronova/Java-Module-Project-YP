import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в гонку '24 часа Лемана', где сегодня мы определим самый быстрый автомобиль на Диком Западе!");
        System.out.println("Настало время узнать участников сегодняшней гонки!");
        System.out.println("Введите название автомобиля №1:");
        String nameAutoFirst = nameCheck();

        System.out.println("Введите скорость автомобиля №1:");
        int speedAutoFirst = speedCheck();

        Auto autoFirst = new Auto(nameAutoFirst, speedAutoFirst);

        System.out.println("Введите название автомобиля №2:");
        String nameAutoSecond = nameCheck();

        System.out.println("Введите скорость автомобиля №2:");
        int speedAutoSecond = speedCheck();

        Auto autoSecond = new Auto(nameAutoSecond, speedAutoSecond);

        System.out.println("Введите название автомобиля №3:");
        String nameAutoThird = nameCheck();

        System.out.println("Введите скорость автомобиля №3:");
        int speedAutoThird = speedCheck();

        Auto autoThird = new Auto(nameAutoThird, speedAutoThird);

        ArrayList<Auto> autoList = new ArrayList<>();
        autoList.add(autoFirst);
        autoList.add(autoSecond);
        autoList.add(autoThird);

        Race race = new Race();
        race.checkLeader(autoList);
        System.out.println("Победителем гонки становится автомобиль под названием " + race.leaderName + "! Он проехал целых " + race.distance + " километров за 24 часа!");
    }

    public static String nameCheck() {
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.next();
        while (name.trim().isEmpty()) {
            System.out.println("Имя не может быть пустым. Попробуйте еще раз:");
            nameScanner.next();
        }
        return name;
    }


    public static int speedCheck() {
        Scanner speedScanner = new Scanner(System.in);
        int speed;
        do {
            if (speedScanner.hasNextInt()) {
                speed = speedScanner.nextInt();
                if (speed > 250) {
                    System.out.println("Введено неверное значение скорости. Скорость не может быть больше 250. Попробуйте еще раз:");
                } else if (speed < 0) {
                    System.out.println("Введено неверное значение скорости. Скорость не может быть меньше 0. Попробуйте еще раз:");
                } else {
                    break;
                }
            } else {
                System.out.println("Введено неверное значение. Скорость должна быть указана целым числом. Попробуйте еще раз:");
                speedScanner.next();
            }
        } while (true);

        if (0 <= speed && speed <= 90) {
            System.out.println("Не гоночный болид, конечно, но пойдет!");
        } else if (90 < speed && speed <= 170) {
            System.out.println("Достойная лошадка!");
        } else if (170 < speed && speed <= 250) {
            System.out.println("Вау, вот это быстрый зверь!");
        }
        return speed;
    }
}