//
//  BurstBalloons.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/23/26.
//

/*
 [3, 2, 5, 8]
 if we burst balloon 2 first -> then points achieved = 3 * 2 * 5
 then 5 -> 3 * 5 * 8 because has already been bursted
 then 8 -> 5 * 8 * 1
 then 3 -> 1 * 3 * 1 because 2 5 8 have already been bursted
 [this is one of the permutation. There can be many other permutations. Do it in a way to maximize the profit.]
 
 */
class BurstBalloons {
    
    //time complexity - O(n^3), space - O(n^2)
    func maxCoins(_ nums: [Int]) -> Int {
        let n = nums.count
        var dp = Array(repeating: Array(repeating: -1, count: n), count: n)
        
        //O(n)
        for l in 1...n {
            //take i length element - 1, 2, 3 or 4 ... length upto n length
            
            //O(n)
            for i in 0...(n-l) {
                var j = i + l - 1 //end index of burstible array

                //go over each and every burstible array
                var maxPoints = Int.min
                //O(n)
                for k in i...j {
                    //before - points received on the left
                    //after = points received on the right
                    //kth balloon being burst in the end
                    var before = 0 //if no balloon is left on left for bursting then
                    //if k == i means nothing on the left side
                    if (k != i) {
                        before = dp[i][k - 1]
                    }

                    var after = 0
                    if (k != j) {
                        after = dp[k + 1][j]
                    }
                    
                    var current = nums[k]
                    var left = 1
                    if (i != 0) {
                        //if starting address not equal to 0
                        left = nums[i - 1]
                    }
                    var right = 1
                    if (j != nums.count - 1) {
                        right = nums[j + 1]
                    }
                    // let total = before + current + after
                    let total = before + left * current * right + after
                    maxPoints = max(maxPoints, total)
                }
                dp[i][j] = maxPoints
            }
        }
        return dp[0][n - 1]
    }
    
    //Memoization solution
    //Time complexity - O(n^3), space compelxity - O(n^2)
    var memo = [[Int]]()
    
    func maxCoinsUsingMemoization(_ nums: [Int]) -> Int {
        let n = nums.count
        memo = Array(repeating: Array(repeating: -1, count: n), count: n)
        return helper(nums: nums, i: 0, j: n - 1)
    }

    func helper(nums: [Int], i: Int, j: Int) -> Int {
        //base
        if (i > j) {
            return 0
        }

        if (memo[i][j] != -1) {
            return memo[i][j]
        }
        var maxPoints = Int.min
        for k in i...j {
            //before
            var before = 0
            //if k is not equal to very first element of burstible array
            if (k != i) {
                before = helper(nums: nums, i:i, j: k - 1)
            }
            var after = 0
            if (k != j) {
                after = helper(nums: nums, i: k + 1, j: j)
            }

            var left = 1
            if (i != 0) {
                left = nums[i - 1]
            }

            var right = 1
            if (j != nums.count - 1) {
                right = nums[j + 1]
            }
            maxPoints = max(maxPoints, before + left * nums[k] * right + after)
        }
        memo[i][j] = maxPoints
        return maxPoints
    }
}
