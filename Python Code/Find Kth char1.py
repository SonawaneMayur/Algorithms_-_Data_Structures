# -*- coding: utf-8 -*-
"""
Created on Thu Sep 28 14:32:05 2017

@author: Mayur
"""

t = int(input())

for l in range(0, t):
    x = input().split(" ")
    m = int(x[0])
    k = int(x[1])
    n = int(x[2])

    binaryR = bin(m)[2:]

    for i in range(0, n):
        strx = ""
        for c in binaryR:
            if c == '0':
                strx = strx + "01"
            else:
                strx = strx + "10"
        binaryR = strx
    print(binaryR[k])