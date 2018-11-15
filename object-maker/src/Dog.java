import java.util.ArrayList;

public class Dog {
    public void bark(String name){
        System.out.println("woof woof");
        System.out.println(name);
    }

    public String name;

    public Dog(String name) {
        this.name = name;
        bark(name);
    }

    public static void main(String[] args) {
        int x;
        x = 3;
        Dog d;
        d = new Dog("ralf");
        Dog fido;
        fido = d;
        d.bark(d.name);
        d.name = "Jim";
        fido.name = "Fido";
        fido.bark(fido.name);
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(d);
    }
}
