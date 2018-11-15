import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

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
