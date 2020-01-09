if __name__ == "__main__":
    n = int(input())
    A = set(map(int, input().split()))
    t = int(input())

    for _ in range(t):
        inputs = input().split()
        B = set(map(int, input().split()))

        if inputs[0] == "intersection_update":
            A.intersection_update(B)
        elif inputs[0] == "update":
            A.update(B)
        elif inputs[0] == "difference_update":
            A.difference_update(B)
        else:
            A.symmetric_difference_update(B)

    print(sum(A))
