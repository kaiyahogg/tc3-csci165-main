
public class Sauron implements Creature{

    /*
        Spawns if 10-15 Nazguls exist. Gets hungry and devours
        all of Middle-Earth the following turn. Should be a rare spawn.
    */

    //Values should be absurd, could be defeated if hobbits get ahold of certain items
    private int health = 10000;
    private int attack = 10000;
    private int hunger;

    public Sauron(){}

    public Sauron(int h, int a){
        setHealth(h);
        setAttack(a);
    }

    @Override
    public int getHealth(){
        return health;
    }

    @Override
    public int getAttack(){
        return attack;
    }

    @Override
    public int getHunger(){
        return hunger;
    }

    @Override
    public void setHealth(int h){
        health = h;
    }

    @Override
    public void setAttack(int a){
        attack = a;
    }

    @Override
    public void setHunger(int h){
        hunger = 2;
    }

    @Override
    public void move(){
        System.out.println("move successful (Sauron)");
    }

    @Override
    public void attack(Creature c){
        System.out.println("attack successful (Sauron)");
    }

    @Override
    public Creature replicate(){
        Creature nazgul = new Nazgul();
        System.out.println("replication successful (Sauron)");
        return nazgul;
    }

    @Override
    public void stay(){
        System.out.println("stay successful (Sauron)");
    }
    
    @Override
    public void chooseAction(){
        System.out.println("chooseAction successful (Sauron)");
    }

    @Override
    public void color(){
        System.out.println("Color succesful (Sauron)");
    }

    @Override
    public boolean equipable(){
        return false;
    }

    @Override
    public String toString(){
        return "Sauron is omnipotent now";
    }

}