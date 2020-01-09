if __name__ == "__main__":
    n, t = map(int, input().split())
    arr = list(map(int, input().split()))
    A = set(map(int, input().split()))
    B = set(map(int, input().split()))

    arr.sort()
    aux = arr[0]
    value_count = 1
    happiness = 0

    for value in arr[1:]:
        if value == aux:
            value_count += 1
        else:
            if {aux} == A.intersection({aux}):
                happiness += value_count
            elif {aux} == B.intersection({aux}):
                happiness -= value_count
            aux = value
            value_count = 1

    if {aux} == A.intersection({aux}):
        happiness += value_count
    elif {aux} == B.intersection({aux}):
        happiness -= value_count

    print(happiness)
