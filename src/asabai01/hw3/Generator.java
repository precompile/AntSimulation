package asabai01.hw3;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private final Board board = new Board(AntSimulation.getSizeX(), AntSimulation.getSizeY());
    private List <Integer> antWithPos = new ArrayList <>();
    private List <Integer> woodWithPos = new ArrayList <>();


    /**
     * Gets a random position for the ant.
     *
     * @return Returns the X Y position for an ant.
     */
    private List <Integer> getRandomAntPos() {
        this.antWithPos = new ArrayList <>();
        int randX = getRandom(board.getSizeX());
        int randY = getRandom(board.getSizeY());

        antWithPos.add(randX);
        antWithPos.add(randY);

        return antWithPos;
    }

    /**
     * Gets a random position for the wood.
     *
     * @return Returns the X Y position for a wood.
     */
    private List <Integer> getRandomWoodPos() {
        this.woodWithPos = new ArrayList <>();
        int randX = getRandom(board.getSizeX());
        int randY = getRandom(board.getSizeY());

        woodWithPos.add(randX);
        woodWithPos.add(randY);

        return woodWithPos;
    }

    /**
     * Ant generator.
     *
     * @param id ID of specific ant.
     * @return Returns Ant
     */
    public Ant generateAnt(int id) {
        Ant ant;
        antWithPos = getRandomAntPos();

        int x = antWithPos.get(0);
        int y = antWithPos.get(1);

        ant = new Ant(x, y, id);
        board.placeAnt(ant);

        return ant;
    }

    /**
     * Wood generator.
     *
     * @return Returns Wood.
     */
    public Wood generateWood() {
        Wood wood;
        woodWithPos = getRandomWoodPos();

        int x = woodWithPos.get(0);
        int y = woodWithPos.get(1);

        wood = new Wood(x, y);
        board.placeWood(wood);
        return wood;
    }

    /**
     * Gets a random number from 0 to max value accordingly.
     */
    private int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    /**
     * Gets the generated board.
     *
     * @return Returns the board.
     */
    public Board getBoard() {
        return board;
    }

}
