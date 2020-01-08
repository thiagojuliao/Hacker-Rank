def symmetric_difference(A, B):
    union = A.union(B)
    intersection = A.intersection(B)
    diff = union.difference(intersection)

    ls = list(diff)
    ls.sort()

    for value in ls:
        print(value)


if __name__ == '__main__':

    m = int(input())
    M = set(map(int, input().split()))

    n = int(input())
    N = set(map(int, input().split()))

    symmetric_difference(M, N)
