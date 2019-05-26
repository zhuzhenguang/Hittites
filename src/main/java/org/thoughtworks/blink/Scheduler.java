package org.thoughtworks.blink;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

class Scheduler {
    private Set<Pair> pastPairs;
    private WhoStayInPairPolicy memberStayInPairPolicy;

    Scheduler(Set<Pair> pastPairs, WhoStayInPairPolicy memberStayInPairPolicy) {
        this.pastPairs = pastPairs;
        this.memberStayInPairPolicy = memberStayInPairPolicy;
    }

    Set<Pair> schedule() {
        Pairs pairs = new Pairs(new ArrayList<>(pastPairs));

        return pastPairs.stream().map(pastPair -> {
            Member memberOfStayInPair = memberStayInPairPolicy.whoStayInPair(pastPair);

            Pair next = pairs.next(pastPair);
            Member memberOfLeaveNextPair = next.companionOf(memberStayInPairPolicy.whoStayInPair(next));

            return new Pair(memberOfStayInPair, memberOfLeaveNextPair);
        }).collect(Collectors.toSet());
    }

}
