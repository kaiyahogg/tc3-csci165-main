public interface Creature{

    public int getHealth();

    public int getAttack();

    public int getHunger();

    public void setHealth(int h);

    public void setAttack(int a);

    public void setHunger(int h);

    public void move();

    public void attack(Creature c);

    public Creature replicate();

    public void stay();

    //Decision map needs implementation
    public void chooseAction();

    //Color needs proper implementation
    public void color();

    public boolean equipable();
}