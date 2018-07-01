# Minimum Continuous Subsequence: targetList & availabletTagsList are two lists of string.
#
# Input:
#
# targetList = {"cat", "dog"};
# availableTagsList = { "cat", "test", "dog", "get", "spain", "south" };
#
# Output: [0, 2] //'cat' in position 0; 'dog' in position 2
#
# Input:
#
# targetList = {"east", "in", "south"};
# availableTagsList = { "east", "test", "east", "in", "east", "get", "spain", "south" };
#
# Output: [2, 6] //'east' in position 2; 'in' in position 3; 'south' in position 6 (east in position 4 is not outputted as it is coming after 'in')
#
# Input:
#
# targetList = {"east", "in", "south"};
# availableTagsList = { "east", "test", "south" };
#
# Output: [0] //'in' not present in availableTagsList
#
# Note: targetList will contain Distinct string objects.

def min_Cont_SubSequence(targetList, availableTagsList):

    word_index = {}

    for index,item in enumerate(availableTagsList):
        word_index.setdefault(item, set()).add(index)

    print(word_index)

    start  = targetList[0]
    middle = targetList[1]
    end = targetList[2]
    try:
        start_size = len(word_index[start])
        middle_size = len(word_index[middle])
        end_size = len(word_index[end])
    except:
        return 0

    start_list = list(word_index[start])
    middle_list = list(word_index[middle])
    end_list = list(word_index[end])

    if start_size < 1 or middle_size < 1 or end_size < 1:
        return 0

    while len(start_list) > 0 and len(middle_list) > 0 and len(end_list) > 0:

        max_start = start_list[-1]
        min_end = end_list[0]
        i = 0

        if max_start < middle_list[i] and middle_list[i] < min_end:
            return max_start, min_end
        elif max_start > middle_list[i]:
            start_list.pop(-1)
        elif middle_list[i] > min_end:
            end_list.pop(0)
        else:
            middle_list.pop()

    return 0





targetList = ["east", "in", "south"]
availableTagsList = ["east", "test", "east","south", "in", "east", "get", "spain" ,"south"]


print(min_Cont_SubSequence(targetList, availableTagsList))