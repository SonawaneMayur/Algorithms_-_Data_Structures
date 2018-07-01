# Function to find the maximum contiguous subarray
import sys


def maxSubArraySum(a, size):
    max_so_far = -sys.maxsize - 1
    max_ending_here = 0

    for i in range(0, size):
        max_ending_here = max_ending_here + a[i]
        if (max_so_far < max_ending_here):
            max_so_far = max_ending_here

        if max_ending_here < 0:
            max_ending_here = 0

        #max(a)
    return max_so_far


# Driver function to check the above function
a = [-13, -3, -25, -20, 0]
print("Maximum contiguous sum is", maxSubArraySum(a, len(a)))