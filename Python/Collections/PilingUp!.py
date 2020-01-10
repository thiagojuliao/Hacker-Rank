import sys
from collections import deque


def solve(cubes):
    rejected_pile = []
    stacked_pile = [sys.maxsize]

    while not rejected_pile and cubes:
        if cubes[0] >= cubes[-1] and cubes[0] <= stacked_pile[-1]:
            stacked_pile.append(cubes.popleft())
        elif cubes[0] < cubes[-1] and cubes[-1] <= stacked_pile[-1]:
            stacked_pile.append(cubes.pop())
        else:
            rejected_pile.append(cubes[-1])

    if rejected_pile:
        return "No"

    return "Yes"


if __name__ == "__main__":
    n = int(input())

    for _ in range(n):
        k = int(input())
        cubes = deque(map(int, input().split()))
        print(solve(cubes))
