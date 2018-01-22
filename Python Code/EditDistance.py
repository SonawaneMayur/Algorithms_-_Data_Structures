# -*- coding: utf-8 -*-
"""
Created on Thu Sep 21 13:34:02 2017

@author: Mayur
"""

# A dynamic Programming using Edit Distance problam

def edt(X, Y):
    m = len(X)
    n = len(Y)
    
    # creating array to store the result
    dp = [[0 for i in range(n+1)] for x in range(m+1)]
    
    #fill the dp by bottom uo manner 
    for i in range(m+1):
        for j in range(n+1):
            
            
            if i == 0:
                dp[i][j] = j
                
            elif j == 0:
                dp[i][j] = i
                
            elif X[i-1] == Y[j-1]:
                dp[i][j] = dp[i-1][j-1]
                
            else: 
                dp[i][j] = 1+ min(dp[i][j-1],dp[i-1][j], dp[i-1][j-1])
                
    return dp[m][n]


X = "sunday"
Y= "saturday"

print(edt(X,Y))