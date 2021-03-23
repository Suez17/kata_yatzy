package game;

import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void testChanceScores15() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
    }

    @Test
    public void testChanceScores16() {
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void testYatzyScores50() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
    }

    @Test
    public void testYatzyScores50other() {
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
    }

    @Test
    public void testYatzyScores0() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void testOneScores1() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
    }

    @Test
    public void testOnesScores2() {
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
    }

    @Test
    public void testOnesScores0() {
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
    }

    @Test
    public void testOnesScores4() {
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void testTwosScores4() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
    }

    @Test
    public void testTwosScores10() {
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void testTwosScores0() {
        assertEquals(0, Yatzy.twos(1, 3, 4, 5, 6));
    }

    @Test
    public void testThreesScores6() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
    }

    @Test
    public void testThreesScores12() {
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void testThreesScores0() {
        assertEquals(0, Yatzy.threes(2, 2, 2, 2, 1));
    }

    @Test
    public void testFoursScores12() {
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
    }

    @Test
    public void testFoursScores8() {
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
    }

    @Test
    public void testFoursScores4() {
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
    }

    @Test
    public void testFoursScores0() {
        assertEquals(0, Yatzy.fours(5, 5, 5, 5, 5));
    }

    @Test
    public void testFivesScores10() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
    }

    @Test
    public void testFivesScores15() {
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
    }

    @Test
    public void testFivesScores20() {
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void testFivesScores0() {
        assertEquals(0, Yatzy.fives(4, 4, 4, 4, 4));
    }

    @Test
    public void testSixesScores0() {
        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
    }

    @Test
    public void testSixesScores6() {
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
    }

    @Test
    public void testSixesScores18() {
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    @Test
    public void testPairScores6() {
        assertEquals(6, Yatzy.pair(3, 4, 3, 5, 6));
    }

    @Test
    public void testPairScores10() {
        assertEquals(10, Yatzy.pair(5, 3, 3, 3, 5));
    }

    @Test
    public void testPairScores12() {
        assertEquals(12, Yatzy.pair(5, 3, 6, 6, 5));
    }

    @Test
    public void testPairScores0() {
        assertEquals(0, Yatzy.pair(2, 3, 1, 6, 5));
    }

    @Test
    public void testTwoPairsScores16() {
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 4, 5));
    }

    @Test
    public void testTwoPairsScores16WhenFullHouse() {
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 5, 5));
    }

    @Test
    public void testTwoPairsScores0WhenOnePair() {
        assertEquals(0, Yatzy.twoPairs(3, 3, 1, 2, 4));
    }

    @Test
    public void testTwoPairsScores0WhenNoPair() {
        assertEquals(0, Yatzy.twoPairs(1, 2, 3, 4, 5));
    }

    @Test
    public void testThreeOfAKindScores9() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
    }

    @Test
    public void testThreeOfAKindScores15() {
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
    }

    @Test
    public void testThreeOfAKindScores9WhenFourOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
    }

    @Test
    public void testThreeOfAKindScores0WhenPair() {
        assertEquals(0, Yatzy.threeOfAKind(1, 3, 5, 4, 5));
    }

    @Test
    public void testThreeOfAKindScores0() {
        assertEquals(0, Yatzy.threeOfAKind(1, 3, 6, 4, 5));
    }

    @Test
    public void testFourOfAKindScores12() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
    }

    @Test
    public void testFourOfAKindScores20() {
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
    }

    @Test
    public void testFourOfAKindScores12WhenFiveOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 3));
    }

    @Test
    public void testFourOfAKindScores0WhenFullHouse() {
        assertEquals(0, Yatzy.fourOfAKind(3, 3, 3, 5, 5));
    }

    @Test
    public void testFourOfAKindScores0WhenThreeOfAKind() {
        assertEquals(0, Yatzy.fourOfAKind(3, 3, 3, 4, 5));
    }

    @Test
    public void testFourOfAKindScores0WhenPair() {
        assertEquals(0, Yatzy.fourOfAKind(3, 3, 2, 4, 5));
    }

    @Test
    public void testSmallStraightScores15WhenOrdered() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
    }

    @Test
    public void testSmallStraightScores15WhenUnordered() {
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    }

    @Test
    public void testSmallStraightScores0() {
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void testLargeStraightScores20WhenOrdered() {
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
    }

    @Test
    public void testLargeStraightScores20WhenUnordered() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
    }

    @Test
    public void testLargeStraightScores0WhenSmallStraight() {
        assertEquals(0, Yatzy.largeStraight(1, 2, 3, 4, 5));
    }

    @Test
    public void testLargeStraightScores0() {
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void testFullHouseScores18() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    }

    @Test
    public void testFullHouseScores0() {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }

    @Test
    public void testFullHouseScores0WhenPair() {
        assertEquals(0, Yatzy.fullHouse(2, 2, 3, 5, 6));
    }

    @Test
    public void testFullHouseScores0WhenTwoPairs() {
        assertEquals(0, Yatzy.fullHouse(2, 2, 4, 4, 6));
    }

    @Test
    public void testFullHouseScores0WhenThreeOfAKind() {
        assertEquals(0, Yatzy.fullHouse(2, 2, 2, 4, 6));
    }

    @Test
    public void testFullHouseScores0WhenFourOfAKind() {
        assertEquals(0, Yatzy.fullHouse(2, 2, 2, 2, 6));
    }

    @Test
    public void testFullHouseScores0WhenFiveOfAKind() {
        assertEquals(0, Yatzy.fullHouse(2, 2, 2, 2, 2));
    }

}
