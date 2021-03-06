
public class Food extends Item{

    private int attackBuff = 0;
    private int healthBuff = 0;
    private int hungerBuff = 3;

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
        return "Food: " + hungerBuff + " food";
    }
}