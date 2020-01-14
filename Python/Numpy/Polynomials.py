import numpy

if __name__ == "__main__":
    c = list(map(float, input().split()))
    x = float(input())

    print(numpy.polyval(c, x))
