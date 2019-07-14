package org.thoughtworks.blink;

public class SwitchPair {
    public static void main(String[] args) {
        Pairs pairsOfPast = PairStore.getPairs();

        Scheduler scheduler = new Scheduler(pairsOfPast, Pair::firstMember);
        Pairs scheduledPairs = scheduler.schedule();

        PairStore.store(scheduledPairs);
        PairPrinter.print(scheduledPairs);
    }
}