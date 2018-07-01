# Given a string, find the length of the longest substring without repeating characters.
#
# Examples:
#
# Given "abcabcbb", the answer is "abc", which the length is 3.
#
# Given "bbbbb", the answer is "b", with the length of 1.
#
# Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

def lengthOfLongestSubstring(s):
    """
    :type s: str
    :rtype: int
    """
    maxlength = start = 0
    subdict = {}

    for i in range(len(s)):

        if s[i] in subdict and start <= subdict[s[i]]:
            start = subdict[s[i]] + 1
        else:
            maxlength = max(maxlength, i - start + 1)

        subdict[s[i]] = i
    return maxlength
st = 'abcabcbb'

print(lengthOfLongestSubstring(st))