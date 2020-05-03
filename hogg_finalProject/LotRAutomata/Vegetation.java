
public class Vegetation implements Creature{

    /*
        Multiple spawn at beginning of game, if left alone for 2 turns will
        replicate. Drops an item when killed. When three of this item are obtained
        they will produce a quiche.
    */

    //Values should let unequipped hobbits harvest
    private int health = 1;
    private int attack = 0;
    private int hunger;

    public Vegetation(){}

    public Vegetation(int h, int a){
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
        hunger = 10000;
    }

    @Override
    public void move(){
        System.out.println("move successful (Vegetation)");
    }

    @Override
    public void attack(Creature c){
        System.out.println("attack successful (Vegetation)");
    }

    @Override
    public Creature replicate(){
        Creature nazgul = new Nazgul();
        System.out.println("replication successful (Vegetation)");
        return nazgul;
    }

    @Override
    public void stay(){
        System.out.println("stay successful (Vegetation)");
    }
    
    @Override
    public void chooseAction(){
        System.out.println("chooseAction successful (Vegetation)");
    }

    @Override
    public void color(){
        System.out.println("Color succesful (Vegetation)");
    }

    @Override
    public boolean equipable(){
        return false;
    }

    @Override
    public String toString(){
        return "Vegetation is ready to be harvested";
    }

}
