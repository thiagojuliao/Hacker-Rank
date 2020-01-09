from itertools import permutations

if __name__ == "__main__":
    sr = input().split()
    s = sr[0]
    r = int(sr[1])

    perms = list(permutations(s, r))
    perms.sort()

    for permutation in perms:
        for value in permutation:
            print(value, end="")
        print()
