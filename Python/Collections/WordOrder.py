from collections import Counter

if __name__ == "__main__":
    n = int(input())
    words = []

    for _ in range(n):
        words.append(input())

    counts = Counter(words)
    unique_words = set(words)

    print(len(unique_words))
    print(" ".join(map(str, counts.values())))
