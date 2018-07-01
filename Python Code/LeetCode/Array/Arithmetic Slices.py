
def artmatic_cnt(arr):
    map = {}
    target = 9
    for i in range(len(arr)):
        c = target - arr[i]
        if c in  map:
            yield map[c], i

        map[arr[i]] = i




arr = [2,7,11,5,4]
a,b = artmatic_cnt(arr)
print(a,b)