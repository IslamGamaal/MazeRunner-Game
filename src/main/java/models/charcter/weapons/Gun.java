package models.charcter.weapons;

import models.charcter.weapons.bullets.Bullet;
import models.charcter.weapons.bullets.BulletPool;

import java.awt.*;
import java.util.Properties;

import static javafx.scene.input.KeyCode.X;
import static models.charcter.weapons.bullets.BulletPool.*;

public class Gun implements Weapon {

    private static final int MAXIMUM_AMMO = 6;
    private static final Properties properties = new Properties();


    static {
        properties.put(DAMAGE_RATE,10);
        properties.put(LIFETIME,3000);
        properties.put(VELOCITY,50);
        properties.put(ACCELERATION,0);
    }

    private Point position;
    private int velocity;
    private int acceleration;
    private int currentAmmo;

    public Gun() {
        currentAmmo = MAXIMUM_AMMO;
    }

    @Override
    public int getMaximumAmmo() {
        return MAXIMUM_AMMO;
    }

    @Override
    public int getRemainingAmmo() {
        return currentAmmo;
    }

    @Override
    public Bullet Shoot() throws NoRemainingAmmoException {
        if (currentAmmo == 0) throw new NoRemainingAmmoException();
        Bullet bullet = BulletPool.getInstance().checkOut(properties);
        bullet.setPosition(position.x,position.y);
        return bullet;
    }

    @Override
    public void setPosition(final int x, final int y) {
        position.x = x;
        position.y = y;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public int getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(final int velocity) {

        this.velocity = velocity;
    }

    @Override
    public int getAcceleration() {
        return acceleration;
    }

    @Override
    public void setAcceleration(final int acceleration) {

        this.acceleration = acceleration;
    }
}