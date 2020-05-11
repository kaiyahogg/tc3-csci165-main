import java.awt.*;
public class Sauron extends Creature{

    /*
        Spawns at seeding. Gets hungry and devours
        all of Middle-Earth the following turn.
    */

    //Values should be absurd, could be defeated if hobbits get ahold of certain items
    private int health = 10000;
    private int attack = 10000;
    private int hunger = 30;

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
        Map.locationOf(this);
        int x = locationPoint[0]; int y = locationPoint[1];
        if(hunger <= 0) health = 0;
        if(health <= 0) Map.world[x][y] = null;
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
    public void attack(Creature c){
        //System.out.println("attack successful (Sauron)");
        c.setHealth(c.getHealth()-this.attack);
        //setHealth(this.health - c.getAttack());
    }

    @Override
    public void replicateUp(){}
    
    @Override
    public void replicateDown(){}
    
    @Override
    public void replicateRight(){}
    
    @Override
    public void replicateLeft(){}

    @Override
    public void stay(){
        //System.out.println("stay successful (Sauron)");
    }

    @Override
    public void chooseMove(){}

    @Override
    public void chooseAction(){
        //System.out.println("chooseAction successful (Sauron)");
        if(hunger == 0){
            for(int x = 10; x < 490; x++){
                for(int y = 10; y < 490; y++){
                    if(Map.world[x][y] != null){
                        if(Map.world[x][y] instanceof Sauron == false){
                            attack(Map.world[x][y]);
                        }
                    }
                }
            }
        }
        else hunger--;
    }

    @Override
    public Color color(){
        //System.out.println("Color succesful (Sauron)");
        if (health/100 > 0.67) return Color.BLACK;
        else if (health/100>0.33) return Color.YELLOW;
        else if (health/100>0) return Color.RED;
        else return Color.BLACK;
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