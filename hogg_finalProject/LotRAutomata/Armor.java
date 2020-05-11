
public class Armor extends Item{

    private int attackBuff = 0;
    private int healthBuff = 50;
    private int hungerBuff = 0;

    @Override
    public int getAttackBuff(){
        return attackBuff;
    }

    @Override
    public int getHealthBuff(){
        return healthBuff;
    }

    @Override
    public int getHungerBuff(){
        return hungerBuff;
    }

    @Override
    public String toString(){
        return "Armor: " + healthBuff + " health";
    }
}