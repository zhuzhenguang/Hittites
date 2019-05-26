package org.thoughtworks.blink;

import java.util.*;
import java.util.stream.Collectors;

public class SwitchPair {
    private static String[] teamMembers = new String[]{"Xiaoshuang", "Xiaoyun", "Kangzhe", "Zhuyu", "Zhenguang", "Shanil"};
    private static String[] pairOfPast = new String[]{"03", "25", "14"};

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(pairOfPastSet(), Pair::firstMember);
        Set<Pair> scheduledPairs = scheduler.schedule();

        print(scheduledPairs);
    }

    private static Set<Pair> pairOfPastSet() {
        return Arrays.stream(pairOfPast)
                .map(pair -> Pair.createBy(pair, teamMembers))
                .collect(Collectors.toSet());
    }

    private static void print(Collection<Pair> pairs) {
        pairs.forEach(System.out::println);
    }
}