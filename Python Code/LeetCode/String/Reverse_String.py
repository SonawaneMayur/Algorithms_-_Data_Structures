

def reverse_string(text):
    text = list(text)
    n = len(text)
    i = 0
    while i < n:
        text[i],text[n-1] = text[n-1],text[i]
        i += 1
        n -= 1

    return ''.join(text)

st = "absdg"
print(''.join(reverse_string(st)))

