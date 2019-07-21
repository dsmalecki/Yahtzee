import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YahtzeeDisplayer {

    public static void main(String[] args) {
        List<Yahtzee> alllists = new ArrayList<>();
        Yahtzee listYahtzee0 = new Yahtzee(Arrays.asList(1, 2, 3, 4, 5));
        Yahtzee listYahtzee1 = new Yahtzee(Arrays.asList(1, 1, 3, 3, 5));
        Yahtzee listYahtzee2 = new Yahtzee(Arrays.asList(1, 1, 1, 1, 1));
        Yahtzee listYahtzee3 = new Yahtzee(Arrays.asList(1, 1, 3, 3, 3));
        Yahtzee listYahtzee4 = new Yahtzee(Arrays.asList(1, 2, 3, 3, 3));
        Yahtzee listYahtzee5 = new Yahtzee(Arrays.asList(2, 3, 3, 3, 3));
        Yahtzee listYahtzee6 = new Yahtzee(Arrays.asList(4, 5, 4, 5, 6));

        Yahtzee listYahtzee7 = new Yahtzee(Arrays.asList(2, 3, 4, 4, 5));
        Yahtzee listYahtzee8 = new Yahtzee(Arrays.asList(2, 3, 4, 4, 3));
        Yahtzee listYahtzee9 = new Yahtzee(Arrays.asList(5, 5, 5, 3, 2));
        Yahtzee listYahtzee10 = new Yahtzee(Arrays.asList(6, 6, 6, 5, 6));
        Yahtzee listYahtzee11 = new Yahtzee(Arrays.asList(5, 5, 3, 1, 1));
        Yahtzee listYahtzee12 = new Yahtzee(Arrays.asList(6, 6, 6, 4, 2));
        Yahtzee listYahtzee13 = new Yahtzee(Arrays.asList(1, 3, 5, 4, 2));
        Yahtzee listYahtzee14 = new Yahtzee(Arrays.asList(2, 6, 4, 5, 3));
        Yahtzee listYahtzee15 = new Yahtzee(Arrays.asList(3, 3, 3, 5, 5));
        Yahtzee listYahtzee16 = new Yahtzee(Arrays.asList(6, 6, 6, 6, 6));
        Yahtzee listYahtzee17 = new Yahtzee(Arrays.asList(1, 2, 3, 4, 6));

        alllists.add(listYahtzee0);
        alllists.add(listYahtzee1);
        alllists.add(listYahtzee2);
        alllists.add(listYahtzee3);
        alllists.add(listYahtzee4);
        alllists.add(listYahtzee5);
        alllists.add(listYahtzee6);
        alllists.add(listYahtzee7);
        alllists.add(listYahtzee8);
        alllists.add(listYahtzee9);
        alllists.add(listYahtzee10);
        alllists.add(listYahtzee11);
        alllists.add(listYahtzee12);
        alllists.add(listYahtzee13);
        alllists.add(listYahtzee14);
        alllists.add(listYahtzee15);
        alllists.add(listYahtzee16);
        alllists.add(listYahtzee17);

        for (Yahtzee l : alllists) {
            System.out.println(l.getListYahtzee() + "\t\t" + l.getScore()+"\t\t"+l.getCategory());
        }
    }
}
