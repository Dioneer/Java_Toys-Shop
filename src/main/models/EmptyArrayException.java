package main.models;

public class EmptyArrayException extends Exception{
    public String getMessage() {
        return "Магазин пуст, начните с заполнения";
    }
}
