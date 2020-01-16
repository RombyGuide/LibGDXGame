package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Texture texture;
    private Vector2 position2;
    private Vector2 velocity;
    private boolean active;
    private float speed;

    public boolean isActive() {
        return active;
    }

    public Bullet() {
        texture = new Texture("2.png");
        position2 = new Vector2();
        velocity = new Vector2();
        this.position2.x = 0.0f;
        this.position2.y = 0.0f;
        this.velocity.x = 0.0f;
        this.position2.y = 0.0f;
        this.speed = 100.0f;
        this.active = false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position2.x - 4.0f, position2.y - 4.0f);
    }

    public void activate(float x, float y, float vx, float vy) {
        this.active = true;
        this.position2.x = x;
        this.position2.y = y;
        this.velocity.x = vx;
        this.velocity.y = vy;
    }

    public void deActivate() {
        active = false;
    }

    public void update(float dt) {
       position2.mulAdd(velocity, dt);
        if (position2.x < 0.0f || position2.x > 1280.0f || position2.y < 0.0f || position2.y > 720.0f ) {
            deActivate();
        }
    }
}
