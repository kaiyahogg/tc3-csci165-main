import java.awt.EventQueue;
//import javax.swing.*;

public class Driver {
    public static void main(String[] args){
        /*
        ArrayList<Creature> creatures = new ArrayList<Creature>();

        Creature hobbit = new Hobbit();
        Creature nazgul = new Nazgul();
        Creature sauron = new Sauron();
        Creature vegetation = new Vegetation();
        Item sword = new Weapon();
        Item armor = new Armor();
        Item food = new Food();
        
        hobbit.setHunger(7);
        hobbit.equip(sword);
        hobbit.equip(armor);
        hobbit.equip(food);
        creatures.add(hobbit);
        creatures.add(nazgul);
        creatures.add(sauron);
        creatures.add(vegetation);

        
        for(Creature c : creatures){
            System.out.println("\n" + c);
            c.moveRight();
            c.attack(c);
            c.replicate();
            c.stay();
            c.chooseAction();
            c.color();
            System.out.println("Equipable: "+c.equipable());
        }
        */
        
        //System.out.println(hobbit.inventory.toString());

        EventQueue.invokeLater(() -> {
            
            Surface ex = new Surface();
            ex.setVisible(true);
        });
    }
}