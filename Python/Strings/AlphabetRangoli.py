def print_rangoli(size):
    letters = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]

    line_size = 4 * size - 3
    l = letters[0: size]
    limit = (2 * size - 1) // 2 + 1

    sb = "-"
    S = []

    for i in range(limit):
        aux = l[-(1 + i)]

        if (i != limit - 1):
            string = sb + aux + sb[-1::-1]
        else:
            string = sb + aux + sb[-1::-1]
            string = string[1:len(string) - 1]
        num_of_traces = (line_size - len(string)) // 2

        S.append("-" * num_of_traces + string + "-" * num_of_traces)
        print(S[-1])
        sb += aux + "-"
    S.pop()

    [print(line) for line in S[-1::-1]]

if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)