# 26. Remove Duplicates from Sorted Array
# DescriptionHintsSubmissionsDiscussSolution
# Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
#
# Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
#
# Example:
#
# Given nums = [1,1,2],
#
# Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
# It doesn't matter what you leave beyond the new length.


def remove_duplicates(A):
    A.sort()
    i = 0
    for j in range(1,len(A)):
        if A[i] != A[j]:
            i += 1
            A[i] = A[j]

    return A[:i+1]

print(remove_duplicates([1,1,2,2,2,3,4,5,5,4]))