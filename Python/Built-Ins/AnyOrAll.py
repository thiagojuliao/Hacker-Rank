if __name__ == "__main__":
    n = int(input())
    numbers = list(map(int, input().split()))
    print(all(list(map(lambda e: e > 0, numbers))) and any(list(map(lambda e: str(e) == str(e)[-1::-1], numbers))))

