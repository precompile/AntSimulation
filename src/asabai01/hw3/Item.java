package asabai01.hw3;


public class Item {
    private int x, y;
    private String character;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
        this.character = ".";
    }

    public Item(int x, int y, String character) {
        this(x,y);
        this.character = character;
    }

    public void moveUp() {
        int y = this.getY() + 1;
        this.setY(y);
    }

    public void moveDown() {
       int y = this.getY() - 1;
       this.setY(y);
    }

    public void moveRight() {
        int x = this.getX() + 1;
        this.setX(x);
    }

    public void moveLeft() {
        int x = this.getX() - 1;
        this.setX(x);
    }




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public String getCharacter() {
        return character;
    }



    public enum Type{
        ANT,
        WOOD
    }
}
