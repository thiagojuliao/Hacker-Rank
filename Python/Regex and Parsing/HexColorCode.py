import re

if __name__ == "__main__":
    n = int(input())
    start_of_code_block = False
    pattern = r"(#[0-9ABCDEFabcdef]{6})|(#[0-9ABCDEFabcdef]{3})"
    hex_color_codes = []

    for _ in range(n):
        s = input()

        if s.find("{") != -1:
            start_of_code_block = True
        elif s.find("}") != -1:
            start_of_code_block = False

        if start_of_code_block and s.find("{") == -1:
            matches = re.findall(pattern, s)
            hex_colors = list(map(lambda t: t[0] or t[1], matches))
            [hex_color_codes.append(hex) for hex in hex_colors]

    print(*hex_color_codes, sep="\n")
