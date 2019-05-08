import java.util.*;
import java.util.stream.Collectors;

public class SwitchPair {
    private static String[] teamMembers = new String[]{"Xiaoshuang", "Xiaoyun", "Kangzhe", "Zhuyu", "Zhenguang", "Shanil"};
    private static String[] pairOfPast = new String[]{"01", "25", "34"};

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(pairOfPastSet(), allTeamMemberSet());
        Set<Pair> scheduledPairs = scheduler.Schedule();

        print(scheduledPairs);
    }

    private static Set<Pair> pairOfPastSet() {
        return Arrays.stream(pairOfPast)
                .map(pair -> Pair.createBy(pair, teamMembers))
                .collect(Collectors.toSet());
    }

    private static Set<Member> allTeamMemberSet() {
        return Arrays.stream(teamMembers).map(Member::new).collect(Collectors.toSet());
    }

    private static void print(Collection<Pair> pairs) {
        pairs.forEach(System.out::println);
    }
}