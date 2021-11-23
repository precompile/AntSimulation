package asabai01.hw3;

public class Board {
    private final int sizeX;
    private final int sizeY;
    private Item[][] board;


    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        fillBoard();
    }

    private void fillBoard() {
        board = new Item[ sizeX ][ sizeY ];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                board[ i ][ j ] = new Item(i, j);
            }
        }
    }


    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }


    public void placeAnt(Ant ant) {
        board[ ant.getX() ][ ant.getY() ] = new Ant(ant.getX(), ant.getY(), ant.getId());
    }

    public void placeWood(Wood wood){
        board[ wood.getX() ][ wood.getY()] = new Wood(wood.getX(), wood.getY());
    }




    public void resetBoard() {
        fillBoard();
    }
}
