import re

if __name__ == "__main__":
    n = int(input())

    for _ in range(n):
        s = input()
        print(bool(re.search(r"^[+-]?\d*\.{1}\d+$", s)))
