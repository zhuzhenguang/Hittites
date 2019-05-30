package org.thoughtworks.blink;

class Scheduler {
    private Pairs pairs;
    private WhoStayInPairPolicy memberStayInPairPolicy;

    Scheduler(Pairs pairs, WhoStayInPairPolicy whoStayInPairPolicy) {
        this.pairs = pairs;
        this.memberStayInPairPolicy = whoStayInPairPolicy;
    }

    Pairs schedule() {
        SwitchPairPolicy switchPairPolicy = pastPair -> {
            Member memberOfStayInPair = memberStayInPairPolicy.whoStayInPair(pastPair);
            Pair next = pairs.next(pastPair);
            Member memberOfLeaveNextPair = next.companionOf(memberStayInPairPolicy.whoStayInPair(next));
            return new Pair(memberOfStayInPair, memberOfLeaveNextPair);
        };

        return pairs.switchPairs(switchPairPolicy);
    }

}
