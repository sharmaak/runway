## Overview 
As per [wikipedia](https://en.wikipedia.org/wiki/Change-making_problem), Coin Change problem is a special case of 
Knapsack-0-1 problem. 


## Using The Rod Cutting Approach and Why It Does Not Work
We select a coin, say we pick up coin `Ci`.
So now our problem changes to number of ways change can be generated for amount `(n-Ci)`
Now we may choose different coin variations. If the selected variation can provide change, the subproblem
will converge to finding change for `0`. Once we encounter `0`, we return `1` - we found a solution. If we
encounter negative number, it means the given change variation can not provide change. So we return `0`.

If you look at the recursion tree of the problem below, it is obvious that it generates all permutations of the
change. For example, in the recursion tree below it generates `{1,1,1,1}, {1,1,2}, {1,2,1}, {2,2}, {3,1}`. Clearly, 
`{1,1,2} and {1,2,1}` are the same. 

### Recursion Tree

    S = [ 1, 2, 3]
    N = 4

                                                         f(4)
                                                          |
                     .------------------------------------+-----------.--------------------.
                  1 /                                                  \2                   \3
                   f(3)                                                f(2)                  f(1)
                    |                                                   |                    |
                .---+-------------------.---------------.           .-.-+--.             .-.-+---.
              1/                         \2              \3       1/   \2   \3         1/   \2    \3
             f(2)                       f(1)            f(0)     f(1) f(0) f(-1)      f(0) f(-1) f(-2)
               |                         |
             .-+-------.---.            .-.-----.
           1/           \2  \3         /1  \2    \3
          f(1)          f(0) f(-1)  f(0) f(-1) f(-2)
            |
        .-.-+---.
      1/   \2    \3
    f(0) f(-1) f(-2)


## The Solution To Produce Distinct Change
The approach is to pick a change-denomination (aka coin) and include it one solution, and 
exclude it in the other solution. If we include coin, say `Ci`, then we need to solve
the same problem for amount `N-Ci`. For case of excluding coin `Ci`, we simply remove it 
from coin set `S`. The removal of a coin is done by simply decreasing the effective range 
of array - we start with the largest index and keep on decrementing it till the array 
becomes empty. 

The approach is a bit counterintuitive initially, but once you think about it, its states
the obvious :-) We either include a coin for change, or we don't. If we include, we have a
new target amount decremented by the value of coin we selected. If we don't include 
a given coin, we simply remove it from the coin set. 

As for the termination condition of recursion, we return `1` if the target amount becomes
`0` - this implies that we were able to generate exact change from the changes we selected.
If the target amount becomes negative, or we run out of coins (the coin set becomes empty),
we return `0`, because this path could not generate exact change.  

If you look at the recursion tree of the problem below, it is obvious that it generates 
distinct combinations of change `{3,1}, {2,1,1}, {2,2}` (backtrack from all leaf nodes 
where we see `f(0)` and pick all numbers shown on edges).

## Recursion Tree 

    S = [ 1, 2, 3]
    N = 4

                          f(4,{1,2,3})
                                |
            .-------------------+-----------------.
         3 /                                       \
      f(1,{1,2,3})                             f(4,{1,2})
            |                                       |
         .--+--.                           .--------+-------.
      3 /       \                       2 /                  \
      f(-2)  f(1,{1,2})             f(2,{1,2})             f(4,{1})
            2 /      \             2 /       \             /      \ 1
           f(-1)   f(1,{1})        f(0)   f(2,{1})      f(4,{})   f{3,{1}}
                  1 /    \               1 /     \                /     \ 1
                  f(0)  f(1,{})       f(1,{1})  f(2,{})        f(3,{})  f(2,{1})
                                     1 /     \                           /     \ 1
                                     f(0)  f(1,{})                  f(2,{})    f(1,{1})
                                                                                /     \ 1
                                                                           f(1,{})    f(0)


## Bibliography 
 - https://www.techiedelight.com/coin-change-problem-find-total-number-ways-get-denomination-coins/
 - 