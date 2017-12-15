package models.charcter;

import javafx.scene.image.Image;
import models.facade.ControlTower;

import java.awt.Point;
import java.util.ArrayList;

public class Player extends Person implements PlayerObserver {
    ArrayList<PlayerObserver> playerObservers;
    public Player(final ControlTower controlTower) {
        super(controlTower);
    }

    @Override
    public void setPosition(final int x, final int y) {
        if(controlTower.grantPermission(this,new Point(x,y))){
            super.setPosition(x, y);
        }
    }

    @Override
    public Image getImage() {
        return state.getImage();
    }

    public void registerObserver(PlayerObserver observer) {
        playerObservers.add(observer);
    }

    public void removeObserver(PlayerObserver observer) {
        playerObservers.remove(observer);
    }

    @Override
    public void notifyAboutHealth(int effect) {
        for (PlayerObserver observer : playerObservers) {
            observer.notifyAboutHealth(effect);
        }
    }

    @Override
    public void notifyAboutAmmo(int effect) {
        for (PlayerObserver observer : playerObservers) {
            observer.notifyAboutAmmo(effect);
        }
    }

    @Override
    public void notifyAboutLives(int effect) {
        for (PlayerObserver observer : playerObservers) {
            observer.notifyAboutLives(effect);
        }
    }

    @Override
    public boolean affectHealthBy(int effect) {
        notifyAboutHealth(effect);
        return super.affectHealthBy(effect);
    }

    @Override
    public boolean affectAmmo(int effect) {
        notifyAboutAmmo(effect);
        return super.affectAmmo(effect);
    }
}
