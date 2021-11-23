package asabai01.hw3;

public class Ant extends Item {
    private boolean isHoldingWood;
    private int id;


    public Ant(int x, int y, int id) {
        super(x, y, "ö");
        this.isHoldingWood = false;
        this.id = id;
    }



    public boolean isHoldingWood() {
        return isHoldingWood;
    }

    public void grabWood() {
        this.isHoldingWood = true;
    }

    public void releaseWood() {
        this.isHoldingWood = false;
    }


    public String printAnt() {
        StringBuilder printMessage;
        printMessage = new StringBuilder();
        printMessage.append("Ant ").append(getId()).append(" is at ").append(getX()).append(" ").append(getY()).append(" and it's ");
        if (!isHoldingWood) {
            printMessage.append("not ");
        }
        printMessage.append("holding wood.\n");
        return String.valueOf(printMessage);
    }

    public int getId() {
        return id;
    }
}
