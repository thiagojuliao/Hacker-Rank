import re

if __name__ == "__main__":
    n = int(input())
    and_pattern = r"(?<=\s)&&(?=\s)"
    or_pattern = r"(?<=\s)\|\|(?=\s)"
    comment = r"^#.+"

    for _ in range(n):
        s = input()

        if not bool(re.match(comment, s)):
            s_ = re.sub(and_pattern, "and", s)
            print(re.sub(or_pattern, "or", s_))
        else:
            print(s)
