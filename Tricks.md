### Recursion
- Base condition : Think of the smallest valid input i.e size=0 etc

- Make the input smaller

- Draw the choice diagram

- parameters of the method are the inputs to the problem


### Memoization (Bottoms up)
- The dimension/size of the dp array depends on which values are changing recursion above eg. m and n for LCS problem, n and W for Knapsack


### Tabulation (Top down)
- base condition of recursion/memoization becomes initialization steps of Top down
    - eg. for i=0 and j=0 set values to 0 in LCS problem
    - eg. for W=0 set 1, for n=0 set 0 in Knapsack

- m becomes i and n becomes j in for loop
- When using Integer.MAX_VALUE to return, do -1 so that it doesn't overflow
