package org.thoughtworks.blink;

@FunctionalInterface
interface WhoStayInPairPolicy {
    Member whoStayInPair(Pair pair);
}
