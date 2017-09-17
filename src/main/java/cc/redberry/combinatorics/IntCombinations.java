package cc.redberry.combinatorics;

/**
 * Iterator over all unordered combinations (i.e. [0,1] and [1,0] are considered as same, so only [0,1] will appear in
 * the sequence) of {@code k} numbers, which can be chosen from the set of {@code n} numbers (0,1,2,...,{@code n}). The
 * total number of such combinations is a binomial coefficient {@code n!/(k!(n-k)!)}. Each returned array is sorted.
 *
 * <p>The iterator is implemented such that each next combination will be calculated only on the invocation of method
 * {@link #next()}.
 *
 * <p><b>Note:</b> method {@link #next()} returns the same reference on each invocation.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @see IntCombinationsWithPermutations
 * @since 1.0
 */
public final class IntCombinations
        extends IntCombinatorialIterator {
    private static final long serialVersionUID = -2446688661078690111L;
    final int[] combination;
    private final int n, k;
    private boolean onFirst = true;

    /**
     * Constructs the iterator with the desired n and k
     */
    public IntCombinations(int n, int k) {
        if (n < k)
            throw new IllegalArgumentException(" n < k ");
        this.n = n;
        this.k = k;
        this.combination = new int[k];
        reset();
    }

    @Override
    public boolean hasNext() {
        return onFirst || !isLast();
    }

    @Override
    public void reset() {
        onFirst = true;
        for (int i = 0; i < k; ++i)
            combination[i] = i;
    }

    private boolean isLast() {
        for (int i = 0; i < k; ++i)
            if (combination[i] != i + n - k)
                return false;
        return true;
    }

    @Override
    public int[] next() {
        if (onFirst)
            onFirst = false;
        else {
            int i;
            for (i = k - 1; i >= 0; --i)
                if (combination[i] != i + n - k)
                    break;
            int m = ++combination[i++];
            for (; i < k; ++i)
                combination[i] = ++m;
        }
        return combination;
    }

    /**
     * @throws UnsupportedOperationException always
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int[] current() {
        return combination;
    }
}
