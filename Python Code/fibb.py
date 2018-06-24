
def fibb(n):
    # if n > 10000:
    #     return
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else: return fibb(n)+fibb(n-1)

print(fibb(10000))
