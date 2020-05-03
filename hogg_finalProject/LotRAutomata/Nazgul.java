
public class Nazgul implements Creature{

    private int health = 200;
    private int attack = 50;
    private int hunger = 11;

    public Nazgul(){}

    public Nazgul(int h, int a){
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
        hunger = hunger + h;
    }

    @Override
    public void move(){
        System.out.println("move successful (Nazgul)");
    }
    //Should add to hunger value
    @Override
    public void attack(Creature c){
        System.out.println("attack successful (Nazgul)");
    }

    @Override
    public Creature replicate(){
        Creature nazgul = new Nazgul();
        System.out.println("replication successful (Nazgul)");
        return nazgul;
    }

    @Override
    public void stay(){
        System.out.println("stay successful (Nazgul)");
    }
    
    @Override
    public void chooseAction(){
        System.out.println("chooseAction successful (Nazgul)");
    }

    @Override
    public void color(){
        System.out.println("Color succesful (Nazgul)");
    }

    @Override
    public boolean equipable(){
        return true;
    }

    @Override
    public String toString(){
        return "Nazgul has " + health +" health, " + attack + " attack, " + hunger + " hunger";
    }
}