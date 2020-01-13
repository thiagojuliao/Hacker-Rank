import numpy

if __name__ == "__main__":
    arr = input().strip().split(" ")
    print(numpy.reshape(numpy.array(arr, int), (3, 3)))
