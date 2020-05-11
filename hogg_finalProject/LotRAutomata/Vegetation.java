import java.awt.*;
public class Vegetation extends Creature{

    /*
        Multiple spawn at beginning of game, replicates often. Drops an item when killed and equips it to the hobbit. 
    */

    //Values should let unequipped hobbits harvest
    private int health = 1;
    private int attack;
    private int hunger = 15;

    public Vegetation(){
        Map.locationOf(this);
    }

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
        return 0;
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
        //if(hunger<=0) health = 0;
        if(health <= 0) Map.world[x][y] = null;
    }

    @Override
    public void setAttack(int a){
        attack = 0;
    }

    @Override
    public void setHunger(int h){
        hunger = 10000;
    }

    @Override
    public void attack(Creature c){
        //System.out.println("attack successful (Vegetation)");
    }

    @Override
    public void replicateUp(){
        Creature v = new Vegetation();
        Map.locationOf(this);
        
        if(locationPoint[1]>=10){
            Creature up = Map.world[locationPoint[0]][locationPoint[1]-10];
            if(up == null){
                //Up
                Map.world[locationPoint[0]][locationPoint[1]-10] = v;
            }
        }
    }

    @Override
    public void replicateDown(){
        Creature v = new Vegetation();
        Map.locationOf(this);
        
        if(locationPoint[1]<490){
            Creature down = Map.world[locationPoint[0]][locationPoint[1]+10];
            if(down == null){
                //Down
                Map.world[locationPoint[0]][locationPoint[1]+10] = v;
            }
        }
    }

    @Override
    public void replicateRight(){
        Creature v = new Vegetation();
        Map.locationOf(this);
        
        if(locationPoint[0]<490){
            Creature right = Map.world[locationPoint[0]+10][locationPoint[1]];
            if(right == null){
                //Right
                Map.world[locationPoint[0]+10][locationPoint[1]] = v;
            }
        }
    }

    @Override
    public void replicateLeft(){
        Creature v = new Vegetation();
        Map.locationOf(this);
        
        if(locationPoint[0]>=10){
            Creature left = Map.world[locationPoint[0]-10][locationPoint[1]];
            if(left == null){
                //Left
                Map.world[locationPoint[0]-10][locationPoint[1]] = v;
            }
        }
    }

    @Override
    public void stay(){
        //System.out.println("stay successful (Vegetation)");
    }

    @Override
    public void chooseMove() {}
    
    @Override
    public void chooseAction(){
        //System.out.println("chooseAction successful (Vegetation)");
        Map.locationOf(this);
        if(locationPoint[1]>=10 
            && locationPoint[1]<490 
            && locationPoint[0]>=10 
            && locationPoint[0]<490){
            if(hunger>5){
                chooseReplication();
                hunger += -5;
                if(hunger <= 0) setHealth(0);
            }
        }
        else stay();
    }

    @Override
    public Color color(){
        //System.out.println("Color succesful (Vegetation)");
        if (health/1 > 0.67) return Color.GREEN;
        else if (health/1>0.33) return Color.YELLOW;
        else if (health/1>0) return Color.RED;
        else return Color.BLACK;
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
