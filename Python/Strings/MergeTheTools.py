def distinct(string):
    uniques_string = ""

    for s in string:
        if s not in uniques_string:
            uniques_string += s

    return uniques_string


def merge_the_tools(string, k):
    n = len(string)
    N = n // k
    index = 0

    for _ in range(N):
        s = distinct(string[index:index + k])
        index += k
        print(s)


if __name__ == '__main__':
    string, k = input(), int(input())
    merge_the_tools(string, k)