public class Driver {
    public static void main(String[] args) {

        int x = 10;
        NQueens nQueens = new NQueens(x);

        // Solve and print the first solution
        System.out.println("Possible Solution:");
        if (nQueens.solve()) {
            System.out.println(nQueens);
        } else {
            System.out.println("No solution found.");
        }

        // Count and print the total number of solutions
        int totalSolutions = nQueens.countSolutions();
        System.out.println("\nTotal number of solutions for a " + x + " by " + x + " grid: " + totalSolutions);


    }
}
