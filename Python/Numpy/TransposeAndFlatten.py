import numpy

if __name__ == "__main__":
    n, m = map(int, input().split())
    matrix = []

    for _ in range(n):
        matrix.append(list(map(int, input().split())))

    arr = numpy.array(matrix, int)
    print(numpy.transpose(arr))
    print(arr.flatten())
