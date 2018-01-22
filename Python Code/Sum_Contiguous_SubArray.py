# -*- coding: utf-8 -*-
"""
Created on Fri Oct 27 16:35:41 2017

@author: Mayur
"""

#code
def maxSubArray1(a, size):
    max_so_far = a[0]
    cur_max = a[0]
    
    for i in range(1, size):
        cur_max = max(a[i], cur_max + a[i])
        max_so_far = max(cur_max, max_so_far)
        
    return max_so_far

def lsc(a):
    N = len(a)
    if N < 1: 
        return 0
    if N == 1:
        return a[0]
    f = [x for x in a]
    for k in range(1,N):
        if f[k-1] > 0:
            f[k] += f[k-1]
    return max(f)

def maxSubArray(a,size):
    size = len(a)
    max_so_far = 0
    max_ending_here = 0
     
    for i in range(0, size):
        max_ending_here = max_ending_here + a[i]
        if max_ending_here < 0:
            max_ending_here = 0
         
        # Do not compare for all elements. Compare only   
        # when  max_ending_here > 0
        elif (max_so_far < max_ending_here):
            max_so_far = max_ending_here
             
    return max_so_far
    
#a= [-1, -1, 2, 3, 4, 5]
#print("Contiguous subarray max sum : ", maxSubArray(a, len(a)))
no_testcases = int(input(''))
a = []
for i in range(0, no_testcases):
    size = int(input())
    a.append((input()).split(' '))
    
for i in a:
    print(maxSubArray(list(map(int, i)), len(i)))