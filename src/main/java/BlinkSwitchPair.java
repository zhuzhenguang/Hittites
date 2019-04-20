import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BlinkSwitchPair {
    private static String[] teamMembers = new String[]{"Xiaoshuang", "Xiaoyun", "Kangzhe", "Zhuyu", "Zhenguang", "Shanil"};
    private static String[] pairOfPast = new String[]{"03", "12", "45"};

    public static void main(String[] args) {
        String[] currentPairs = new String[3];
        List<Integer> randomInts = new ArrayList<Integer>();

        int i = 0;
        while (i < 3) {
            int number1 = new Random().nextInt(6);
            int number2 = new Random().nextInt(6);
            if (!randomInts.contains(number1) && !randomInts.contains(number2) && !Arrays.asList(pairOfPast).contains(number1 + "" + number2) && !Arrays.asList(pairOfPast).contains(number2 + "" + number1)) {
                currentPairs[i] = number1 + "" + number2;
                randomInts.add(number1);
                randomInts.add(number2);

                i++;
            }
        }

        for (String currentPair : currentPairs) {
            int first = Integer.parseInt(String.valueOf(currentPair.charAt(0)));
            int second = Integer.parseInt(String.valueOf(currentPair.charAt(1)));
            System.out.println(teamMembers[first] + "-" + teamMembers[second]);
        }

    }
}
