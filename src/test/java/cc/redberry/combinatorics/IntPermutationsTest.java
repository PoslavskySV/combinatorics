package cc.redberry.combinatorics;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 */
public class IntPermutationsTest {

    @Test
    public void test1() {
        class IntArray {
            final int[] data;

            public IntArray(int[] data) {
                this.data = data;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                IntArray intArray = (IntArray) o;

                return Arrays.equals(data, intArray.data);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(data);
            }
        }
        IntPermutations ig = new IntPermutations(8);
        int num = 0;
        Set<IntArray> set = new HashSet<>(40320);
        IntArray a;
        while (ig.hasNext()) {
            ++num;
            a = new IntArray(ig.next().clone());
            Assert.assertTrue(!set.contains(a));
            set.add(a);
        }
        Assert.assertTrue(num == 40320);
    }

    @Test
    public void test2() {
        IntPermutations ig = new IntPermutations(0);
        Assert.assertTrue(ig.hasNext());
        Assert.assertTrue(ig.next().length == 0);
        Assert.assertTrue(!ig.hasNext());
    }
}
