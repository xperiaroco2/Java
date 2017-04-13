import java.awt.*;

/**
 * Created by h on 02.04.2017.
 */
public abstract class Field {
    int count;
    int number;
    String type;
    String name;
    int x;
    int y;
    boolean isPurchased = false;
    int width;
    int height;
    boolean Purchasedable = true;
    public int rent = 0;
    Player whoseProperty = null;
    int houseCount = 0;
    int houseCost = 0;

    abstract void draw(Graphics2D g);

}
