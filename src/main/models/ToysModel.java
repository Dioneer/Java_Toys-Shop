package main.models;

import main.presenters.Model;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToysModel implements Model{
    Showcase showcase = new Showcase();
    FillShop fillShop = new FillShop();
    Map<Integer, Toy> presents = new HashMap<>();
    int count = 0;
    Toy present = null;
    public List<Toy> addToys(){
        showcase.getMainArray().addAll(fillShop.createToys());
        return showcase.getMainArray();
    }
    public List<Toy> changeFrequency(String name, double frequency){
        try {
            if(showcase.getMainArray().size()>1) {
                for (int i = 0; i < showcase.getMainArray().size(); i++) {
                    if (showcase.getMainArray().get(i).getToyName().equals(name)) {
                        showcase.getMainArray().get(i).setFrequency(frequency);
                    }
                }
            }else{
            throw new EmptyArrayException();
            }
        }catch(EmptyArrayException e){
            System.out.println(e.getMessage());
        }
        return showcase.getMainArray();
    }

    public Toy prizeSelection(){
        try {
            if(showcase.getMainArray().size()>1) {
                for (int i = 0; i < showcase.getMainArray().size(); i++) {
                    double chance1 = Math.round(Math.random() * showcase.getMainArray().get(i).getFrequency() * 10);
                    showcase.getMainArray().get(i).setFrequency(chance1);
                }
                showcase.getMainArray().sort(new CompareToys());
                present = showcase.getMainArray().get(0);
            }else {
                throw new EmptyArrayException();
            }
        }catch(EmptyArrayException e){
        System.out.println(e.getMessage());
        }
        return present;
    }
    public List<Toy> listOfPresents(Toy toy){
        ++count;
        for (int i = 0; i < showcase.getMainArray().size(); i++) {
            if(showcase.getMainArray().get(i).getId().equals(toy.getId())){
                if(showcase.getMainArray().get(i).getQuantity()>=2){
                    showcase.getMainArray().get(i).setQuantity(showcase.getMainArray().get(i).getQuantity()-1);
                }else{
                    showcase.getMainArray().remove(i);
                }
            }
        }
        presents.put(count, toy);
        return showcase.getMainArray();
    }
    public void makeCheck(String userName) {
        try {
            if (!presents.isEmpty()) {
                File file = new File("coupon for "+userName+".txt");
                try (BufferedWriter writer=new BufferedWriter(new FileWriter(file, true))) {
                    for (Map.Entry<Integer, Toy> item : presents.entrySet()) {
                        writer.write(item.getKey()+": ");
                        writer.write(item.getValue()+"\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                throw new EmptyArrayException();
            }

        }catch(EmptyArrayException e){
            System.out.println(e.getMessage());
        }
}}
