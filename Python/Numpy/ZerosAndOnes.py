import numpy

if __name__ == "__main__":
    dims = list(map(int, input().split()))
    print(numpy.zeros(tuple(dims), dtype=numpy.int))
    print(numpy.ones(tuple(dims), dtype=numpy.int))
