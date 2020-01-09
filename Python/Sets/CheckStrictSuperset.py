if __name__ == "__main__":
    A = set(map(int, input().split()))
    t = int(input())

    is_strict_superset = True

    for _ in range(t):
        B = set(map(int, input().split()))

        if B != B.intersection(A) or B == A:
            is_strict_superset = False
            break

    print(is_strict_superset)

