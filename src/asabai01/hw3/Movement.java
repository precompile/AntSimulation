package asabai01.hw3;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final Board board;
    private final List <Ant> Ants;
    private final List <Wood> Woods;
    private final List <Item> Items;

    public Movement(Board board, List <Ant> ants, List <Wood> woods) {
        this.board = board;
        this.Ants = ants;
        this.Woods = woods;
        Items = new ArrayList <>();
        Items.addAll(Ants);
        Items.addAll(Woods);
    }


    /**
     * The game makes a step. That can either be an ant moving to any direction,
     * grabbing wood, or releasing on top of other wood.
     */
    public void step() {
        displayBoard();
        System.out.println("Movement:");
        //For every ant.
        for (Ant ant : Ants) {

            //For every wood.
            for (Wood wood : Woods) {

                //If the ant is holding wood.
                if (ant.isHoldingWood()) {
                    //If the ant is on top of wood.
                    if (ant.getX() == wood.getX() && ant.getY() == wood.getY()) {
                        //If the ant is on top of a default generated wood, it moves with the wood somewhere else.
                        if (ant.getX() == wood.getInitialX() && ant.getY() == wood.getInitialY()) {
                            moveWithWood(ant, wood);
                            System.out.println(ant.printAnt());
                        } else { //If the ant is holding wood and its above other wood, it releases it on top.
                            ant.releaseWood();
                            System.out.println("Ant " + ant.getId() + " released wood at " + ant.getX() + " " + ant.getY() + "\n");
                        }
                    } else { //If the ant is holding wood but not above other wood, it moves while holding wood.
                        moveWithWood(ant, wood);
                        System.out.println(ant.printAnt());
                    }
                } else { //Else if the ant is not holding wood.
                    //If the ant is on top of a default generated wood, it grabs the wood.
                    if (ant.getX() == wood.getInitialX() && ant.getY() == wood.getInitialY()) {
                        ant.grabWood();
                        System.out.println("Ant " + ant.getId() + " grabbed wood at " + ant.getX() + " " + ant.getY() + "\n");
                    } else { //Else if the ant is not holding wood, it moves.
                        moveAnt(ant);
                        System.out.println(ant.printAnt());
                    }

                }
                break;

            }

        }

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Algorithm that moves the ant.
     * Different outcomes:
     * Up, Down, Left or Right
     *
     * @param ant ant
     */
    private void moveAnt(Ant ant) {
        boolean antMoved = false;

        while (!antMoved) {
            int randomStep = (int) (Math.random() * 4);
            switch (randomStep) {
                case 0:
                    if (ant.getY() == board.getSizeY() - 1) {
                        break;
                    } else {
                        ant.moveUp();
                        antMoved = true;
                    }
                    break;
                case 1:
                    if (ant.getY() == 0) {
                        break;
                    } else {
                        ant.moveDown();
                        antMoved = true;
                    }
                    break;
                case 2:
                    if (ant.getX() == board.getSizeX() - 1) {
                        break;
                    } else {
                        ant.moveRight();
                        antMoved = true;
                    }
                    break;
                case 3:
                    if (ant.getX() == 0) {
                        break;
                    } else {
                        ant.moveLeft();
                        antMoved = true;
                    }
                    break;
            }
        }

    }

    /**
     * Algorithm that moves the ant with the wood.
     * Different outcomes:
     * Up, Down, Left or Right
     *
     * @param ant  ant
     * @param wood wood
     */
    private void moveWithWood(Ant ant, Wood wood) {
        boolean antMovedWithWood = false;

        while (!antMovedWithWood) {
            int randomStepWood = (int) (Math.random() * 4);
            switch (randomStepWood) {
                case 0:
                    if (ant.getY() == board.getSizeY() - 1) {
                        break;
                    } else {
                        ant.moveUp();
                        wood.moveUp();
                        antMovedWithWood = true;
                    }
                    break;
                case 1:
                    if (ant.getY() == 0) {
                        break;
                    } else {
                        ant.moveDown();
                        wood.moveDown();
                        antMovedWithWood = true;
                    }
                    break;
                case 2:
                    if (ant.getX() == board.getSizeX() - 1) {
                        break;

                    } else {
                        ant.moveRight();
                        wood.moveRight();
                        antMovedWithWood = true;
                    }
                    break;
                case 3:
                    if (ant.getX() == 0) {
                        break;
                    } else {
                        ant.moveLeft();
                        wood.moveLeft();
                        antMovedWithWood = true;
                    }
                    break;
            }
        }

    }

    /**
     * Method that displays the board in a 2D Char board.
     * Ant is represented with 'ö'
     * Wood is represented with '='
     * and an empty space is represented with a '.'
     */
    public void displayBoard() {
        boolean printed = false;
        for (int i = 0; i < board.getSizeX(); i++) {
            for (int j = 0; j < board.getSizeY(); j++) {
                for (Item item : Items) {
                    if (item.getX() == i && item.getY() == j) {
                        System.out.print(item.getCharacter() + " ");
                        printed = true;
                        break;
                    }
                }
                if (!printed) {
                    System.out.print(". ");
                }
                printed = false;
            }
            System.out.println();
        }
        System.out.println("\n");
    }


}
