

# Remove duplicates from sorted array
# 2.4
# Given a sorted array, the task is to remove the duplicate elements from the array.
#
# Examples:
#
# Input  : arr[] = {2, 2, 2, 2, 2}
# Output : arr[] = {2}
#          new size = 1
#
# Input  : arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
# Output : arr[] = {1, 2, 3, 4, 5}
#          new size = 5

class Solution:
    def removeDuplicates(self, arr):
        """
        :type nums: List[int]
        :rtype: int

        """
        if len(arr) == 0 or len(arr) == 1:
            return arr

        j = 0
        for i in range(len(arr)-1):
            if arr[i] != arr[i + 1]:
                arr[j] = arr[i]
                j += 1

        arr[j] = arr[-1]
        j += 1
        return j


# Driver code
arr = [1, 2, 2, 3, 4, 4, 4, 5]
n = len(arr)

# removeDuplicates() returns
# new size of array.
s = Solution()
j = s.removeDuplicates(arr)

# Print updated array
for i in range(0, j):
    print(" %d "%(arr[i]), end = " ")