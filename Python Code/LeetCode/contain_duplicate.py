# Contains Duplicate
# Given an array of integers, find if the array contains any duplicates.
# Your function should return true if any value appears at least twice in the array,
# and it should return false if every element is distinct.
#


def partition(nums , start, end):
    pivot = start
    i = start - 1
    for j in range(start, end):
        if nums[j] <= pivot:
            i += 1
            nums[j],nums[i] = nums[i], nums[j]

    nums[i], nums[pivot] = nums[pivot], nums[i]
    return i+1



def quicksort_recursive(nums, start, end):
    if start < end:
        pos = partition(nums, start, end)
        quicksort_recursive(nums, start, pos-1)
        quicksort_recursive(nums, pos+1 , end)


def containsDuplicate(nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    quicksort_recursive(nums, 0 , len(nums)-1)

    # num_dict = []
    # for num in nums:
    #     if num not in num_dict:
    #         num_dict.append(num)
    #     else:
    #         return True

    for i in range(1,len(nums)):
        if nums[i-1] == nums[i]:
          return True

    return False


nums = [1,2,3,4,5,3]

print(containsDuplicate(nums))
