if __name__ == "__main__":
    n = int(input())
    N = set(map(int, input().split()))
    m = int(input())
    M = set(map(int, input().split()))

    print(len(N.union(M)))
