

# Suppose we're given a sequence S containing n numbers, where n is very large and may not be known in advance.
#
# Implement an algorithm to uniformly sample k = 1000 elements from this sequence.



import random

iterator = [ 2, 2, 2,3,4]
N = 2
sample = []
# print(random.sample(iterator, 3))
for i, line in enumerate(iterator):
    if i < N:
        sample.append(line)
    elif i >= N and random.random() < N / float(i + 1):
        replace = random.randint(0, len(sample) - 1)
        sample[replace] = line

print(sample)