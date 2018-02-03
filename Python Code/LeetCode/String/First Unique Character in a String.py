# First Unique Character in a String
# Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
#
# Examples:
#
# s = "leetcode"
# return 0.
#
# s = "loveleetcode",
# return 2.
# Note: You may assume the string contain only lowercase letters.
#

import collections
def first_unique_char(abc):
    dict_char = collections.OrderedDict()
    for i in abc:
        if i not in dict_char:
            dict_char[i] = 1
        else: dict_char[i] += 1

    for k,v in dict_char.items():
        if v == 1:
            return k

    return None

print(first_unique_char('aaccd'))
