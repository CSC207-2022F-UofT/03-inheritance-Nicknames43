/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    private String color;
    private int numberOfContents, capacity;
    private String[] contents;

    public Bag(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        numberOfContents = 0;
        contents = new String[capacity];
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfContents() {
        return numberOfContents;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean addItem(String item){
        if(numberOfContents < capacity){
            contents[numberOfContents] = item;
            numberOfContents++;
            return true;
        }
        return false;
    }

    public String popItem(){
        if(numberOfContents != 0){
            numberOfContents -= 1;
            String item = contents[numberOfContents];
            contents[numberOfContents] = null;
            return item;
        }
        return null;
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        String[] copy = new String[capacity + n];
        for(int i = 0; i<capacity; i++){
            copy[i] = contents[i];
        }
        contents = copy;
        capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}