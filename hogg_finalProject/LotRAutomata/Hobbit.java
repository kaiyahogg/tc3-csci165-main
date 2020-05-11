import java.awt.*;

public class Hobbit extends Creature{

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
        Map.locationOf(this);
        int x = locationPoint[0]; int y = locationPoint[1];
        //if(hunger<=0) health = 0;
        if(health <= 0) Map.world[x][y] = null;
    }
     @Override
    public void setAttack(int a){
        attack = a;
    }

    @Override
    public void setHunger(int h){
        hunger = h;
        //if(hunger > 11) hunger = 11;
    }

    @Override
    public void attack(Creature c){
        System.out.println("attack successful (Hobbit)");
        c.setHealth(c.getHealth()-this.attack);
        setHealth(this.health - c.getAttack());
        if(c instanceof Vegetation) c.equip(new Food()); 
    }

    @Override
    public void replicateUp(){
        Creature h = new Hobbit();
        Map.locationOf(this);
        
        if(locationPoint[1]>=10){
            Creature up = Map.world[locationPoint[0]][locationPoint[1]-10];
            if(up == null){
                //Up
                Map.world[locationPoint[0]][locationPoint[1]-10] = h;
            }
        }
    }

    @Override
    public void replicateDown(){
        Creature h = new Hobbit();
        Map.locationOf(this);
        
        if(locationPoint[1]<490){
            Creature down = Map.world[locationPoint[0]][locationPoint[1]+10];
            if(down == null){
                //Down
                Map.world[locationPoint[0]][locationPoint[1]+10] = h;
            }
        }
    }

    @Override
    public void replicateRight(){
        Creature h = new Hobbit();
        Map.locationOf(this);
        
        if(locationPoint[0]>=10){
            Creature right = Map.world[locationPoint[0]+10][locationPoint[1]];
            if(right == null){
                //Right
                Map.world[locationPoint[0]+10][locationPoint[1]] = h;
            }
        }
    }

    @Override
    public void replicateLeft(){
        Creature h = new Hobbit();
        Map.locationOf(this);
        
        if(locationPoint[0]<490){
            Creature left = Map.world[locationPoint[0]-10][locationPoint[1]];
            if(left == null){
                //Left
                Map.world[locationPoint[0]-10][locationPoint[1]] = h;
            }
        }
    }


    @Override
    public void stay(){
        //System.out.println("Stay successful (Hobbit)");
        this.equip(new Food());
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
        System.out.println("chooseAction successful (Hobbit)");
        Map.locationOf(this);
        int x = locationPoint[0]; int y = locationPoint[1];

        if(y>=10 && y<490 
            && x>=10 && x<490){ 
            
            Map.locationOf(Map.world[x][y-10]);
            Map.locationOf(Map.world[x][y+10]);
            Map.locationOf(Map.world[x+10][y]);
            Map.locationOf(Map.world[x-10][y]);

            if(hunger <= 11){
                if(Map.world[x][y-10] instanceof Nazgul){
                    moveDown();
                    hunger--;
                    if(hunger <= 0) setHealth(0);
                }
                else if(Map.world[x][y+10] instanceof Nazgul){
                    moveUp();
                    hunger--;
                    if(hunger <= 0) setHealth(0);
                }
                else if(Map.world[x+10][y] instanceof Nazgul){
                    moveLeft();
                    hunger--;
                    if(hunger <= 0) setHealth(0);
                }
                else if(Map.world[x-10][y] instanceof Nazgul){ 
                    moveRight();
                    hunger--;
                    if(hunger <= 0) setHealth(0);
                }
                else if(Map.world[x][y-10] instanceof Vegetation){
                    moveUp();
                    attack(Map.world[x][y-10]);
                    equip(new Food());
                   
                }
                else if(Map.world[x][y+10] instanceof Vegetation){
                    moveDown();
                    attack(Map.world[x][y+10]);
                    equip(new Food());
                    
                }
                else if(Map.world[x+10][y] instanceof Vegetation){
                    moveLeft();
                    attack(Map.world[x+10][y]);
                    equip(new Food());
                    
                }
                else if(Map.world[x-10][y] instanceof Vegetation){ 
                    moveRight();
                    attack(Map.world[x-10][y]);
                    equip(new Food());
                    
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
        
        else stay();
            
    }

    @Override
    public Color color(){
        System.out.println("color successful (Hobbit)");

        if (health > 67) return Color.BLUE;
        if (health > 33) return Color.YELLOW;
        if (health > 0) return Color.RED;
        else return Color.BLACK;
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