//
//  SuperEggDrop.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/23/26.
//

/*
 n floors
 k eggs
 find the floor number at or below which the dropping of egg wouldn't break
 //get the floor number in minimum no of steps / tries
 
 time complexity ->  (n^2) * k
 at each and every floor, we are exploring all the floors. For each floor, there are 2 cases, the egg is broken or the egg is not broken.
 If broken then explore the below floors
 If not broken, then explore the above floors.
 k - eggs
 
 this DP solution - time limit exceeded
 Exhaustive solution -> will be recursive solution
 here once, we select the set of floors, we permute on the floors, with break and no break.
 We take max (break scenario, no break scenario). After collecting value of this for each floor, take minimum of it.
 This looping through all foors was taking n^2.
 Hence time complexity is becoming n^2 * k
 In optimized solution, we are not permuting on the floors. We are just calculating based on no of attepmts and the no of eggs, how many floors we can cover. Once the entry becomes noOfFloors or more than it, we got the answer.
 */

class SuperEggDrop {
    
    init() {
        let minMoves = superEggDrop(1, 2)
        print("minMoves \(minMoves)")
    }
    
    func superEggDrop(_ k: Int, _ n: Int) -> Int {
        var dp = Array(repeating: Array(repeating: 0, count: n + 1), count: k + 1)
        if (k == 1) {
            return n
        }
        
        //fill the first row and first column by 0
        //with 0 floors and 0, 1, ,2 ,3, eggs , we can make 0 attempts
        //with 0 eggs and 0, 1, 2, 3, 4, 5... floors, we can make 0 attempts
        //goinf through columns
        for j in 1..<n {
            dp[1][j] = j //for 1st row, for egg1 and all floors
        }
        
        //iteration through eggs - roes
        for i in 2...k {
            //itrate thrught columns - i.e. floors
            for j in 1...n {
                //then iterate through all the floors and take max of the worst case at each floor.
                //then take minimum of all the worst case values at each floor
                var minAttempts = 99999
                for f in 1...j {
                    //            no break scenario   break
                    let curr = 1 + max(dp[i][j - f], dp[i - 1][f-1])
                    minAttempts = min(minAttempts, curr)
                }
                dp[i][j] = minAttempts
            }
        }
        return dp[k][n]
    }
    
    
    
    /*
     better solution -
     take a DP matrix. At rows -> no of attempts
     at columns -> no of eggs
     considering the no of attempts and the no of eggs, how many floors I can cover. What best we can do? fill the matrix
     Once, the value in any cell is equal to or greater than 6 (total no of floors).  Stop. Reached answer
     
     time complexity -> O(n * k)
     n - no of floors
     k - no of eggs
     
     attempts -> in rows
     eggs -> columns
     
     ather than gtoin from floors and eggs to attempts, we are going to floors from attempts and eggs
     
     */
    
    //time compelxity -> O(n * k),  space complexity -> O(n * k)
    func superEggDropOptimizedWithTwoDMtarix(_ k: Int, _ n: Int) -> Int {
        if (k == 1) {
            return n
        }
        var dp = Array(repeating: Array(repeating: 0, count: k + 1), count: n + 1)
        var attempts = 0
        //top row
        while (dp[attempts][k] < n) {
            attempts += 1
            //loop through columns
            for j in 1...k {
                dp[attempts][j] = 1 + dp[attempts - 1][j] + dp[attempts - 1][j - 1]
            }
        }
        return attempts
    }
    
    //time compelxity -> O(n * k), space compelxity -> O(k)
    func superEggDropOptimizedWithOneDimensionalArray(_ k: Int, _ n: Int) -> Int {
        if (k == 1) {
            return n
        }
        var dp = Array(repeating: 0, count: k + 1)
        var attempts = 0
        //top row
        while (dp[k] < n) {
            attempts += 1
            var diagUp = 0
            //loop through columns
            for j in 1...k {
                let temp = dp[j]
                dp[j] = 1 + dp[j] + diagUp
                diagUp = temp
            }
        }
        return attempts
    }
}
