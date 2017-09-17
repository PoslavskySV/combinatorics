[![Build Status](https://travis-ci.org/PoslavskySV/combinatorics.svg?branch=master)](https://travis-ci.org/PoslavskySV/combinatorics)

# Combinatorics for Java
`Combinatorics` effectively implements a number of combinatorial algorithms for enumerating (without in-memory storing) of different types of combinations.

### Permutations

Enumerate all possible permutations of a set of elements (note that intermediate permutations which are N! are not stored in memory, instead each following permutation is calculated on the invocation of `next()`):

```java

// will print all 3! = 6 permutations [0, 1, 2], [0, 2, 1], ....
Combinatorics.permutations(3)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);

// will print all 3! = 6 permutations ["a", "b", "c"], ["a", "c", "b"], ....
Combinatorics.permutations(new String[]{"a", "b", "c"})
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);
  
```

### Combinations

Enumerate all possible unordered combinations of `k` elements chosen from `n` (note that intermediate combinations which are n!/(n-k)!/k! are not stored in memory, instead each following combinations is calculated on the invocation of `next()`):

```java

// will print all 3!/2! = 3 unordered 2-combinations [0, 1], [0, 2] and [1, 2]
Combinatorics.combinations(3, 2)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);

// will print all 3!/2! = 3 unordered 2-combinations ["a", "b"], ["a", "c"] and ["b", "c"]
Combinatorics.combinations(new String[]{"a", "b", "c"}, 2)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);
  
```

### Combinations with permutations

Enumerate all possible ordered combinations of `k` elements chosen from `n` (note that intermediate combinations which are n!/(n-k)! are not stored in memory, instead each following combinations is calculated on the invocation of `next()`):

```java

// will print all 3!/(3-2)! = 6 2-combinations [0, 1], [1, 0], [0, 2], ...
Combinatorics.combinationsWithPermutations(3, 2)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);

// will print all 3!/(3-2)! = 6 2-combinations ["a", "b"], ["b", "a"], ["a", "c"], ...
Combinatorics.combinationsWithPermutations(new String[]{"a", "b", "c"}, 2)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);
  
```

### Balls in boxes

Enumerate all possible compositions of integer number into `n` partitions:

```java

// print all possible representations of 7 as a sum 
// of three smaller numbers: 0 + 0 + 7, 0 + 1 + 6, 0 + 2 + 5,  ...
Combinatorics.compositions(7, 3)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);
    
```

### Tuples

Enumerate all possible tuples formed by elements chosen from array of sets:

```java

// print all possible tuples [e1, e2, e3] where 0 <= e1 < 3,
// 0 <= e2 < 4 and 0 <= e3 < 5: [0, 0, 0], [0, 0, 1], ... [2, 3, 4]
Combinatorics.tuples(3, 4, 5)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);


// print all possible tuples with elements [e1, e2, e3] where e1 is chosen from set1,
// e2 is chosen from set2 and e3 from set3: ["a", "a", "1"], ["a", "a", "2], ..., ["c", "e", "4"]
String[] set1 = {"a", "b", "c"};
String[] set2 = {"a", "c", "d", "e"};
String[] set3 = {"1", "2", "3", "4"};
Combinatorics.tuples(set1, set2, set3)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);
}

```

### Distinct tuples

Enumerate all possible distinct tuples formed by elements chosen from array of sets:

```java

// print all possible distinct tuples with elements [e1, e2, e3] where e1 is chosen from set1
// and e2 from set2 and e3 from set3: [0, 2, 7], [0, 2, 8], ..., [2, 3, 9]
int[] set1 = {0, 1, 2};
int[] set2 = {0, 2, 3};
int[] set3 = {9, 8, 7, 2};
Combinatorics.distinctTuples(set1, set2, set3)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);
    
// print all possible tuples with elements [set1[i1], set2[i2], set[i3]] where i1 != i2 != i3 
// are positions in set1,  set2 and set3: ["a", "c", "2"], ["a", "c", "3"], ...
String[] set1 = {"a", "b", "c"};
String[] set2 = {"a", "c", "d", "e"};
String[] set3 = {"1", "2", "3", "4", "5"};
Combinatorics.distinctTuples(set1, set2, set3)
    .stream()
    .map(Arrays::toString)
    .forEach(System.out::println);    
    
```

## Historical note

The code was initially written for the Redberry computer algebra system (redberry.cc), but then was moved into a separate artifact.

## Maven

```xml
<dependency>
    <groupId>cc.redberry</groupId>
    <artifactId>combinatorics</artifactId>
    <version>2.0</version>
</dependency>
```

## License

Apache License, Version 2.0 http://www.apache.org/licenses/LICENSE-2.0.txt
