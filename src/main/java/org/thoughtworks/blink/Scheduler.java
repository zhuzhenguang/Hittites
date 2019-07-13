package org.thoughtworks.blink;

class Scheduler {
    private Pairs pastPairs;
    private WhoStayInPairPolicy memberStayInPairPolicy;

    Scheduler(Pairs pastPairs, WhoStayInPairPolicy whoStayInPairPolicy) {
        this.pastPairs = pastPairs;
        this.memberStayInPairPolicy = whoStayInPairPolicy;
    }

    Pairs schedule() {
        SwitchPairPolicy switchPairPolicy = pastPair -> {
            Member memberOfStayInPair = memberStayInPairPolicy.whoStayInPair(pastPair);
            Pair next = pastPairs.next(pastPair);
            Member memberOfLeaveNextPair = next.companionOf(memberStayInPairPolicy.whoStayInPair(next));
            return new Pair(memberOfStayInPair, memberOfLeaveNextPair);
        };

        return pastPairs.switchPairs(switchPairPolicy);
    }

}
