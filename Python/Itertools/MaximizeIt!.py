from itertools import product

if __name__ == "__main__":
    km = input().split()
    k = int(km[0])
    m = int(km[1])

    if k == 1:
        values = list(map(int, input().split()))
        mp = list(map(lambda x: pow(x, 2) % m, values))
        print(max(mp))
    else:
        lists = []

        for _ in range(k):
            inputs = input().split()
            ints = list(map(int, inputs[1:]))
            mp = list(map(lambda x: pow(x, 2), ints))
            lists.append(mp)
        # print(lists)

        index = 2
        p = list(product(lists[0], lists[1]))
        mp = list(map(sum, p))
        aux = mp
        # print("{} => {}".format(p, mp))

        while index < len(lists):
            p = list(product(aux, lists[index]))
            mp = list(map(sum, p))
            aux = mp
            index += 1
            # print("{} => {}".format(p, mp))

        final = list(map(lambda x: x % m, mp))
        print(max(final))
