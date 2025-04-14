import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("##Initiate Operation Safe-lock##");
        MaxScrollsDP maxScrollsDP = new MaxScrollsDP(new ArrayList<>());
        maxScrollsDP.readInput(args[0]);
        OptimalScrollSolution optimalScrollSolution = maxScrollsDP.optimalSafeOpeningAlgorithm();
        optimalScrollSolution.printSolution(optimalScrollSolution);
        System.out.println("##Operation Safe-lock Completed##");

        System.out.println("##Initiate Operation Artifact##");
        MinShipsGP minShipsGP = new MinShipsGP(new ArrayList<>());
        minShipsGP.readInput(args[1]);
        OptimalShipSolution optimalShipSolution = minShipsGP.optimalArtifactCarryingAlgorithm();
        optimalShipSolution.printSolution(optimalShipSolution);
        System.out.println("##Operation Artifact Completed##");
    }
}