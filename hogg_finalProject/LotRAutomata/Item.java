import java.awt.*;
public abstract class Item {

    public Color color(){
        return new Color(255,215,0);
    }

    public abstract int getAttackBuff();
        
    public abstract int getHealthBuff();

    public abstract int getHungerBuff();

}