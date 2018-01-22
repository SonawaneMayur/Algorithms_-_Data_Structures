# -*- coding: utf-8 -*-
"""
Created on Thu Sep 28 17:52:11 2017

@author: Mayur
"""

#code
def getKthBit(bin_digit, blockId, offset):
    seed_value = int(bin_digit[blockId])
    if seed_value:
        return (1^(bin(offset).count('1') % 2))
    else:
        return ((bin(offset).count('1')) % 2)
        
for i in range(int(input())):
    m, k, n = [int(i) for i in input().strip().split()]
    bin_m = bin(m)[2:]
    pow_n = 1 << n
    q, r = divmod(k, pow_n)
    print(getKthBit(bin_m, q,r))