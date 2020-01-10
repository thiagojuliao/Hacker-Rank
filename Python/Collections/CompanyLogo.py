from collections import Counter

if __name__ == "__main__":
    s = input()
    counts = Counter(s)
    ls = [(counts[k], k) for k in counts.keys()]
    sort00 = sorted(ls, key=lambda t: t[1])
    sort01 = sorted(sort00, key=lambda t: t[0], reverse=True)
    ls = sort01

    for t in ls[0:3]:
        print("{} {}".format(t[1], t[0]))
