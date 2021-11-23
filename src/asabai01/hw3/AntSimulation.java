package asabai01.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AntSimulation {
    private static int numOfAnts, numOfWood;
    private static int sizeX, sizeY;
    private static int maxSteps;
    private Board board;
    private List <Ant> Ants = new ArrayList <>();
    private List <Wood> Woods = new ArrayList <>();
    private int steps;


    public void runSimulation() {
        askUserInput();

        Generator generator = new Generator();

        //Generates Ants according to user input.
        for (int i = 0; i < numOfAnts; i++) {
            Ant ant = generator.generateAnt(i);
            Ants.add(ant);
        }

        //Generates Wood according to user input.
        for (int i = 0; i < numOfWood; i++) {
            Wood wood = generator.generateWood();
            Woods.add(wood);
        }

        //Gets the generated board.
        board = generator.getBoard();

        Movement movement = new Movement(board, Ants, Woods);
        while (steps != maxSteps) {

            System.out.println("Step " + steps);
            movement.step(maxSteps);
            steps++;
            board = movement.getBoard();


        }



        System.out.println("Do you want to add more steps? Y/N");
        Scanner scan = new Scanner(System.in);
        boolean addMoreSteps;
        char input = scan.next().charAt(0);
        input = Character.toUpperCase(input);
        while (input != 'Y' && input != 'N') {
            System.out.println("Invalid type.");
            System.out.println("Do you want to add more steps? Y/N");
            input = scan.next().charAt(0);
            input = Character.toUpperCase(input);
        }

        if (input == 'Y') {
            addMoreSteps = true;
        } else {
            addMoreSteps = false;
        }

        int moreSteps = 0;

        if (addMoreSteps) {
            Scanner scanInt = new Scanner(System.in);
            System.out.print("How many more steps to add: \n> ");
            moreSteps = scanInt.nextInt();
            while (moreSteps < 0) {
                System.out.println("Steps cannot be less than 0.");
                System.out.print("How many more steps to add: \n> ");
                moreSteps = scanInt.nextInt();
            }
        }

        board = movement.getBoard();

        steps = 0;
        while (steps != moreSteps) {

            System.out.println("Step " + steps);
            movement.step(maxSteps);
            steps++;
            board = movement.getBoard();

        }

    }



    private void askUserInput() {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Number of ants: \n> ");
        numOfAnts = scan.nextInt();
        while (numOfAnts <= 0){
            System.out.print("Ants cannot be less than or equal to 0. \n> ");
            numOfAnts = scan.nextInt();
        }

        System.out.print("Number of wood: \n> ");
        numOfWood = scan.nextInt();
        while (numOfWood <= 0){
            System.out.print("Woods cannot be less than or equal to 0. \n> ");
            numOfWood = scan.nextInt();
        }

        System.out.print("Board size X: \n> ");
        sizeX = scan.nextInt();
        while (sizeX <= 0){
            System.out.print("Border size cannot be less than or equal to 0. \nBoard size X: \n> ");
            sizeX = scan.nextInt();
        }

        System.out.print("Board size Y: \n> ");
        sizeY = scan.nextInt();
        while (sizeY <= 0){
            System.out.print("Border size cannot be less than or equal to 0. \nBoard size Y: \n> ");
            sizeY = scan.nextInt();
        }

        System.out.print("Number of maximum steps: \n> ");
        maxSteps = scan.nextInt();
        while (maxSteps <= 0){
            System.out.print("Number of max steps cannot be less than or equal to 0. \nNumber of steps: \n> ");
            maxSteps = scan.nextInt();
        }

        System.out.println();
    }


//    private void displayBoard(Board board){
//        for (int i = 0; i < board.getSizeX(); i++) {
//            for (int j = 0; j < board.getSizeY(); j++) {
//                System.out.print(board.getPosition(i,j).getChar() + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("\n\n\n\n");
//    }





    public static int getSizeX() {
        return sizeX;
    }
    public static int getSizeY() {
        return sizeY;
    }

    public int getNumOfAnts() {
        return numOfAnts;
    }
    public int getNumOfWood() {
        return numOfWood;
    }


    public List <Ant> getAnts() {
        return Ants;
    }
    public List <Wood> getWoods() {
        return Woods;
    }


    //StdDraw.clear();

}
