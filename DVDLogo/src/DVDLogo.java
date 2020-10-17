import processing.core.PApplet;

public class DVDLogo extends PApplet {
    private BounceLogo bounceLogo;

    public void settings() {
        size(1920 / 2, 1080 / 2);

        int logoWidth = 350;
        int logoHeight = 350;

        bounceLogo = new BounceLogo(this,
                logoWidth / 2,
                logoHeight / 2,
                5,
                5,
                logoWidth,
                logoHeight,
                "Text");
    }

    public void draw() {
        background(0);
        rectMode(CENTER);
        textAlign(CENTER);
        bounceLogo.step();
        bounceLogo.render();
    }

    public static void main(String[] args) {
        String[] processingArgs = {"DVDLogo"};
        DVDLogo dvdLogo = new DVDLogo();
        PApplet.runSketch(processingArgs, dvdLogo);
    }
}
