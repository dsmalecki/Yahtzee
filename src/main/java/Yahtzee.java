import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yahtzee {
    List<Integer> listYahtzee;
    String category;
    int score;

    public String getCategory() {
        return category;
    }

    public int getScore() {
        return score;
    }

    public List<Integer> getListYahtzee() {
        return listYahtzee;
    }

    public Yahtzee(List<Integer> listYahtzee) {
        this.listYahtzee = listYahtzee;
        this.category=checkcategory(listYahtzee);
        this.score=checkScore(listYahtzee);
    }

    public Yahtzee(List<Integer> listYahtzee, String category, int score) {
        this.listYahtzee = listYahtzee;
        this.category=checkcategory(listYahtzee);
        this.score=checkScore(listYahtzee);
    }

    public Yahtzee(List<Integer> listYahtzee, int score) {
        this.listYahtzee = listYahtzee;
        this.category=checkcategory(listYahtzee);
        this.score=checkScore(listYahtzee);
    }

    public Yahtzee(List<Integer> listYahtzee, String category) {
        this.listYahtzee = listYahtzee;
        this.category=checkcategory(listYahtzee);
        this.score=checkScore(listYahtzee);
    }

    private static List<Integer> deleteRepeats(List<Integer> listYahtzee0) {
        return listYahtzee0.stream().distinct().collect(Collectors.toList());
    }

    private static List<Integer> deleteNonRepeats(List<Integer> listYahtzee0) {
        Map<Integer, Long> mapYahtzeeList = mapYahtzeeList(listYahtzee0);
        for (int i = 1; i <= 6; i++) {
            mapYahtzeeList.remove(i, 1L);
        }

        return new ArrayList<>(mapYahtzeeList.keySet());
    }

    private static Map<Integer, Long> mapYahtzeeList(List<Integer> listYahtzee0) {
        return listYahtzee0.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    static String checkcategory(List<Integer> listYahtzee0) {
        long howManyDistint = deleteRepeats(listYahtzee0).size();

        Map<Integer, Long> mappedYahtzeelist = mapYahtzeeList(listYahtzee0);

//        Set<Integer> repeatedNumbers = mappedYahtzeelist.keySet();

        boolean checkFull = (listYahtzee0.get(0).equals(listYahtzee0.get(1)) && listYahtzee0.get(3).equals(listYahtzee0.get(4))) && (listYahtzee0.get(2).equals(listYahtzee0.get(1)) || listYahtzee0.get(2).equals(listYahtzee0.get(3)));

        long countEvenNumbers = listYahtzee0.stream()
                .filter(c -> c % 2 == 0)
                .count();
        long countOddNumbers = listYahtzee0.stream()
                .filter(c -> c % 2 == 1)
                .count();


        //yahtze
        if (howManyDistint == 1) return "YAHTZE";

        //small straight
        listYahtzee0.sort(Integer::compareTo);
        if (listYahtzee0.equals(Arrays.asList(1, 2, 3, 4, 5))) return "SMALL STRAIGHT";


        //large straight
        if (listYahtzee0.equals(Arrays.asList(2, 3, 4, 5, 6))) return "LARGE STRAIGHT";

        //full house
        if (checkFull) return "FULL HOUSE";

        //odd numbers
        if (countOddNumbers == 5) {
            return "ODD NUMBERS";
        }
        //even numbers
        if (countEvenNumbers == 5) return "EVEN NUMBERS";

        //pair
        if (howManyDistint == 4) return "PAIR";

        //three of a kind
        if (howManyDistint == 3) {
            for (int i = 0; i < 3; i++) {
                if (listYahtzee0.get(i).equals(listYahtzee0.get(i + 1)) && listYahtzee0.get(i).equals(listYahtzee0.get(i + 2))) {
                    return "THREE";
                }
            }
        }

        //two pairs
        if (howManyDistint == 3) {
            for (int i = 1; i <= 6; i++) {
                mappedYahtzeelist.remove(i, 1L);
            }
            if (mappedYahtzeelist.size() == 2) return "TWO PAIRS";
        }

        //four of a kind
        if (howManyDistint == 2) return "FOUR";


        //chance
        return "CHANCE";
//        return null;
    }

    static int checkScore(List<Integer> listYahtzee0) {
        String category = checkcategory(listYahtzee0);
        int score = 0;
        List<Integer> listYahtzeeWithoutDistinct;

        switch (category) {
            case "PAIR":

            case "TWO PAIRS":

            case "THREE":

            case "FOUR":
                listYahtzeeWithoutDistinct = deleteNonRepeats(listYahtzee0);
                break;

            default:
                listYahtzeeWithoutDistinct = listYahtzee0;
                break;
        }

        for (Integer i : listYahtzeeWithoutDistinct) {
            score += i;
        }

        switch (category) {
            case "PAIR":

            case "TWO PAIRS":
                return score * 2;

            case "THREE":
                return score * 3;

            case "FOUR":
                return score * 4;

            default:
                return score;
        }
    }


}

