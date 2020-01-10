from collections import deque

if __name__ == "__main__":
    n = int(input())
    d = deque()

    for _ in range(n):
        inputs = input().split()
        action = inputs[0]

        if len(inputs) > 1:
            ele = inputs[1]

        if action == "append":
            d.append(ele)
        elif action == "appendleft":
            d.appendleft(ele)
        elif action == "pop":
            d.pop()
        else:
            d.popleft()

    print(" ".join(d))
