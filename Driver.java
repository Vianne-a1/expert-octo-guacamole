public class Driver {
    public static void main(String[] args) {
        int boardSize = 8; // Set the size of the chessboard
        NQueens nQueens = new NQueens(boardSize);

        // Solve the N-Queens problem
        if (nQueens.solve()) {
            System.out.println("Solution found:");
            System.out.println(nQueens);
        } else {
            System.out.println("No solution exists for the given board size of " + boardSize);
        }

        // Count all possible solutions
        int solutionsCount = nQueens.countSolutions();
        System.out.println("Total number of solutions: " + solutionsCount);
    }
}