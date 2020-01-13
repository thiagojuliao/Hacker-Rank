import numpy

numpy.set_printoptions(sign=' ')

if __name__ == "__main__":
    arr = numpy.array(input().split(), float)

    print(numpy.floor(arr))
    print(numpy.ceil(arr))
    print(numpy.rint(arr))
