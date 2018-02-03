

def reverse_number(num):
    if num < 0:
        flag = -1
    num = abs(num)
    reverse_number = 0
    prev_rev_number = 0
    while num > 0:
        last_digit = num %10

        reverse_number = (reverse_number *10) + last_digit
        num = int(num/10)

        prev_rev_number = reverse_number


    return reverse_number if flag != -1 else -reverse_number

print(reverse_number(-1235145848484881848784148479164794629749497979247292799729797927927927478794164))