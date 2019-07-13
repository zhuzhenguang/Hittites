package org.thoughtworks.blink;

import org.junit.jupiter.api.Test;

class SwitchPairTest {
    private final static Member zhenguang = new Member("zhenguang");
    private final static Member xiaoyun = new Member("xiaoyun");
    private final static Member xiaoshuang = new Member("xiaoshuang");
    private final static Member kangzhe = new Member("kangzhe");

    @Test
    void should_switch_pair() {
        Pairs pastPairs = new Pairs(
                new Pair(zhenguang, xiaoyun),
                new Pair(xiaoshuang, kangzhe));

        Scheduler scheduler = new Scheduler(pastPairs, Pair::firstMember);

        Pairs pairs = scheduler.schedule();
//        assertEquals(2, scheduledPairs.size());
//        assertEquals(Sets.newHashSet(new Pair(xiaoshuang, xiaoyun), new Pair(zhenguang, kangzhe)), scheduledPairs);
    }
}
