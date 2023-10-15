package main.presenters;

import main.models.Toy;

import java.util.List;

public interface Model {
    List<Toy> addToys();
    List<Toy> changeFrequency(String name, double frequency);
    Toy prizeSelection();
    List<Toy> listOfPresents(Toy toy);
    void makeCheck(String name);
}
