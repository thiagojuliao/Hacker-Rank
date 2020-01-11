if __name__ == '__main__':
    nm = input().split()
    n = int(nm[0])
    m = int(nm[1])

    ids = list(range(n))
    arr = []

    for _ in range(n):
        arr.append(list(map(int, input().rstrip().split())))

    zipped = list(zip(ids, arr))
    k = int(input())

    sort00 = sorted(zipped, key=lambda t: t[0])
    sort01 = sorted(sort00, key=lambda t: t[1][k])

    for t in sort01:
        print(*t[1])
