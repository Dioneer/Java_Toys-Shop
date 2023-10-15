package main.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToysModel {
    private List<Toy> toys;
    FillShop fillShop = new FillShop();

    public List<Toy> addToys(){
        if(toys==null){
            toys = new ArrayList<>();
        }
        toys.addAll(fillShop.createToys());
        return toys;
    }
    public List<Toy> changeFrequency(List<Toy>arr, String name, int frequency){
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getToyName().equals(name)){
                arr.get(i).setFrequency(frequency);
            }
        }
        return arr;
    }

//    public Toy prizeSelection(List<Toy>arr){
//        Collections.sort(arr,);
//    }
}
