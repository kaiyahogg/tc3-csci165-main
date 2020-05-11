import java.awt.*;
public class Nazgul extends Creature{

    private int health = 200;
    private int attack = 50;
    private int hunger = 20;

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
        Map.locationOf(this);
        int x = locationPoint[0]; int y = locationPoint[1];
        if(hunger<=0) health = 0;
        if(health <= 0) Map.world[x][y] = null;
    }

    @Override
    public void setAttack(int a){
        attack = a;
    }

    @Override
    public void setHunger(int h){
        hunger = hunger + h;
    }

    //Should add to hunger value
    @Override
    public void attack(Creature c){
        System.out.println("attack successful (Nazgul)");
        if(c instanceof Vegetation){
            c.equip(new Food());
            c.setHealth(c.getHealth()-this.attack);
        }
        else{
            c.setHealth(c.getHealth()-this.attack);
            setHealth(this.health - c.getAttack());
            equip(new Food());
        }
    }


    @Override
    public void replicateUp(){
        Creature n = new Nazgul();
        Map.locationOf(this);
        
        if(locationPoint[1]>=20){
            Creature up = Map.world[locationPoint[0]][locationPoint[1]-10];
            if(up == null){
                //Up
                Map.world[locationPoint[0]][locationPoint[1]-10] = n;
            }
        }
    }

    @Override
    public void replicateDown(){
        Creature n = new Nazgul();
        Map.locationOf(this);
        
        if(locationPoint[1]<480){
            Creature down = Map.world[locationPoint[0]][locationPoint[1]+10];
            if(down == null){
                //Down
                Map.world[locationPoint[0]][locationPoint[1]+10] = n;
            }
        }
    }

    @Override
    public void replicateRight(){
        Creature n = new Nazgul();
        Map.locationOf(this);
        
        if(locationPoint[0]>=20){
            Creature right = Map.world[locationPoint[0]+10][locationPoint[1]];
            if(right == null){
                //Right
                Map.world[locationPoint[0]+10][locationPoint[1]] = n;
            }
        }
    }

    @Override
    public void replicateLeft(){
        Creature n = new Nazgul();
        Map.locationOf(this);
        
        if(locationPoint[0]>=20){
            Creature left = Map.world[locationPoint[0]-10][locationPoint[1]];
            if(left == null){
                //Left
                Map.world[locationPoint[0]-10][locationPoint[1]] = n;
            }
        }
    }

    @Override
    public void stay(){
        //System.out.println("stay successful (Nazgul)");
    }
    
    @Override
    public void chooseMove(){
        int rand = getRandom();
        
        if(rand == 1){ 
            moveUp();
            System.out.println("up");
        }
        else if(rand == 2){ 
            moveDown();
            System.out.println("down");
        }

        else if(rand == 3){ 
            moveRight();
            System.out.println("right");
        }
        else{ 
            moveLeft();
            System.out.println("left");
        }
    }

    @Override
    public void chooseAction(){
        System.out.println("chooseAction successful (Nazgul)");
        Map.locationOf(this);
        int x = locationPoint[0]; int y = locationPoint[1];

        if(y>=20 && y<480 
            && x>=20 && x<480){ 

            Map.locationOf(Map.world[x][y-10]);
            Map.locationOf(Map.world[x][y+10]);
            Map.locationOf(Map.world[x+10][y]);
            Map.locationOf(Map.world[x-10][y]);

            if(hunger <= 20){
                if(Map.world[x][y-10] instanceof Hobbit || Map.world[x][y-10] instanceof Vegetation){
                    moveUp();
                    attack(Map.world[x][y-10]);
                    if(Map.world[x][y-10] instanceof Hobbit) hunger++;
                }
                else if(Map.world[x][y+10] instanceof Hobbit || Map.world[x][y+10] instanceof Vegetation){
                    moveDown();
                    attack(Map.world[x][y+10]);
                    if(Map.world[x][y+10] instanceof Hobbit) hunger++;
                }
                else if(Map.world[x+10][y] instanceof Hobbit || Map.world[x+10][y] instanceof Vegetation){
                    moveRight();
                    attack(Map.world[x+10][y]);
                    if(Map.world[x+10][y] instanceof Hobbit) hunger++;
                }
                else if(Map.world[x-10][y] instanceof Hobbit || Map.world[x-10][y] instanceof Vegetation){ 
                    moveLeft();
                    attack(Map.world[x-10][y]);
                    if(Map.world[x-10][y] instanceof Hobbit)hunger++;
                }
                else{ 
                    chooseMove();
                    hunger--;
                    if(hunger <= 0) setHealth(0);
                }
                
            }
            else{
                chooseReplication();
                hunger += -5;
            }
        }
        else{ 
            stay();
            hunger--;
        }
    }

    @Override
    public Color color(){
        System.out.println("Color successful (Nazgul)");
        if (health > 100) return Color.GRAY;
        else if (health > 50) return Color.ORANGE;
        else if (health > 0) return Color.RED;
        else return Color.BLACK;
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