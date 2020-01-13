import re

if __name__ == "__main__":
    pattern = r"(?=([^aeiouAEIOU]([aeiouAEIOU]{2,})[^aeiouAEIOU]))"
    matches = re.findall(pattern, input())

    if matches:
        print(*map(lambda t: t[1], matches), sep="\n")
    else:
        print(-1)
