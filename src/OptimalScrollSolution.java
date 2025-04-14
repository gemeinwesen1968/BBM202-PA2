import java.util.ArrayList;

public class OptimalScrollSolution {
    private final ArrayList<ArrayList<Integer>> safeSet;
    private final int solution;

    OptimalScrollSolution(ArrayList<ArrayList<Integer>> safeSet, int solution) {
        this.safeSet = safeSet;
        this.solution = solution;
    }

    public int getSolution() {
        return solution;
    }

    public ArrayList<ArrayList<Integer>> getSafeSet() {
        return safeSet;
    }

    public void printSolution(OptimalScrollSolution solution) {
        System.out.println("Maximum scrolls acquired: " + solution.getSolution());
        System.out.println("For the safe set of :" + solution.getSafeSet());
    }
}
