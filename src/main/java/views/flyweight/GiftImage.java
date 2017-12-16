package views.flyweight;

import javafx.scene.image.Image;

public class GiftImage {
    private static final Image image;

    static {
        image = new Image(GiftImage.class.getResourceAsStream("/images/RegularMode/mazeObjeccts/bomb"));
    }

    public static Image getImage() {
        return image;
    }

}
