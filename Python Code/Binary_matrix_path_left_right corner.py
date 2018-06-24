# Recursion. Time Complx:- 2^(n+m)
def printPath(matrix):

    def isSafe(i, j, prevValue):
        return 0 <= i < len(matrix) and \
               0 <= j < len(matrix[0]) \
               and matrix[i][j] != prevValue

    def findHelper(i, j, prevValue, path):
        if i == len(matrix) - 1 and j == len(matrix[0]) - 1 \
                and prevValue != matrix[i][j]:
            path.append(str((i, j)))
            return True

        if isSafe(i, j, prevValue):
            path.append(str((i, j)) + '-> ')
            if findHelper(i, j+1, matrix[i][j], path):
                return True
            if findHelper(i+1, j, matrix[i][j], path):
                return True

            path.pop()
            return False
        return False

    path = []
    res = findHelper(0, 0, -1, path)
    if len(path) == 0:
        print('No path found from source to destination')
    else:
        print('Path found and the path is %s' % (''.join(path)))

matrix = \
    [
    [1, 0, 0, 0],
    [1, 1, 0, 1],
    [0, 1, 0, 0],
    [1, 1, 1, 1]
]

matrix2 = \
[
    [1, 0, 0],
    [0, 1, 1],
    [0, 0, 0],
]
matrix3 = \
[
    [1, 0, 0, 0, 0, 0, 0],
    [1, 1, 0, 1, 0, 0, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [1, 1, 1, 1, 0, 1, 0]
]

from pprint import pprint
pprint(matrix)

printPath(matrix)
#printPathWithMemoization(matrix)
printPath(matrix2)
# printPathWithMemoization(matrix2)
printPath(matrix3)
# printPathWithMemoization(matrix3)