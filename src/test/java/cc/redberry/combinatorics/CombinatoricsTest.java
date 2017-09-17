package cc.redberry.combinatorics;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stanislav Poslavsky
 * @since 1.0
 */
public class CombinatoricsTest {
    @Test
    public void test1() throws Exception {
        String[] array = {"a", "b", "c", "d"};
        Assert.assertEquals(12, Combinatorics.combinationsWithPermutations(array, 2).toList().size());
        Assert.assertEquals(6, Combinatorics.combinations(array, 2).toList().size());
        Assert.assertEquals(24, Combinatorics.permutations(array).toList().size());
        String[] array2 = {"a", "b", "c", "d", "e"};
        Assert.assertEquals(16, Combinatorics.distinctTuples(array, array2).toList().size());
        Assert.assertEquals(20, Combinatorics.tuples(array, array2).toList().size());
    }
}