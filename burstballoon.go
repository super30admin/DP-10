// Time Complexity : O(n3)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a dp array of n*n
set length=1 and loop till its <= n
for i goes from 0 to n-length
j=i+length-1
for k goes from i to <=j
leftval, right val =1 default
if not corner cases i!=0 and j !=n-1 set leftval to nums[i-1], right val to nums[j+1] respectively
set before, after to 0 default
if k!=0, k!=n-1 set before = dp[i][k-1], after =dp[k+1][j] respectively
dp[i][j] = fmax(dp[i][j], before+leftVal*nums[k]*rightVal+after)

return dp[0][n-1]

if current is burst then its before value+leftval*curr*rightval + after value
*/
package main

import "fmt"

//n3
func maxCoins(nums []int) int {
	dp := make([][]int, len(nums))
	n := len(nums)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(nums))
	}
	for length := 1; length <= n; length++ {
		for i := 0; i <= n-length; i++ {
			j := i + length - 1
			for k := i; k <= j; k++ {
				leftVal := 1
				rightVal := 1
				if i != 0 {
					leftVal = nums[i-1]
				}
				if j != n-1 {
					rightVal = nums[j+1]
				}
				before := 0
				after := 0
				if k != 0 {
					before = dp[i][k-1]
				}
				if k != n-1 {
					after = dp[k+1][j]
				}
				dp[i][j] = fmax(dp[i][j], before+leftVal*nums[k]*rightVal+after)
			}
		}
	}
	return dp[0][n-1]
}

func fmax(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func MainBurstBalloon() {
	fmt.Println(maxCoins([]int{3, 1, 5, 8})) //expected 167
}
