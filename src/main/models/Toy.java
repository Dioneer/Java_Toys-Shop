package main.models;

public abstract class Toy {
    /**
     *
     * getters for children
     */
    public String getId() {
        return id;
    }

    public String getToyName() {
        return toyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public Toy(String id, String toyName, int quantity, double frequency) {
        this.id = id;
        this.toyName = toyName;
        this.quantity = quantity;
        this.frequency = frequency;
        count += this.quantity;
    }
    private final String id;
    private final String toyName;
    private final int quantity;
    private double frequency;
    public static int count;
}
