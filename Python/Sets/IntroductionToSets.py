def average(array):
    distinct_arr = set(arr)
    return sum(distinct_arr) / len(distinct_arr)


if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    result = average(arr)
    print(result)