import java.awt.*;
import java.util.*;

public abstract class Creature{
    ArrayList<Item> inventory = new ArrayList<Item>();
    int[] locationPoint = new int[2];

    public Creature(){}

    public int getRandom(){
        int random = (int)Math.floor((Math.random()*4)+1);
        return random;
    }

    public void equip(Item i){
        if(this.equipable() == true){
            this.setAttack(this.getAttack() + i.getAttackBuff());
            this.setHealth(this.getHealth() + i.getHealthBuff());
            this.setHunger(this.getHunger() + i.getHungerBuff());
            inventory.add(i);
        }
        else System.out.println("Creature cannot equip items");
    }

    public void moveUp(){
        Map.locationOf(this);
        int x = locationPoint[0];
        int y = locationPoint[1];
        Map.world[x][y] = null;
        Map.world[x][y-10] = this;
    }

    public void moveDown(){
        Map.locationOf(this);
        int x = locationPoint[0];
        int y = locationPoint[1];
        Map.world[x][y] = null;
        Map.world[x][y+10] = this;
    }
    
    public void moveRight(){
        Map.locationOf(this);
        int x = locationPoint[0];
        int y = locationPoint[1];
        Map.world[x][y] = null;
        Map.world[x+10][y] = this;
    }
    
    public void moveLeft(){
        Map.locationOf(this);
        int x = locationPoint[0];
        int y = locationPoint[1];
        Map.world[x][y] = null;
        Map.world[x-10][y] = this;
    }

    public void chooseReplication(){
        int rand = getRandom();
        Map.locationOf(this);
        int x = locationPoint[0]; int y = locationPoint[1];
        
        if(y>=10 && y<490 
            && x>=10 && x<490){ 
            if(rand == 1){ 
                replicateUp();
                //System.out.println("up");
            }
            else if(rand == 2){ 
                replicateDown();
                //System.out.println("down");
            }

            else if(rand == 3){ 
                replicateRight();
                //System.out.println("right");
            }
            else{ 
                replicateLeft();
                //System.out.println("left");
            }
        }
       
    }

    public abstract void chooseMove();

    public abstract int getHealth();

    public abstract int getAttack();

    public abstract int getHunger();

    public abstract void setHealth(int h);

    public abstract void setAttack(int a);

    public abstract void setHunger(int h);

    public abstract void attack(Creature c);

    public abstract void replicateUp();

    public abstract void replicateDown();

    public abstract void replicateRight();

    public abstract void replicateLeft();

    public abstract void stay();

    public abstract void chooseAction();

    public abstract Color color();

    public abstract boolean equipable();
}