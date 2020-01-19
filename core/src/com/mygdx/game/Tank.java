package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tank {
    private MyGdxGame game;
    private Texture texture;
    private Texture textureTurret;
    private Vector2 position;
    private float speed;
    private float angle;
    private float turretAngle;

    public Tank(MyGdxGame game) {
        this.game = game;
        this.position = new Vector2(100.0f, 100.0f);
        this.texture = new Texture("1.png");
        this.textureTurret = new Texture("3.png");
        this.speed = 100.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 12, position.y - 15, 12, 15, 25, 31,
                1, 1, angle, 0, 0, 25, 31, false, false);
        batch.draw(textureTurret, position.x + 3, position.y - 5, 0, 0, 30, 6,
               1, 1, turretAngle, 0, 0, 30, 6, false, false);
    }

    public void update(float dt) {
        checkMoment(dt);
        float mx = Gdx.input.getX();
        float my = Gdx.graphics.getHeight() - Gdx.input.getY();

        float angleTo = Utils.getAngle(position.x, position.y, mx, my);
        turretAngle = Utils.makeRotation(turretAngle, angleTo, 380.0f, dt);
        turretAngle = Utils.angleToFromNegPiToPosPi(turretAngle);

        if (Gdx.input.isTouched()) {
            fire();
        }
    }

    public void checkMoment(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= speed * dt;
            angle = 270.0f;

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += speed * dt;
            angle = 90.0f;

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += speed * dt;
            angle = 0.0f;

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= speed * dt;
            angle = 180.0f;
        }
    }

    public void fire() {
            float angleRad = (float) Math.toRadians(turretAngle - 90f);
            game.getBulletEmitter().activate(position.x, position.y, 500.0f * (float) Math.sin(angleRad), 500.0f * (float) Math.cos(angleRad));
    }
}
