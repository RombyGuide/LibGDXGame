package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank {
    private MyGdxGame game;
    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private float angle;

    public Tank(MyGdxGame game) {
        this.game = game;
        this.texture = new Texture("1.png");
        this.x = 0.0f;
        this.y = 0.0f;
        this.speed = 100.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 16, y - 19.5f, 16, 19.5f, 32, 32,
                1, 1, angle, 0, 0, 32, 32, false, false);
    }

    public void update(float dt) {
        checkMoment(dt);
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            fire();
        }
    }

    public void checkMoment(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed * dt;
            angle = 270.0f;

        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * dt;
            angle = 90.0f;

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += speed * dt;
            angle = 0.0f;

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= speed * dt;
            angle = 180.0f;
        }
    }

    public void fire() {
        if (!game.getBullet().isActive()) {
            float angleRad = (float) Math.toRadians(angle);
            game.getBullet().activate(x, y, 500.0f * (float) Math.sin(angleRad), 500.0f * (float) Math.cos(angleRad));
        }
    }
}
