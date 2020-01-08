if __name__ == "__main__":
    n = int(input())
    s = set(map(int, input().split()))
    N = int(input())

    for _ in range(N):
        action = input().split()

        if action[0] == "pop":
            s.pop()
        elif action[0] == "remove":
            s.remove(int(action[1]))
        elif action[0] == "discard":
            s.discard(int(action[1]))

    print(sum(s))
