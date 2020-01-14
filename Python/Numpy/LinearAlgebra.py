import numpy

if __name__ == "__main__":
    n = int(input())
    M = []

    for _ in range(n):
        M.append(list(map(float, input().split())))

    print(numpy.round(numpy.linalg.det(M), 2))
