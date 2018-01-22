# -*- coding: utf-8 -*-
"""
Created on Thu Sep 21 09:19:26 2017

@author: Mayur
"""
# Nieve recursive python implementation 
def lcs(X,Y, m, n ):
    
    if m ==0 or n ==0:
        return 0;
    elif X[m-1] == Y[n-1]:
        c = 1 + lcs(X,Y, m-1, n-1)
        print(c)
        return c
    else:
        return max(lcs(X,Y, m-1, n), lcs(X,Y, m, n-1))
    
    
# Dynamic approach to find Longest Common Sequence    
    
def lcs_d(X,Y):
    m = len(X)
    n = len(Y)
    
    # creating the array to store the DP(dynamic progrmming) value
    L = [[None]*(n+1) for i in range(m+1)]

    for i in range(m+1):
        for j in range(n+1):
            if i == 0 or j == 0:
                L[i][j] = 0
            elif X[i-1] == Y[j-1]:
                L[i][j] = L[i-1][j-1] + 1
            else:
                L[i][j] = max(L[i-1][j], L[i][j-1])
                
    return L[m][n]
    
    
X= "ABCDXY"
Y = "ADYHB"

print ("Lenght of LCS is ", lcs_d(X,Y))
print ("Lenght of LCS is ", lcs(X,Y, len(X), len(Y)))