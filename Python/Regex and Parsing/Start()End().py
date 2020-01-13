import re

if __name__ == "__main__":
    s = input()
    k = input()
    pattern = r"(?={})".format(k)

    matches = list(re.finditer(pattern, s))

    if matches:
        for match in matches:
            print("({}, {})".format(match.start(), match.end() + len(k) - 1))
    else:
        print("(-1, -1)")
