import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BlinkSwitchPair {
    private static String[] teamMembers = new String[]{"Xiaoshuang", "Xiaoyun", "Kangzhe", "Zhuyu", "Zhenguang", "Shanil"};
    private static String[] pairOfPast = new String[]{"01", "25", "34"};

    public static void main(String[] args) {
        Set<Member> teamMemberSet = Arrays.stream(teamMembers).map(Member::new).collect(Collectors.toSet());
        Set<Pair> pairOfPastSet = Arrays.stream(pairOfPast)
                .map(pair -> {
                    String firstMemberName = teamMembers[Integer.parseInt(String.valueOf(pair.charAt(0)))];
                    String secondMemberName = teamMembers[Integer.parseInt(String.valueOf(pair.charAt(1)))];
                    return new Pair(new Member(firstMemberName), new Member(secondMemberName));
                })
                .collect(Collectors.toSet());

        Scheduler scheduler = new Scheduler(pairOfPastSet, teamMemberSet);
        Set<Pair> scheduledPairs = scheduler.Schedule();

        print(scheduledPairs);
    }

    private static void print(Collection<Pair> pairs) {
        pairs.forEach(System.out::println);
    }
}