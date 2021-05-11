package HomeWork1;

import java.util.ArrayList;

public class Box<T> {
    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<T>();
    }

    public void add(T fruit) {
        if (box.size() == 0) {
            box.add(fruit);
        } else if (box.get(0).getClass() == fruit.getClass()) {
            box.add(fruit);
        } else {
            System.out.println("Different fruits can't be in the same box");
        }
    }

    public <T extends Fruit> double getWeight() {
        if(box.size() != 0) {
            T fruit = (T) box.get(0);
            double fruitWeight = fruit.getWeight();
            double boxWeight = box.size() * fruitWeight;
            return boxWeight;
        } return 0.0;
    }

    public boolean compare(Box otherBox) {
        if (getWeight() == otherBox.getWeight()) {
            return true;
        }
        return false;
    }

    public void transfer(Box otherBox) {
        if(otherBox.box.size() == 0) {
            otherBox.box.addAll(this.box);
            this.box.removeAll(this.box);
        } else if(box.get(0).getClass() == otherBox.box.getClass()) {
            otherBox.box.addAll(this.box);
            this.box.removeAll(this.box);
        } else {
            System.out.println("Can't be transferred into that box");
        }
    }
}
