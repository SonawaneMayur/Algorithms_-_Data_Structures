#   Valid Anagram
# Given two strings s and t, write a function to determine if t is an anagram of s.
#
# For example,
# s = "anagram", t = "nagaram", return true.
# s = "rat", t = "car", return false.
#
# Note:
# You may assume the string contains only lowercase alphabets.
#
# Follow up:
# What if the inputs contain unicode characters? How would you adapt your solution to such case?

def valid_anagram(a, b):
    if len(a) != len(b):
        return False
    sum = 0
    for i in range(len(a)):
        sum += ord(a[i])-ord(b[i])

    return True if sum == 0 else False

print(valid_anagram('anagram','nagaram'))