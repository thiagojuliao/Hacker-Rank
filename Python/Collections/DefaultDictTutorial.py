from collections import defaultdict

if __name__ == "__main__":
    n, m = list(map(int, input().split()))
    list_of_indexes = defaultdict(list)

    for i in range(n + m):
        if i < n:
            list_of_indexes[input()].append(i + 1)
        else:
            ele = input()
            if not list_of_indexes[ele]:
                print(-1)
            else:
                for index in list_of_indexes[ele]:
                    print(index, end=" ")
                print()
