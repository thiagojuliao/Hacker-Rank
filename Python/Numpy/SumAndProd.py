import numpy

if __name__ == "__main__":
    n, m = map(int, input().split())
    arrs = []

    for _ in range(n):
        arrs.append(list(map(int, input().split())))

    arrs_sum = numpy.sum(numpy.array(arrs), axis=0)
    print(numpy.prod(arrs_sum))
