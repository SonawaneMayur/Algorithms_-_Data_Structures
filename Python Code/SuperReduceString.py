# -*- coding: utf-8 -*-
"""
Created on Thu Dec 21 12:28:00 2017

@author: Mayur
"""
"""
Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after operation.

Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Steve out by finding and printing 's non-reducible form!

Note: If the final string is empty, print Empty String .
"""


def pr(n):
    print(n)
    if(n == 0):
        #print(n)
        return
    pr(n-1)
    print(n)
    
    
    
import sys

def super_reduced_string(s):
    # Complete this function
    a= s
    i = 1
    while i < len(a):
        #print(a[:i-1]+a[i+1:])
        #if i >= len(a): pass
        if a[i] == a[i-1] and i < len(a):
              a = a[:i-1]+ a[i+1:]
              #print(a)
              i =0
        i = i+1
            
    if len(a) == 0:
        #print("Empty")
        return "Empty String" 
    else:
       # print(a)
        return a

s = "baab"
result = super_reduced_string(s)
print(result)