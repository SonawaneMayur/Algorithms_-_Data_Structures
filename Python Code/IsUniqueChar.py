# -*- coding: utf-8 -*-
"""
Created on Tue Dec 26 20:56:43 2017

@author: Mayur
"""

def isUniqueChars(c):
    if len(c) > 128:
        return False
    char_set = [0]*128
    for i in range(0, len(c)):
        t = ord(c[i])
        if char_set[t] == 1:
            return False
        char_set[t] = 1
        
    return True


def isUniqueChars(c):
    a = sorted(c)
    for i in range(1,len(a)):
        if a[i] == a[i-1]:
            return False
    return True

c = "abcdefga"
print(isUniqueChars(c))