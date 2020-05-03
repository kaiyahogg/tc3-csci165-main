
public class Food extends Item{

    private int attackBuff;
    private int healthBuff;
    private int hungerBuff;

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
    public void setAttackBuff(int attackB){
        attackBuff = getAttackBuff();
    }

    @Override
    public void setHealthBuff(int healthB){
        healthBuff = getAttackBuff();
    }

    @Override
    public void setHungerBuff(int healthB){
        hungerBuff = getHungerBuff() + 3;
    }
}