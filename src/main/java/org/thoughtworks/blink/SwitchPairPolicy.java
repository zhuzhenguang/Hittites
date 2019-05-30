package org.thoughtworks.blink;

@FunctionalInterface
public interface SwitchPairPolicy {
    Pair switchFrom(Pair pairOfPast);
}
