package cc.redberry.combinatorics;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static cc.redberry.combinatorics.Combinatorics.arrayComparator;

/**
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 */
public class IntCombinationsTest {
    @Test
    public void test0() {
        Set<int[]> expected = new TreeSet<>(arrayComparator);
        expected.add(new int[]{0, 1, 2});
        expected.add(new int[]{0, 1, 3});
        expected.add(new int[]{0, 1, 4});
        expected.add(new int[]{0, 2, 3});
        expected.add(new int[]{0, 2, 4});
        expected.add(new int[]{0, 3, 4});
        expected.add(new int[]{1, 2, 3});
        expected.add(new int[]{1, 2, 4});
        expected.add(new int[]{1, 3, 4});
        expected.add(new int[]{2, 3, 4});

        Set<int[]> actual = new TreeSet<>(arrayComparator);
        for (int[] combination : new IntCombinations(5, 3))
            actual.add(combination.clone());

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test1() {
        IntCombinations gen = new IntCombinations(1, 1);
        Assert.assertTrue(gen.hasNext());
        Assert.assertTrue(Arrays.equals(new int[]{0}, gen.next()));
        Assert.assertTrue(!gen.hasNext());
    }
}
