from itertools import combinations, filterfalse

if __name__ == "__main__":
    n = int(input())
    s = input().split()
    k = int(input())

    s.sort()

    combs = list(combinations(s, k))
    total = len(combs)
    total_of_as = len(list(filterfalse(lambda t: t[0] != "a", combs)))

    print(round(total_of_as / total, 4))
