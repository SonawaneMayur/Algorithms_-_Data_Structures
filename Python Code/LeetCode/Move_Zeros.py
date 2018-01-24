# Move Zeroes
# Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
#
# For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

nums = [0,1,0,2,3,4]
def move_Zeros(nums):
    count = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[count] = nums[i]
            count +=1

    while count < len(nums):
        nums[count] = 0
        count +=1
    return nums

nums= [1,0,3,0,4,5,4]

print(move_Zeros(nums))
