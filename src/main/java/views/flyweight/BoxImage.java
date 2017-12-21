package views.flyweight;

import javafx.scene.image.Image;
import views.DynamicLinkage.Flyweight;

public class BoxImage implements Flyweight {
    private static Image box;

    static {
        box = new Image(BombImage.class.getResourceAsStream("/images/RegularMode/mazeObjects/box.png"));
    }

    public static Image getImage(){
        return box;
    }

    @Override
    public void load(final Image image) {
        this.box = image;
    }
}
