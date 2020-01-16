package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    private Texture texture;
    private float x;
    private float y;
    private float vx;
    private float vy;
    private boolean active;
    private float speed;

    public boolean isActive() {
        return active;
    }

    public Bullet() {
        texture = new Texture("2.png");
        this.x = 0.0f;
        this.y = 0.0f;
        this.vx = 0.0f;
        this.vy = 0.0f;
        this.speed = 100.0f;
        this.active = false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 4.0f, y - 4.0f);
    }

    public void activate(float x, float y, float vx, float vy) {
        this.active = true;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void deActivate() {
        active = false;
    }

    public void update(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (x < 0.0f || x > 1280.0f || y < 0.0f || y > 720.0f ) {
            deActivate();
        }
    }
}
