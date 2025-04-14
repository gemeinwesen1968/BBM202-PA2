import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxScrollsDP {
    private ArrayList<ArrayList<Integer>> safesDiscovered = new ArrayList<>();

    public void readInput(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        int size = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(",");
            int complexity = Integer.parseInt(parts[0].trim());
            int scrolls = Integer.parseInt(parts[1].trim());
            ArrayList<Integer> safe = new ArrayList<>();
            safe.add(complexity);
            safe.add(scrolls);
            safesDiscovered.add(safe);
        }
        scanner.close();
    }

    public MaxScrollsDP(ArrayList<ArrayList<Integer>> safesDiscovered) {
        this.safesDiscovered = safesDiscovered;
    }

    public ArrayList<ArrayList<Integer>> getSafesDiscovered() {
        return safesDiscovered;
    }

    public OptimalScrollSolution optimalSafeOpeningAlgorithm() {
        int T = safesDiscovered.size();
        int maxK = 5 * T;

        int[][] v = new int[T+1][maxK+1];
        for (int i = 0; i <= T; i++) {
            for (int j = 0; j <= maxK; j++) {
                v[i][j] = -1; // -1 -> does not matter
            }
        }
        v[0][0] = 0;

        for (int i = 0; i < T; i++) {
            int c = safesDiscovered.get(i).get(0); // complexity
            int s = safesDiscovered.get(i).get(1); // scrolls
            for (int k = 0; k <= maxK; k++) {
                if (v[i][k] == -1) continue;
                if (k+5 <= maxK) { // gain knowledge, pass scrolls
                    v[i+1][k+5] = Math.max(v[i+1][k+5], v[i][k]);
                }
                if (k >= c) { // read scrolls, spend knowledge
                    v[i+1][k-c] = Math.max(v[i+1][k-c], v[i][k]+s);
                }
                v[i+1][k] = Math.max(v[i+1][k], v[i][k]); // pass time
            }
        }
        int maxS = 0;
        for (int k = 0; k <= maxK; k++) {
            maxS = Math.max(maxS, v[T][k]); // the max scroll amount from last minute
        }
        return new OptimalScrollSolution(getSafesDiscovered(), maxS);
    }
}
