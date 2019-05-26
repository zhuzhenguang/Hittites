package org.thoughtworks.blink;

import java.util.List;

class Pairs {
    private List<Pair> pairList;

    Pairs(List<Pair> pairList) {
        this.pairList = pairList;
    }

    Pair next(Pair pair) {
        int index = pairList.indexOf(pair);
        if (index != pairList.size() - 1) {
            return pairList.get(index + 1);
        } else {
            return pairList.get(0);
        }
    }
}
