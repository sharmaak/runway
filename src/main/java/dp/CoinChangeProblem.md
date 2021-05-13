
## Approach 

We select a coin, say we pick up coin `Ci`.
So now our problem changes to number of ways change can be generated for amount `(n-Ci)`
Now we may choose different coin variations. If the selected variation can provide change, the subproblem
will converge to finding change for `0`. Once we encounter `0`, we return `1` - we found a solution. If we
encounter negative number, it means the given change variation can not provide change. So we return `0`.


## Recursion Tree

    S = [ 1, 2, 3]
    N = 4

                                                         f(4)
                                                          |
                     .------------------------------------+-----------.--------------------.
                    /                                                  \                    \
                   f(3)                                                f(2)                  f(1)
                    |                                                   |                    |
                .---+-------------------.---------------.           .-.-+--.             .-.-+---.
               /                         \               \         /   \    \           /   \     \
             f(2)                       f(1)            f(0)     f(1) f(0) f(-1)      f(0) f(-1) f(-2)
               |                         |
             .-+-------.---.            .-.-----.
            /           \   \          /   \     \
          f(1)          f(0) f(-1)  f(0) f(-1) f(-2)
            |
        .-.-+---.
       /   \     \
    f(0) f(-1) f(-2)


1,2
1,1,1
3

1,1,1
1,2
2,1
3