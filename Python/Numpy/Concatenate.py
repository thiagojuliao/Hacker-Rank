import numpy

if __name__ == "__main__":
    n, m, p = map(int, input().split())
    N = []
    M = []

    for _ in range(n):
        N.append(list(map(int, input().split())))

    for _ in range(m):
        M.append(list(map(int, input().split())))

    print(numpy.concatenate((N, M), axis=0))
