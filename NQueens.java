public class NQueens {
    private int[][] board;

    public NQueens(int size) {
        board = new int[size][size];
        clear();
    }

    private boolean addQueen(int row, int col) {
        int i = 0;
        while (i < board.length) {
            if (board[row][i] == -1 || board[i][col] == -1) {
                return false;
            }
            i++;
        }

        i = 1;
        while (i < board.length) {
            if (row + i < board.length && col + i < board.length && board[row + i][col + i] == -1) {
                return false;
            }
            if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] == -1) {
                return false;
            }
            if (row + i < board.length && col - i >= 0 && board[row + i][col - i] == -1) {
                return false;
            }
            if (row - i >= 0 && col + i < board.length && board[row - i][col + i] == -1) {
                return false;
            }
            i++;
        }

        board[row][col] = -1;
        return true;
    }

    private void removeQueen(int row, int col) {
        board[row][col] = 0;
    }

    public boolean solve() {
        clear();
        return solve(0);
    }

    private boolean solve(int row) {
        while (row < board.length) {
            int col = 0;
            while (col < board.length) {
                if (addQueen(row, col)) {
                    if (solve(row + 1)) {
                        return true;
                    }
                    removeQueen(row, col);
                }
                col++;
            }
            return false;
        }
        return true;
    }

    public int countSolutions() {
        clear();
        return countSolutions(0);
    }

    private int countSolutions(int row) {
        if (row == board.length) {
            return 1;
        }

        int count = 0;
        int col = 0;
        while (col < board.length) {
            if (addQueen(row, col)) {
                count += countSolutions(row + 1);
                removeQueen(row, col);
            }
            col++;
        }

        return count;
    }

    private void clear() {
        int row = 0;
        while (row < board.length) {
            int col = 0;
            while (col < board.length) {
                board[row][col] = 0;
                col++;
            }
            row++;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        int row = 0;
        while (row < board.length) {
            int col = 0;
            while (col < board[row].length) {
                if (board[row][col] == -1) {
                    result.append("Q ");
                } else {
                    result.append("_ ");
                }
                col++;
            }
            result.append("\n");
            row++;
        }
        return result.toString();
    }
}
