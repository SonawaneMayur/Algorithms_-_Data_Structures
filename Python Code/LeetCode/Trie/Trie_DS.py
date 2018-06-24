import collection


class TrieNode():
    def __init__(self):
        self.children = collection.defaultdict(TrieNode)
        self.is_word = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        current = self.root
        for w in word:
            current = current.children[w]
        current.is_word = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        current = self.root
        for w in word:
            current = current.children.get(w)
            if current is None:
                return False
        return current.is_word

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        current = self.root
        for w in word:
            current = current.children.get(w)
            if current in None:
                return False
        return True


# Your Trie object will be instantiated and called as such:
obj = Trie()
word = 'mayur'
prefix = 'may'
obj.insert(word)
param_2 = obj.search(word)
param_3 = obj.startsWith(prefix)
print(obj)
print(param_2)
print(param_3)