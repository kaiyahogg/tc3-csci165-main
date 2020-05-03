
public class Weapon extends Item{

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
        attackBuff = getAttackBuff() + 50;
    }

    @Override
    public void setHealthBuff(int healthB){
        healthBuff = getAttackBuff();
    }

    @Override
    public void setHungerBuff(int hungerB){
        hungerBuff = getHungerBuff();
    }
}