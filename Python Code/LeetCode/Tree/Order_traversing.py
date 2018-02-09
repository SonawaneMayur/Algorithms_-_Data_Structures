
class Node():
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key

def printPreorder(root):

    if root:
        print(root.val, end = ' ')
        printPreorder(root.left)
        printPreorder(root.right)

def printInorder(root):

    if root:
        printInorder(root.left)
        print(root.val, end = ' ')
        printInorder(root.right)

def printPostorder(root):

    if root:
        printPostorder(root.left)
        printPostorder(root.right)
        print(root.val, end = ' ')


root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

print('Pre Order-')
printPreorder(root)

print('Post Order')
printPostorder(root)

print('InOrder')
printInorder(root)
