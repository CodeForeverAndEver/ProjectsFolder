import processing.core.PApplet;

public class BounceLogo {
    private PApplet sketch;

    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float width;
    private float height;
    private String text;
    private int[] color = new int[3];

    public BounceLogo(PApplet sketch, float x, float y, float xSpeed, float ySpeed, float width, float height, String text) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.width = width;
        this.height = height;
        this.text = text;
        changeColor();
    }

    public void step() {
        x += xSpeed;
        y += ySpeed;
        if (PhysicsCalculator.isBeyondBoundaries(x, width / 2, sketch.width)) {
            xSpeed *= -1;
            changeColor();
        }
        if (PhysicsCalculator.isBeyondBoundaries(y, height / 2, sketch.height)) {
            ySpeed *= -1;
            changeColor();
        }
    }

    private void changeColor() {
        for (int i = 0; i < 3; i++) {
            this.color[i] = (int) sketch.random(255);
        }
    }

    public void render() {
        sketch.fill(color[0], color[1], color[2]);
        sketch.rect(x, y, width, height);
        sketch.fill(255);
        sketch.textSize(32);
        sketch.text(text, x, y);
    }

}
