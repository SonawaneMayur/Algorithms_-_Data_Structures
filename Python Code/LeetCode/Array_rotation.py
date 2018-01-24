# Rotate Array
# Rotate an array of n elements to the right by k steps.
#
# For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
#
# Note:
# Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
#
# [show hint]
#
# Hint:
# Could you do it in-place with O(1) extra space?
# Related problem: Reverse Words in a String II




def leftRotate(arr, d, n):
    for i in range(gcd(d, n)):
        print('gcd ', gcd(d, n))
        # move i-th values of blocks
        print(i)
        temp = arr[i]
        j = i
        while 1:
            k = j + d
            if k >= n:
                k = k - n
            if k == i:
                break
            arr[j] = arr[k]
            j = k
        arr[j] = temp


def gcd(a,b):
    if b == 0:
        return a
    else:
        return gcd(b,a%b)

arr = [1, 2, 3, 4, 5, 6, 7]
print('array ',arr)

leftRotate(arr, 3, 7)
print('rotated array ',arr)