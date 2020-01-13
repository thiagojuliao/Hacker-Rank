import re

if __name__ == "__main__":
    pattern = r"([A-Za-z0-9])\1+"
    matches = re.finditer(pattern, input())
    aws = -1

    for match in matches:
        aws = match.group(0)[0]
        break

    print(aws)
