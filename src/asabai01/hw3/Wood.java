package asabai01.hw3;

public class Wood extends Item {
    private final int initialX, initialY;
    private String character;

    public Wood(int x, int y) {
        super(x, y, "=");
        initialX = x;
        initialY = y;
    }


    public int getInitialX() {
        return initialX;
    }

    public int getInitialY() {
        return initialY;
    }

}
