import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        /** Safe-lock Opening Algorithm Below **/
        System.out.println("##Initiate Operation Safe-lock##");
        MaxScrollsDP m = new MaxScrollsDP(new ArrayList<>());
        m.readInput(args[0]);
        OptimalScrollSolution solSc = m.optimalSafeOpeningAlgorithm();
        solSc.printSolution(solSc);
        System.out.println("##Operation Safe-lock Completed##");

        /** Operation Artifact Algorithm Below **/
        System.out.println("##Initiate Operation Artifact##");
        MinShipsGP mi = new MinShipsGP(new ArrayList<>());
        mi.readInput(args[1]);
        OptimalShipSolution solShi = mi.optimalArtifactCarryingAlgorithm();
        solShi.printSolution(solShi);
        System.out.println("##Operation Artifact Completed##");
    }
}