public class NQueens {
    private int[][] board;

    public NQueens(int size) {
        board = new int[size][size];
        clear();
    }

    private boolean addQueen(int r, int c) {
        if (board[r][c] != 0) {
            return false;
        }
        board[r][c] = -1;
        updateThreatenedPositions(r, c, 1);
        return true;
    }

    public void clear() {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 0;
            }
        }
    }

    private void removeQueen(int r, int c) {
        if (board[r][c] != 1) {
            return;
        }
        board[r][c] = 0;
        updateThreatenedPositions(r, c, 1);
    }

    private void updateThreatenedPositions(int r, int c, int value) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            board[r][i] += value;
            board[i][c] += value;
            if (r + i < size && c + i < size) {
                board[r + i][c + i] += value;
            }
            if (r - i >= 0 && c - i >= 0) {
                board[r - i][c - i] += value;
            }
            if (r + i < size && c - i >= 0) {
                board[r + i][c - i] += value;
            }
            if (r - i >= 0 && c + i < size) {
                board[r - i][c + i] += value;
            }
        }
    }
    public boolean solve() {
        return solveRecursively(0);
    }

    private boolean solveRecursively(int col) {
        int size = board.length;
        if (col == size) {
            return true;
        }
        for (int row = 0; row < size; row++) {
            if (isSafe(row, col)) {
                addQueen(row, col);
                if (solveRecursively(col + 1)) {
                    return true;
                }
                removeQueen(row, col);
            }
        }
        return false;
    }

    public int countSolutions() {
        return countSolutionsRecursively(0);
    }

    private int countSolutionsRecursively(int col) {
        int size = board.length;
        int count = 0;
        if (col == size) {
            return 1;
        }
        for (int row = 0; row < size; row++) {
            if (isSafe(row, col)) {
                addQueen(row, col);
                count += countSolutionsRecursively(col + 1);
                removeQueen(row, col);
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    result.append("Q ");
                } else {
                    result.append("_ ");
                }
            }
            result.append("\n");
        }
        return result.toString().trim();
    }
  }
