import numpy

numpy.set_printoptions(sign=' ')

if __name__ == "__main__":
    n, m = map(int, input().split())
    arr = []

    for _ in range(n):
        arr.append(list(map(int, input().split())))

    arr = numpy.array(arr)

    print(numpy.mean(arr, axis=1))
    print(numpy.var(arr, axis=0))
    print(numpy.round(numpy.std(arr), 12))

