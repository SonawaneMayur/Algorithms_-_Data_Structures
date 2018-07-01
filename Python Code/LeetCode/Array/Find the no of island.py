# Program to count islands in boolean 2D matrix
class Graph:

    def __init__(self, row, col, g):
        self.ROW = row
        self.COL = col
        self.graph = g
        #self.visited = visited
        #self.shape = shape

    # A function to check if a given cell
    # (row, col) can be included in DFS
    def isSafe(self, i, j, visited):
        # row number is in range, column number
        # is in range and value is 1
        # and not yet visited
        return (i >= 0 and i < self.ROW and
                j >= 0 and j < self.COL and
                not visited[i][j] and self.graph[i][j])

    # A utility function to do DFS for a 2D
    # boolean matrix. It only considers
    # the 8 neighbours as adjacent vertices
    def DFS(self, i, j, visited, shape):

        # These arrays are used to get row and
        # column numbers of 8 neighbours
        # of a given cell

        if shape == 0:
            shape = 1
        # Mark this cell as visited
        visited[i][j] = True

        # Recur for all connected neighbours
        for k in range(-1, 2):
            for l in range(-1, 2):
                if self.isSafe(i + k, j + l, visited):

                    shape = shape + self.DFS(i + k, j + l, visited, shape)
        return shape

    # The main function that returns
    # count of islands in a given boolean
    # 2D matrix
    def countIslands(self):
        # Make a bool array to mark visited cells.
        # Initially all cells are unvisited


        # Initialize count as 0 and travese
        # through the all cells of
        # given matrix
        count = 0
        shape = []
        for i in range(self.ROW):
            for j in range(self.COL):
                # If a cell with value 1 is not visited yet,
                # then new island found
                if visited[i][j] == False and self.graph[i][j] == 1:
                    # Visit all cells in this island
                    # and increment island count
                    shape.append(self.DFS(i, j,visited,0))
                    count += 1

        return count, shape


graph = [[1, 1, 0, 1, 1],
         [1, 1, 0, 1, 0],
         [1, 0, 0, 1, 1],
         [0, 0, 1, 1, 0],
         [1, 1, 1, 1, 1]]

row = len(graph)
col = len(graph[0])

visited = [[False for j in range(col)] for i in range(row)]

g = Graph(row, col, graph)

print("Number of islands is :")
print(g.countIslands())

# This code is contributed by Neelam Yadav
