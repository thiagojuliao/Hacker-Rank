import re

if __name__ == "__main__":
    first_multiple_input = input().rstrip().split()
    n = int(first_multiple_input[0])
    m = int(first_multiple_input[1])
    matrix = []

    for _ in range(n):
        matrix_item = input()
        matrix.append(matrix_item)

    decoded = []

    for col in range(m):
        aux = ""
        for line in matrix:
            aux += line[col]
        decoded.append(aux)

    joined = "".join(decoded)
    needs_replacing = re.findall(r"(?=([a-zA-z0-9]([^a-zA-z0-9]+)[a-zA-z0-9]))", joined)

    for t in needs_replacing:
        joined = joined.replace(t[0], t[0].replace(t[1], " "))

    print(joined)
