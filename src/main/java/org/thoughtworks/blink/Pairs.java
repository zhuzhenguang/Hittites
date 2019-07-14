package org.thoughtworks.blink;

import java.util.*;
import java.util.stream.Collectors;

class Pairs {
    private List<Pair> pairList;

    Pairs(Collection<Pair> pairList) {
        this.pairList = new ArrayList<>(pairList);
    }

    Pairs(Pair... pairs) {
        this.pairList = Arrays.asList(pairs);
    }

    Pair next(Pair pair) {
        int index = pairList.indexOf(pair);
        if (index != pairList.size() - 1) {
            return pairList.get(index + 1);
        } else {
            return pairList.get(0);
        }
    }

    List<Member> membersWhoLeaveThePair(WhoStayInPairPolicy whoStayInPairPolicy) {
        return pairList.stream()
                .map(pair -> pair.companionOf(whoStayInPairPolicy.whoStayInPair(pair)))
                .collect(Collectors.toList());
    }

    Pairs switchPairs(SwitchPairPolicy switchPairPolicy) {
        Collection<Pair> currentPairSet = pairList.stream().map(switchPairPolicy::switchFrom).collect(Collectors.toList());
        return new Pairs(currentPairSet);
    }

    void print() {
        pairList.forEach(System.out::println);
    }

    String toString(List<Member> allMembers) {
        return pairList.stream()
                .map(pair -> allMembers.indexOf(pair.firstMember()) + "" + allMembers.indexOf(pair.secondMember()))
                .collect(Collectors.joining(","));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pairs pairs = (Pairs) o;
        return Objects.equals(pairList, pairs.pairList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairList);
    }
}
