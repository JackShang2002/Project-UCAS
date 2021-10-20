**CPEN 221 / Fall 2021 / Exercise 2**

# Upper-Case Alphabetic Strings and Patching Permutations

> The skeleton source code for this question is in the package `ucas`.

An upper-case alphabetic string, or UCAS, is a `String` that consists of only uppercase alphabetic characters (`A`, `B`, ..., `Z`). We will define the integer value of each alphabet as follows: `A = 0, B = 1, ..., Z = 25`. Each UCAS has a numeric identifier (an integer in base-26) that is defined as follows: if `s` is a UCAS and `s[i]` is the alphabet at position `i` then `id(s) = SUM(26^i s[i])` where positions are **little endian**, which means position 0 or the least significant position is at string index `s.length() - 1`. The summation in computing the `id` is over all `i` from `0` to `s.length()-1`.

Using the definition of `id(s)`, we have:

* `id("A") = 0`
* `id("C") = 2`
* `id("BA") = 26`
* `id("CCZ") = 1429 = 2*26*26 + 2*26 + 25*1`.

We now define UCAS sequence, `ucas_seq(n)`, of **n** elements as the first $n$ UCAS strings based on numeric string indentifiers : starting with id 0: `ucas_seq(6)` = "A", "B", "C", "D", "E", "F". 

A UCAS permutation of length $n$ is a permutation of the UCAS sequence of length `n`. For instance, "C", "A", "F", "D", "E", "B" is a permutation of length 6.

A punctured permutation is a permutation with some entries deleted: so "A", "F", "E", "B" is a punctured permutation of "C", "A", "F", "D", "E", "B".

## To Do

1. The primary goal of this exercise is to implement a function that returns the (lexicographically) smallest permutation of a given length that can be punctured to obtain a given punctured permutation. We compare two permutations using the [lexicographic order](https://en.wikipedia.org/wiki/Lexicographic_order). Thus the permutation "C", "A", "F", "D", "E", "B" is lexicographically smaller than "D", "A", "F", "C", "E", "B" because id("C") < id("D"). Both these permutations can be punctured to obtain "A", "F", "E", "B". You are given an implementation of the `UCAS` datatype. Each instance of `UCAS` represents a string of uppercase alphabetic strings. You need to implement the `static` method `patchPermutation`.  (Given a punctured permutation, we are trying to "patch" it.)
2. You should also implement the constructor for UCAS that takes a `String` as an argument and creates the appropriate UCAS.




## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries (in `java.util`) by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.



## Honour Code

By submitting your work to Github you agree to the following:

* You did not consult with any other person for the purpose of completing this activity.
* You did not aid any other person in the class in completing their activity.
* If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
* You are not aware of any infractions of the honour code for this activity.
