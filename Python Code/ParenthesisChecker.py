# -*- coding: utf-8 -*-
"""
Created on Wed Dec 27 16:00:08 2017

@author: Mayur
"""
"""
Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

 

Input:

The first line of input contains an integer T denoting the number of test cases. 
Each test case consist of a string of expression, in a separate line.

Output:

Print 'balanced' without quotes if pair of parenthesis are balanced else print 'not balanced' in a separate line.


Constraints:

1 ≤ T ≤ 100
1 ≤ |s| ≤ 100


Example:

Input:
3
{([])}
()
()[]

Output:
balanced
balanced
balanced

"""


#code
#@staticclass
class stack:
    def __init__(self):
        self.items= []
        
    def push(self,item):
        return self.items.append(item)
    
    def pop(self, item):
        return self.items.pop()
        
    def peek(self):
        return self.items[-1]
        
    def size(self):
        return len(self.items)

def BalanceString(s):
    n = len(s)
    st = stack()
    #st.push(s[0])
    #print(st)
    for i in range(n):
        if(s[i] == ")" and st.peek() == "("):
            st.pop(s[i])
        elif(s[i] == "]" and st.peek() == "["):
            st.pop(s[i])
        elif(s[i] == "}" and st.peek() == "{"):
            st.pop(s[i])
        else:
            st.push(s[i])
        print(st.size())
            
    print(st.size())
    if st.size() > 0:
        return "Unbalanced"
    else:return "Balanced"
        

n = int(input().strip())

for i in range(n):
    s = str(input().strip())
    print(BalanceString(s))
    
