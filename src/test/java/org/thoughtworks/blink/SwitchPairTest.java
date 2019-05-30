package org.thoughtworks.blink;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchPairTest {
    private final static Member zhenguang = new Member("zhenguang");
    private final static Member xiaoyun = new Member("xiaoyun");
    private final static Member xiaoshuang = new Member("xiaoshuang");
    private final static Member kangzhe = new Member("kangzhe");

    @Test
    void should_switch_pair() {
        List<Pair> pairList = Lists.newArrayList(
                new Pair(zhenguang, xiaoyun),
                new Pair(xiaoshuang, kangzhe));

        Scheduler scheduler = new Scheduler(new Pairs(pairList), Pair::firstMember);

        Pairs pairs = scheduler.schedule();
//        assertEquals(2, scheduledPairs.size());
//        assertEquals(Sets.newHashSet(new Pair(xiaoshuang, xiaoyun), new Pair(zhenguang, kangzhe)), scheduledPairs);
    }
}
