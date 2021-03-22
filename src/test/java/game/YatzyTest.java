package game;

import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void test_chance_scores_15() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
    }

    @Test
    public void test_chance_scores_16() {
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void test_yatzy_scores_50() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
    }

    @Test
    public void test_yatzy_scores_0() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void test_ones_scores_1() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
    }

    @Test
    public void test_ones_scores_2() {
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
    }

    @Test
    public void test_ones_scores_0() {
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
    }

    @Test
    public void test_ones_scores_4() {
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void test_twos_scores_4() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
    }

    @Test
    public void test_twos_scores_10() {
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void test_twos_scores_0() {
        assertEquals(0, Yatzy.twos(1, 3, 4, 5, 6));
    }

    @Test
    public void test_threes_scores_6() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
    }

    @Test
    public void test_threes_scores_12() {
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void test_threes_scores_0() {
        assertEquals(0, Yatzy.threes(2, 2, 2, 2, 1));
    }

    @Test
    public void test_fours_scores_12() {
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
    }

    @Test
    public void test_fours_scores_8() {
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
    }

    @Test
    public void test_fours_scores_4() {
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
    }

    @Test
    public void test_fours_scores_0() {
        assertEquals(0, Yatzy.fours(5, 5, 5, 5, 5));
    }

    @Test
    public void test_fives_scores_10() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
    }

    @Test
    public void test_fives_scores_15() {
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
    }

    @Test
    public void test_fives_scores_20() {
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void test_fives_scores_0() {
        assertEquals(0, Yatzy.fives(4, 4, 4, 4, 4));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.score_pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.score_pair(5, 3, 6, 6, 5));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 5, 5));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }

}
