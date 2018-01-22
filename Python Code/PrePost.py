# -*- coding: utf-8 -*-
"""
Created on Sat Oct 28 20:51:59 2017

@author: Mayur
"""

def pretoPost(prefix):
    
    N = len(prefix)
    
    op = []
    ch = []
    postfix = ''
    for i in range(N):
        if prefix[i] in "/*+-":
            op.append(prefix[i])
        else: 
            if i > 0:
                ch.append(prefix[i])
            else: postfix = prefix[i]
        
        if len(op) >= 1 and len(ch) == 1 and i < N:
            postfix += ch.pop() + op.pop()
            
        
    
    
    return postfix

a = pretoPost('A+B*C/D')
print(a)