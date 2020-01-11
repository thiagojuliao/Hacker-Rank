if __name__ == "__main__":
    n, m = map(int, input().split())
    subjects = list(range(n))
    totals = []

    for _ in range(m):
        marks = map(float, input().split())
        zipped = zip(subjects, marks)
        totals.append(list(map(lambda t: t[1], zipped)))
    zipped = list(zip(*totals))

    for t in zipped:
        average = round(sum(t) / m, 1)
        print(average)
