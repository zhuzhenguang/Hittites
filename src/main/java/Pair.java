import java.util.Objects;

class Pair {
    private Member first;
    private Member second;

    Pair(Member first, Member second) {
        this.first = first;
        this.second = second;
    }

    boolean hasDuplicateMembers() {
        return first == second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return (Objects.equals(first, pair.first) && Objects.equals(second, pair.second)) ||
                (Objects.equals(first, pair.second) && Objects.equals(second, pair.first));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return first + "-" + second;
    }

    boolean containsMemberOf(Pair newPair) {
        return contains(newPair.first) || contains(newPair.second);
    }

    private boolean contains(Member member) {
        return first.equals(member) || second.equals(member);
    }
}
