package com.wezhyn.learn.daily;

/**
 * @author wezhyn
 * @since 09.13.2020
 */
public class WordSearch {

    private static final int[] OFFSET = new int[]{0, 1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && doExist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doExist(char[][] board, String word, int cur, int i, int j) {
        if (cur == word.length() - 1) {
            return true;
        }
        try {
            board[i][j] = '/';
            for (int k = 0; k < 4; k++) {
                int x = i + OFFSET[k];
                int y = j + OFFSET[k + 1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[x].length) {
                    continue;
                }
                if (board[x][y] == word.charAt(cur + 1) && doExist(board, word, cur + 1, x, y)) {
                    return true;
                }
            }
            return false;
        } finally {
            board[i][j] = word.charAt(cur);
        }
    }
}
