# Given an array of integers, return indices of the two numbers such that they add up to a specific target.
#
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
#
# Example:
# Given nums = [2, 7, 11, 15], target = 9,
#
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
import random
edt = [ 3,4,45,5,5,5]

print(random.sample(edt, 4))

name = 2
print("{name} = ",f'{name}')

def twoSum(nums, sum):
    dict = []
    j = 0
    rem = sum - nums[j]
    for i in range(1,len(nums)):
        if rem == nums[i]:
            dict.append({j, i})
        else:
            j += 1
            rem = sum - nums[j]
    return dict

nums = [1, 3, 2 ,0 , 5, 7, 9]
sum = 5

print(twoSum(nums, sum))