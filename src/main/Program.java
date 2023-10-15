package main;

import main.models.ToysModel;
import main.presenters.ShopPresenter;
import main.views.ShopView;

import java.util.Scanner;


public class Program {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ShopView shopView = new ShopView();
        ShopPresenter shopPresenter = new ShopPresenter(new ToysModel(), shopView);
        String userName = shopView.intro();
        boolean flag = true;
        System.out.println("Давайте начнем наш розыгрыш!");
        while (flag){
            System.out.println("Выберите один из следующих пунктов: 1.Добавить игрушки для розыгрыша; 2.Показать все имеющиеся игрушки; 3.Сменить шанс выпадения для игрушки;" +
                    " 4.Разыграть приз; 5.Принять приз; 6.Получить талон для выдачи приза.7.Выйти");
            if(scanner.hasNext()) {
                int key = Integer.parseInt(scanner.nextLine());
                switch (key) {
                    case 1:
                        shopPresenter.addToys();
                        break;
                    case 2:
                        shopPresenter.showToys();
                        break;
                    case 3:
                        System.out.println("Tрубется ввести имя игрушки и шанс через ';'");
                        String[] arr = scanner.nextLine().trim().split(";");
                        shopPresenter.changeToyFrequency(arr[0], Double.parseDouble(arr[1]));
                        break;
                    case 4:
                        shopPresenter.showYourPrize();
                        break;
                    case 5:
                        shopPresenter.confirm();
                        break;
                    case 6:
                        shopPresenter.createCoupon(userName);
                        System.out.println("Списоку быдет выдан по факту выхода");
                        break;
                    case 7:
                        System.out.println("Пока!");
                        flag = false;
                        break;

                }
            }
        }

    }
}
