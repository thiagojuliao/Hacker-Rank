import numpy


def arrays(arr):
    return numpy.array(arr, float)[-1::-1]


if __name__ == "__main__":
    arr = input().strip().split(' ')
    result = arrays(arr)
    print(result)
