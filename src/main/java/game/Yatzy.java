package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        return (d1 + d2 + d3 + d4 + d5 == d1 * 5) ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumTargetDiceValue(1, d1, d2, d3, d4, d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumTargetDiceValue(2, d1, d2, d3, d4, d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumTargetDiceValue(3, d1, d2, d3, d4, d5);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return sumTargetDiceValue(4, d1, d2, d3, d4, d5);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return sumTargetDiceValue(5, d1, d2, d3, d4, d5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return sumTargetDiceValue(6, d1, d2, d3, d4, d5);
    }

    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        final Set<Integer> set = new HashSet<>();
        return IntStream.of(d1, d2, d3, d4, d5)
                .filter(d -> !set.add(d))
                .max()
                .orElse(0) * 2;
    }

    public static int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        int sumOfTwoPairs = 0;
        final Set<Integer> duplicateDiceValues = getDuplicateDiceValues(d1, d2, d3, d4, d5);
        if (duplicateDiceValues.size() >= 2) {
            int maxPairValue = getMaxValue(duplicateDiceValues);
            sumOfTwoPairs += maxPairValue * 2;
            duplicateDiceValues.remove(maxPairValue);
            sumOfTwoPairs += getMaxValue(duplicateDiceValues) * 2;
        }
        return sumOfTwoPairs;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int sumOfThreeOfAKind = 0;
        final List<Integer> dices = Arrays.asList(d1, d2, d3, d4, d5);
        final Set<Integer> duplicateDiceValues = getDuplicateDiceValues(d1, d2, d3, d4, d5);
        for (int duplicateDiceValue : duplicateDiceValues) {
            if (dices.stream().filter(d -> d == duplicateDiceValue).count() >= 3) {
                sumOfThreeOfAKind += duplicateDiceValue * 3;
            }
        }
        return sumOfThreeOfAKind;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int sumOfThreeOfAKind = 0;
        final List<Integer> dices = Arrays.asList(d1, d2, d3, d4, d5);
        final Set<Integer> duplicateDiceValues = getDuplicateDiceValues(d1, d2, d3, d4, d5);
        for (int duplicateDiceValue : duplicateDiceValues) {
            if (dices.stream().filter(d -> d == duplicateDiceValue).count() >= 4) {
                sumOfThreeOfAKind += duplicateDiceValue * 4;
            }
        }
        return sumOfThreeOfAKind;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        final String smallStraight = "12345";
        return smallStraight.equals(getOrderedDices(d1, d2, d3, d4, d5)) ? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        final String largeStraight = "23456";
        return largeStraight.equals(getOrderedDices(d1, d2, d3, d4, d5)) ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private static int sumTargetDiceValue(int targetDiceValue, int d1, int d2, int d3, int d4, int d5) {
        return IntStream.of(d1, d2, d3, d4, d5).filter(d -> d == targetDiceValue).sum();
    }

    private static int getMaxValue(Set<Integer> set) {
        return set.stream().mapToInt(Integer::valueOf).max().orElse(0);
    }

    private static Set<Integer> getDuplicateDiceValues(int d1, int d2, int d3, int d4, int d5) {
        final Set<Integer> set = new HashSet<>();
        return Stream.of(d1, d2, d3, d4, d5)
                .filter(d -> !set.add(d))
                .collect(Collectors.toSet());
    }

    private static String getOrderedDices(int d1, int d2, int d3, int d4, int d5) {
        return IntStream.of(d1, d2, d3, d4, d5)
                .sorted()
                .mapToObj(String::valueOf)
                .reduce("", (acc, d) -> acc += d);
    }
}
