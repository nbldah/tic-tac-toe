import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TicTacToeTest {

    private TicTacToeGame game;

    @Test
    void should_return_that_9_6_2_are_move_legal() {

        //given
        game = new TicTacToeGame();

        //when
        game.playX(1);
        game.playO(7);
        game.playX(4);

        //then
        assertThat(game.isLegalMove(9)).isTrue();
        assertThat(game.isLegalMove(6)).isTrue();
        assertThat(game.isLegalMove(2)).isTrue();
    }

    @Test
    void should_return_false_if_the_move_is_illegal() {

        //given
        game = new TicTacToeGame();

        //when
        game.playX(1);

        //then
        assertThat(game.isLegalMove(1)).isFalse();
    }

    @Test
    void should_not_play_the_move_if_its_illegal() {

        //given
        game = new TicTacToeGame();

        //when
        game.playX(1);
        game.playO(1);

        //then
        assertThat(game.isLegalMove(1)).isFalse();
        assertThat(game.getPlayerOmoves()).isEmpty();
        assertThat(game.getPlayerXmoves()).hasSize(1);
    }

    @Test
    void should_return_that_x_won_the_game() {

        //given
        game = new TicTacToeGame();

        //when
        game.playX(1);
        game.playO(2);
        game.playX(4);
        game.playO(3);
        game.playX(7);

        //then
        assertThat(game.xHasWin()).isTrue();
    }

    @Test
    void should_recognize_a_finished_game() {

        //given
        game = new TicTacToeGame();

        //when
        game.playX(1);
        game.playO(2);
        game.playX(3);
        game.playO(5);
        game.playX(4);
        game.playO(6);
        game.playX(8);
        game.playO(7);

        //then
        assertThat(game.isFinished()).isFalse();
        game.playX(9);
        assertThat(game.isFinished()).isTrue();
    }

}
