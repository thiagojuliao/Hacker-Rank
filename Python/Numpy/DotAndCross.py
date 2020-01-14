import numpy

if __name__ == "__main__":
    n = int(input())
    A = []
    B = []
    C = []

    for _ in range(n):
        A.append(list(map(int, input().split())))

    for _ in range(n):
        B.append(list(map(int, input().split())))

    A = numpy.array(A)
    B = numpy.transpose(numpy.array(B))

    for i in range(n):
        aux = []

        for j in range(n):
            aux.append(numpy.dot(A[i], B[j]))
        C.append(aux)

    C = numpy.array(C)
    print(C)
