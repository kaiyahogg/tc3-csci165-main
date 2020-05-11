public class Map {
    static Creature[][] world = new Creature[500][500];
    //ArrayList<Integer> locationPoint = new ArrayList<Integer>();
    //private int x;
    //private int y;

    public Map(){
        spawn(world);
        for(Creature[] f : Map.world){
            for(Creature c : f){
                if(c != null){
                   c.chooseAction();
                   break;
                }
                
            }
        }
    }

    public void start(){
        for(Creature[] f : Map.world){
            for(Creature c : f){
                if(c != null){
                   c.chooseAction();
                   //break;
                }
                
            }
        }
    }
    
    static public void locationOf(Creature c){
        for(int x = 0; x < 500; x++){
            for(int y = 0; y < 500; y++){
                if(world[x][y] != null){
                    if(world[x][y] == c){
                        c.locationPoint[0] = x;
                        c.locationPoint[1] = y;
                    }
                }
            }
        }
    }
    
    private int randomInt(){
        int random = (int)Math.floor((Math.random()*48)+1);
        random *= 10;
        return random;
    }

    public void spawn(){
        world[250][250] = new Hobbit();
        world[260][250] = new Nazgul();
    }

    public void spawn(Creature[][] world){
        Creature hobbit1 = new Hobbit();
        Creature hobbit2 = new Hobbit();
        Creature hobbit3 = new Hobbit();
        Creature hobbit4 = new Hobbit();
        Creature hobbit5 = new Hobbit();
        Creature hobbit6 = new Hobbit();

        Creature food1 = new Vegetation();
        Creature food2 = new Vegetation();
        Creature food3 = new Vegetation();
        Creature food4 = new Vegetation();
        Creature food5 = new Vegetation();
        Creature food6 = new Vegetation();
        Creature food7 = new Vegetation();
        Creature food8 = new Vegetation();
        Creature food9 = new Vegetation();
        Creature food10 = new Vegetation();
        Creature food11 = new Vegetation();
        Creature food12 = new Vegetation();
        Creature food13 = new Vegetation();
        Creature food14 = new Vegetation();
        Creature food15 = new Vegetation();
        Creature food16 = new Vegetation();

        Creature nazgul1 = new Nazgul();
        Creature nazgul2 = new Nazgul();
        Creature nazgul3 = new Nazgul();
        Creature nazgul4 = new Nazgul();

        Creature sauron = new Sauron();
        
        world[randomInt()][randomInt()] = hobbit1;
        world[randomInt()][randomInt()] = hobbit2;
        world[randomInt()][randomInt()] = hobbit3;
        world[randomInt()][randomInt()] = hobbit4;
        world[randomInt()][randomInt()] = hobbit5;
        world[randomInt()][randomInt()] = hobbit6;
        
        world[randomInt()][randomInt()] = food1;
        world[randomInt()][randomInt()] = food2;
        world[randomInt()][randomInt()] = food3;
        world[randomInt()][randomInt()] = food4;
        world[randomInt()][randomInt()] = food5;
        world[randomInt()][randomInt()] = food6;
        world[randomInt()][randomInt()] = food7;
        world[randomInt()][randomInt()] = food8;
        world[randomInt()][randomInt()] = food9;
        world[randomInt()][randomInt()] = food10;
        world[randomInt()][randomInt()] = food11;
        world[randomInt()][randomInt()] = food12;
        world[randomInt()][randomInt()] = food13;
        world[randomInt()][randomInt()] = food14;
        world[randomInt()][randomInt()] = food15;
        world[randomInt()][randomInt()] = food16;

        world[randomInt()][randomInt()] = nazgul1;
        world[randomInt()][randomInt()] = nazgul2;
        world[randomInt()][randomInt()] = nazgul3;
        world[randomInt()][randomInt()] = nazgul4;
        
        hobbit1.setHunger(16);
        hobbit1.equip(new Weapon());
        hobbit2.equip(new Armor());
        hobbit3.equip(new Weapon()); hobbit3.equip(new Armor());
        world[250][250] = sauron;
    }

    public Creature[][] getWorld(){
        return world;
    }
}