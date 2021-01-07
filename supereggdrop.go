// Time Complexity : O(KN)
// Space Complexity : O(KN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a dp array with attempts as rows and eggs as columns with extra row, column
set attempts = 0
while dp[attempts][k]<n do till we reach the max number of floors possible with given k
increment attempts
check for each egg
dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j] //we have 1 less attempt and 1 less j if egg breaks and j if egg does not break
return attempts
*/
package main

import "fmt"

func superEggDrop(K int, N int) int {
	if N == 0 || K == 0 {
		return 0
	}
	/*
	   //k*n2 soln floors as columns, eggs as rows
	   dp := make([][]int, K+1)
	   for i:=0;i<len(dp);i++ {
	       dp[i] = make([]int, N+1)
	   }
	   MAX := 1000000
	   //0th row, col are 0
	   //1st row will be j
	   for j:=0;j<len(dp[0]);j++ {
	       dp[1][j] = j
	   }
	   for i:=2;i<len(dp);i++ {
	       for j:=1;j<len(dp[0]);j++ {
	           dp[i][j] = MAX
	           for l:=1;l<=j;l++ {
	               dp[i][j] = fmin(dp[i][j], 1+fmax(dp[i-1][l-1], dp[i][j-l]))//break vs no break scenario
	           }
	       }
	   }
	   return dp[K][N]*/

	//kn soln attempts vs eggs soln -> find no of floors that can be covered with those many eggs and attempts
	dp := make([][]int, N+1) //not same dp array as before
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, K+1)
	}
	attempts := 0
	for dp[attempts][K] < N {
		attempts++
		for j := 1; j <= K; j++ {
			dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j]
		}
	}
	return attempts
}

/*func fmax(a, b int) int {
	if a > b {
		return a
	}
	return b
}*/

func fmin(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func MainSuperEggDrop() {
	fmt.Println(superEggDrop(3, 14)) //expected 4
}
