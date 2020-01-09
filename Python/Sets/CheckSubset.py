if __name__ == "__main__":
    t = int(input())

    for _ in range(t):
        n, A = int(input()), set(map(int, input().split()))
        m, B = int(input()), set(map(int, input().split()))

        if A == A.intersection(B):
            print(True)
        else:
            print(False)
