package main;

import main.models.Toy;
import main.models.ToysModel;
import main.views.Introduction;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        Introduction introductions = new Introduction();
        String userName = introductions.introHello();
        ToysModel model = new ToysModel();
        List<Toy> t1 = null;
        try{
            t1= model.addToys();
        }catch(NumberFormatException ex){
            System.out.println("Требуется ввести цифру. Попробуй еще раз.");
            try{
                model.addToys();
            }catch(NumberFormatException e){
                System.out.println("И вторая попытка мимо, начни сначала");
            }
        }
        System.out.println(model.changeFrequency(t1, "Filly", 8));
    }
}
