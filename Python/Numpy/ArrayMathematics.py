import numpy

if __name__ == "__main__":
    n, m = map(int, input().split())
    A = []
    B = []

    for _ in range(n):
        A.append(list(map(int, input().split())))

    for _ in range(n):
        B.append(list(map(int, input().split())))

    arr_A = numpy.array(A)
    arr_B = numpy.array(B)

    print(arr_A + arr_B)
    print(arr_A - arr_B)
    print(arr_A * arr_B)
    print(arr_A // arr_B)
    print(arr_A % arr_B)
    print(arr_A ** arr_B)
