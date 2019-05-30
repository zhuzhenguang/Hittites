package org.thoughtworks.blink;

public class SwitchPair {
    private static String[] teamMembers = new String[]{"Xiaoshuang", "Xiaoyun", "Kangzhe", "Zhuyu", "Zhenguang", "Shanil"};
    private static String[] pairOfPast = new String[]{"03", "25", "14"};

    public static void main(String[] args) {
        Pairs pairsOfPast = PairStore.getPairs();

        Scheduler scheduler = new Scheduler(pairsOfPast, Pair::firstMember);
        Pairs scheduledPairs = scheduler.schedule();

        PairStore.store(scheduledPairs);
        PairPrinter.print(scheduledPairs);
    }
}