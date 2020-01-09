from itertools import combinations

if __name__ == "__main__":
    sr = input().split()
    s = list(sr[0])
    r = int(sr[1])

    s.sort()

    for i in range(1, r + 1):
        coms = list(combinations(s, i))

        for combination in coms:

            for value in combination:
                print(value, end="")
            print()
