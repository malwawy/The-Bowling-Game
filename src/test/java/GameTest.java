import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
         game = new Game();
    }

   @Test
    void canScoreGutterGame() {

       game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
       assertThat(game.score(), is(0));
   }

   @Test
    void canScoreGameOfOnes(){
      game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
       assertThat(game.score(), is(20));
   }

   @Test
   void canScoreSpareFollowedByThree(){
        game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        assertThat(game.score(), is(16));
   }

   @Test
    void canScoreStrikeFollowedByThreeThenThree(){
        game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(game.score(), is(22));
    }

    @Test
    void canScorePerfectGame() {
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertThat(game.score(), is(300));
    }

    @Test
    void doesNotScoreSpareInLastFrame() {
        game.roll(5,3, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 2,8,5);
        assertThat(game.score(), is(26));
    }
}



