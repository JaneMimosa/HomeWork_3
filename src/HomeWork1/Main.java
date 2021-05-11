package HomeWork1;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(new String[]{"Bye", "Goodbye", "Hi", "Hello"});
        array.changeArrayList(0, 2);
        array.toArrayList();
        Apple apple = new Apple();
        Box box = new Box();
        Box boxTwo = new Box();
        Box boxThree = new Box();
        Orange orange = new Orange();
        box.add(apple);
        box.add(apple);
        boxTwo.add(orange);
        boxTwo.add(orange);
        System.out.println(box.getWeight());
        System.out.println(box.compare(boxTwo));
        box.transfer(boxThree);
        System.out.println(box.getWeight());
    }
}