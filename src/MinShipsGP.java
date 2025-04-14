import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinShipsGP {
    private final ArrayList<Integer> artifactsFound = new ArrayList<>();
    // Weight of artifacts as list will be provided in the input file, and the list
    // should be populated using this format.
    // [3,2,3,4,5,4]

    public void readInput(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        for (String part : parts) {
            getArtifactsFound().add(Integer.parseInt(part));
        }
    }

    public ArrayList<Integer> getArtifactsFound() {
        return artifactsFound;
    }

    MinShipsGP(ArrayList<Integer> artifactsFound) {
        this.artifactsFound.addAll(artifactsFound);
    }

    public OptimalShipSolution optimalArtifactCarryingAlgorithm()  {
        final int maxC = 100;
        int N = getArtifactsFound().size();
        int[] spaceShips = new int[N]; // weight array with max possible size
        ArrayList<Integer> copy = new ArrayList<>(getArtifactsFound());
        copy.sort(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = copy.get(i) + spaceShips[j];
                if (k <= maxC) {
                    spaceShips[j] = k;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (spaceShips[i] > 0) count++;
        }
        return new OptimalShipSolution(getArtifactsFound(), count);
    }
}
