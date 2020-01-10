from collections import Counter

if __name__ == "__main__":
    n = int(input())
    shoes = list(map(int, input().split()))
    t = int(input())

    total = 0
    stock = Counter(shoes)

    for _ in range(t):
        shoe_number, value = list(map(int, input().split()))

        if stock[shoe_number] > 0:
            total += value
            stock[shoe_number] -= 1

    print(total)
