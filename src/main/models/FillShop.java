package main.models;

import java.util.*;

public class FillShop {
    Scanner scanner = new Scanner(System.in);

    public List<Toy> createToys() throws InputMismatchException {
        Random random = new Random();
        boolean flag = true;
        List<Toy> list = new ArrayList<>();
        while (flag) {
            System.out.println("В связи с тем, что это учебный проект наш магазин пуст. Как бы ты хотел заполнить его? 1. - Фабрика, 2 - Самостоятельно");
            int ans = Integer.parseInt(scanner.next());
            switch (ans) {
                case 1:
                    String[] toyName = new String[]{"Billi", "Filly", "Killy", "Gloin", "Nory", "Dory", "Biffur", "Boffur", "Bombur", "Torrin"};
                    int[] amount = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                    for (int i = 0; i < 10; i++) {
                        int index = random.nextInt(0, 3);
                        switch (ToyType.values()[index]) {
                            case Robot:
                                list.add(new Robot(toyName[random.nextInt(toyName.length)], amount[random.nextInt(amount.length)]));
                                break;
                            case Pazzle:
                                list.add(new Pazzle(toyName[random.nextInt(toyName.length)], amount[random.nextInt(amount.length)]));
                                break;
                            case Doll:
                                list.add(new Doll(toyName[random.nextInt(toyName.length)], amount[random.nextInt(amount.length)]));
                                break;
                        }
                    }
                    flag = false;
                    break;
                case 2:
                    System.out.println("Сколько игрушек ты хочешь создать (введи неотрицательную цифру):");
                    int ind = Integer.parseInt(scanner.next());
                    for (int i = 0; i < ind; i++){
                        System.out.println("Введите название игрушки: ");
                        String name = scanner.next();
                        System.out.println("Введите количество: ");
                        int qu = Integer.parseInt(scanner.next());
                        System.out.println("Введите тип игрушки: 0 - Робот, 1 - Пазл, 2 - Кукла");
                        int type = Integer.parseInt(scanner.next());
                        switch (ToyType.values()[type]) {
                            case Robot:
                                list.add(new Robot(name, qu));
                                break;
                            case Pazzle:
                                list.add(new Pazzle(name, qu));
                                break;
                            case Doll:
                                list.add(new Doll(name, qu));
                                break;
                        }
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуй еще раз.");
            }
        }
        scanner.close();
        return list;
    }

}
