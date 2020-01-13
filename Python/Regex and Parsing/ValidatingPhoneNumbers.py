import re

if __name__ == "__main__":
    n = int(input())
    pattern = r"^[789][\d]{9}$"

    for _ in range(n):
        s = input()
        if bool(re.match(pattern, s)):
            print("YES")
        else:
            print("NO")
