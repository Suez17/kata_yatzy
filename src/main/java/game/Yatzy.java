package game;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return (d1 + d2 + d3 + d4 + d5);
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        return (IntStream.of(d1, d2, d3, d4, d5).distinct().count() == 1) ? 50 : 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumOccurences(1, Arrays.asList(d1, d2, d3, d4, d5));
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumOccurences(2, Arrays.asList(d1, d2, d3, d4, d5));
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumOccurences(3, Arrays.asList(d1, d2, d3, d4, d5));
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return sumOccurences(4, Arrays.asList(d1, d2, d3, d4, d5));
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return sumOccurences(5, Arrays.asList(d1, d2, d3, d4, d5));
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return sumOccurences(6, Arrays.asList(d1, d2, d3, d4, d5));
    }

    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        return findMaxValue(findDuplicateDiceValues(d1, d2, d3, d4, d5)) * 2;
    }

    public static int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        int sumOfTwoPairs = 0;
        if (findDuplicateDiceValues(d1, d2, d3, d4, d5).size() == 2) {
            sumOfTwoPairs = sumOfAKind(2, false, d1, d2, d3, d4, d5);
        }
        return sumOfTwoPairs;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        return sumOfAKind(3, false, d1, d2, d3, d4, d5);
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        return sumOfAKind(4, false, d1, d2, d3, d4, d5);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        final String smallStraight = "12345";
        return smallStraight.equals(createOrderedChainOfDice(d1, d2, d3, d4, d5)) ? 15 : 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        final String largeStraight = "23456";
        return largeStraight.equals(createOrderedChainOfDice(d1, d2, d3, d4, d5)) ? 20 : 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int sumOfFullHouse = 0;

        if (findDuplicateDiceValues(d1, d2, d3, d4, d5).size() == 2) {
            sumOfFullHouse = sumOfAKind(3, true, d1, d2, d3, d4, d5);
            if (sumOfFullHouse != 0) {
                sumOfFullHouse += sumOfAKind(2, true, d1, d2, d3, d4, d5);
            }
        }
        return sumOfFullHouse;
    }

    private static int sumOfAKind(int valueOfAKind, boolean strictComparison,
                                  int d1, int d2, int d3, int d4, int d5) {
        int sumOfAKind = 0;
        final List<Integer> dices = Arrays.asList(d1, d2, d3, d4, d5);
        final Set<Integer> duplicateDiceValues = findDuplicateDiceValues(d1, d2, d3, d4, d5);
        for (int duplicateDiceValue : duplicateDiceValues) {
            final long totalDuplicateValues = countOccurences(duplicateDiceValue, dices);
            if ((!strictComparison && totalDuplicateValues >= valueOfAKind) ||
                    (strictComparison && totalDuplicateValues == valueOfAKind)) {
                sumOfAKind += duplicateDiceValue * valueOfAKind;
            }
        }
        return sumOfAKind;
    }

    private static int sumOccurences(int targetValue, List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .filter(value -> value == targetValue)
                .sum();
    }
    
    private static long countOccurences(int targetValue, List<Integer> list) {
        return list.stream()
                .filter(value -> value == targetValue)
                .count();
    }

    private static int findMaxValue(Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    private static Set<Integer> findDuplicateDiceValues(int d1, int d2, int d3, int d4, int d5) {
        final Set<Integer> set = new HashSet<>();
        return Stream.of(d1, d2, d3, d4, d5)
                .filter(d -> !set.add(d))
                .collect(Collectors.toSet());
    }

    private static String createOrderedChainOfDice(int d1, int d2, int d3, int d4, int d5) {
        return IntStream.of(d1, d2, d3, d4, d5)
                .sorted()
                .mapToObj(String::valueOf)
                .reduce("", (acc, d) -> acc += d);
    }
}
