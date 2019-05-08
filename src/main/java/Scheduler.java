import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

class Scheduler {
    private Set<Pair> pairsOfPast;
    private Set<Pair> currentPairs = new HashSet<>();
    private Set<Member> allMembers;

    Scheduler(Set<Pair> pairsOfPast, Set<Member> allMembers) {
        this.pairsOfPast = pairsOfPast;
        this.allMembers = allMembers;
    }

    Set<Pair> Schedule() {
        int countOfPairs = allMembers.size() / 2;
        IntStream.range(0, countOfPairs).forEach(i -> currentPairs.add(generatePair()));
        return currentPairs;
    }

    private Pair generatePair() {
        Member[] members = allMembers.toArray(new Member[]{});

        while (true) {
            int firstNumber = new Random().nextInt(allMembers.size());
            int secondNumber = new Random().nextInt(allMembers.size());
            Pair newPair = new Pair(members[firstNumber], members[secondNumber]);

            if (newPair.hasDuplicateMembers()) {
                continue;
            }

            if (pairsOfPast.contains(newPair)) {
                continue;
            }

            if (currentPairs.stream().anyMatch(currentPair -> currentPair.containsMemberOf(newPair))) {
                continue;
            }

            return newPair;
        }
    }
}
