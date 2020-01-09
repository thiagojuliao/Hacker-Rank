from itertools import combinations_with_replacement

if __name__ == "__main__":
    sr = input().split()
    s = list(sr[0])
    r = int(sr[1])

    s.sort()
    combs = list(combinations_with_replacement(s, r))

    for combination in combs:
        for value in combination:
            print(value, end="")
        print()
