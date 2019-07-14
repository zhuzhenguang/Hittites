package org.thoughtworks.blink;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchPairTest {
    private final static Member zhenguang = new Member("zhenguang");
    private final static Member xiaoyun = new Member("xiaoyun");
    private final static Member xiaoshuang = new Member("xiaoshuang");
    private final static Member kangzhe = new Member("kangzhe");

    @Test
    void should_switch_pair() {
        List<Member> allMembers = Arrays.asList(zhenguang, xiaoyun, xiaoshuang, kangzhe);
        Pairs pastPairs = new Pairs(
                new Pair(zhenguang, xiaoyun),
                new Pair(xiaoshuang, kangzhe));
        Scheduler scheduler = new Scheduler(pastPairs, Pair::firstMember);

        Pairs scheduledPairs = scheduler.schedule();

        assertEquals(new Pairs(
                new Pair(zhenguang, kangzhe),
                new Pair(xiaoshuang, xiaoyun)).toString(allMembers), scheduledPairs.toString(allMembers));
    }
}
