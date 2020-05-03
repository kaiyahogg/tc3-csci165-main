import java.util.*;

public class Driver {
    public static void main(String[] args){
        ArrayList<Creature> creatures = new ArrayList<Creature>();

        Creature hobbit = new Hobbit();
        Creature nazgul = new Nazgul();
        Creature sauron = new Sauron();
        Creature vegetation = new Vegetation();

        creatures.add(hobbit);
        creatures.add(nazgul);
        creatures.add(sauron);
        creatures.add(vegetation);

        for(Creature c : creatures){
            System.out.println("\n" + c);
            c.move();
            c.attack(c);
            c.replicate();
            c.stay();
            c.chooseAction();
            c.color();
            System.out.println("Equipable: "+c.equipable());
        }
    }
}