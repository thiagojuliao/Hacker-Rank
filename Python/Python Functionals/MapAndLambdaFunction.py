import math


def fibonacci(n):
    fibos = [0, 1]

    if n <= 2:
        return fibos[0:n]
    else:
        count = 2
        while count < n:
            fibos.append(fibos[count - 1] + fibos[count - 2])
            count += 1
    return fibos


if __name__ == "__main__":
    n = int(input())
    print(list(map(lambda x: int(math.pow(x, 3)), fibonacci(n))))

