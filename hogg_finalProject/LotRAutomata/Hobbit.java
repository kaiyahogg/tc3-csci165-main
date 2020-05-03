
public class Hobbit implements Creature{

    private int health = 100;
    private int attack = 10;
    private int hunger = 11;

    public Hobbit(){}

    public Hobbit(int h, int a){
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
        if(hunger + h > 11) hunger = 11;
        else hunger = hunger + h;
    }
    @Override
    public void move(){
        System.out.println("move successful (Hobbit)");
    }

    @Override
    public void attack(Creature c){
        System.out.println("attack successful (Hobbit)");
    }

    @Override
    public Creature replicate(){
        Creature hobbit = new Hobbit();
        System.out.println("replication successful");
        return hobbit;
    }

    @Override
    public void stay(){
        System.out.println("Stay successful (Hobbit)");
    }
    
    @Override
    public void chooseAction(){
        System.out.println("chooseAction successful (Hobbit)");
    }

    @Override
    public void color(){
        System.out.println("color successful (Hobbit)");
    }

    @Override
    public boolean equipable(){
        return true;
    }

    @Override
    public String toString(){
        return "Hobbit has " + health +" health, " + attack + " attack, " + hunger + " hunger";
    }
}