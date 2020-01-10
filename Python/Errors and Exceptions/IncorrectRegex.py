import re

if __name__ == "__main__":
    n = int(input())
    s = "husahusausa"

    for _ in range(n):
        try:
            s_ = re.search(input(), s)
            print(True)
        except Exception as e:
            print(False)
