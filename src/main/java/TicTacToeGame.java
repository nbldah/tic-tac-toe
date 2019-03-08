import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;


/**
 * Tic-tac-toe game.
 * The game will be represented as follow:
 *
 *         |     |
 *    __1__|__2__|__3__
 *         |     |
 *    __4__|__5__|__6__
 *         |     |
 *      7  |  8  |  9
 *
 */
class TicTacToeGame {

    private List<Integer> playerXmoves = new ArrayList<>();
    private List<Integer> playerOmoves = new ArrayList<>();

    private static final List<List<Integer>> POSSIBLE_WINNING_GAMES;

    static {

        POSSIBLE_WINNING_GAMES = asList(

                asList(1, 2, 3),
                asList(4, 5, 6),
                asList(7, 8, 9),

                asList(1, 4, 7),
                asList(2, 5, 8),
                asList(3, 6, 9),

                asList(1, 5, 9),
                asList(3, 5, 7));
    }

    boolean isLegalMove(int move) {
        return !playerXmoves.contains(move) && !playerOmoves.contains(move);
    }

    void playX(int move) {
        if (isLegalMove(move)) {
            playerXmoves.add(move);
        }
    }

    void playO(int move) {
        if (isLegalMove(move)) {
            playerOmoves.add(move);
        }
    }

    List<Integer> getPlayerXmoves() {
        return playerXmoves;
    }

    List<Integer> getPlayerOmoves() {
        return playerOmoves;
    }

    boolean xHasWin() {
        return containsWinningGame(playerXmoves);
    }

    boolean oHasWin() {
        return containsWinningGame(playerOmoves);
    }

    boolean containsWinningGame(List<Integer> playerMoves) {
        return POSSIBLE_WINNING_GAMES.stream().anyMatch(playerMoves::containsAll);
    }

    boolean isFinished() {
        return oHasWin() || xHasWin() ||
                (playerXmoves.size() == 5 && playerOmoves.size() == 4) ||
                (playerOmoves.size() == 5 && playerXmoves.size() == 4);
    }
}
