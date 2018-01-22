# -*- coding: utf-8 -*-
"""
Created on Mon Oct  9 08:23:34 2017

@author: Mayur
"""

class Parent():
   
    def __init__(self, exe = None):
        if exe is not None:
            self.value = exe
        else: self.value = 1000
        
    def debit_card(self):
        print("incPrent")
        print(self.value)
        
class Child(Parent):
    def __init__(self):
        self.value = 5000
        
    def debit_card(self):
        super(Child, self).debit_card()
        print(self.value)
        
p = Parent()
c = Child()

p.debit_card()
c.debit_card()