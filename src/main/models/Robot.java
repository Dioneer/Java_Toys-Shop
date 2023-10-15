package main.models;

import java.util.UUID;

public class Robot extends Toy{
    public Robot(String toyName, int quantity) {
        super(UUID.randomUUID().toString(), toyName, quantity, 20);
    }

    @Override
    public String toString() {
        return String.format("toy id - %s, toy name - %s, toy quantity - %d, frecquency - %.1f , toy class - %s\n",
                getId(), getToyName(), getQuantity(), getFrequency(), this.getClass().getSimpleName());
    }
}