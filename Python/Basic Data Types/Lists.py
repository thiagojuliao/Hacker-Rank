if __name__ == '__main__':
    N = int(input())

    lst = []

    for _ in range(N):
        inputs = input().split()
        cmd = inputs[0]

        if cmd == "insert":
            lst.insert(int(inputs[1]), int(inputs[2]))
        elif cmd == "remove":
            e = int(int(inputs[1]))
            lst.remove(e)
        elif cmd == "append":
            e = int(int(inputs[1]))
            lst.append(e)
        elif cmd == "reverse":
            lst.reverse()
        elif cmd == "pop":
            lst.pop()
        elif cmd == "sort":
            lst.sort()
        else:
            print(lst)
