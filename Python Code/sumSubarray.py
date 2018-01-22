# -*- coding: utf-8 -*-
"""
Created on Sat Oct 28 13:54:16 2017

@author: Mayur
"""
t= int(input())
a,z =0,0
for i in range(t):
    size,exp_sum = list(map(int,input().split()))
    arr = list(map(int, input().split()))
    a,z = subSub(arr, exp_sum)
    print(a, z)


def subSub(arr, exp_sum):
    actual_sum = 0
    start = 0
    end = 0
    for i in range(len(arr)):
        
        if actual_sum > exp_sum and i < len(arr):
            actual_sum -= arr[start]
            start += 1    
        
        
        if actual_sum == exp_sum:
            end = i
            return start+1,end
            
        actual_sum += arr[i]
        
        
            
        
    return start,end
        



            
        
