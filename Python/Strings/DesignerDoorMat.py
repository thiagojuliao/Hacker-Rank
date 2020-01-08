if __name__ == "__main__":
    inputs = input().split()
    N = int(inputs[0])
    M = int(inputs[1])

# Top Pattern
for i in range(0, (N - 1)//2):
    a_i = 3 + 6 * i
    a_j = 1 + 2 * i
    k = (M - a_i)//2
    print("-" * k + ".|." * a_j + "-" * k)

# Middle Pattern
k = (M - 7)//2
print("-" * k + "WELCOME" + "-" * k)

# Bottom Pattern
i = (N - 1)//2 - 1
while i >= 0:
    a_i = 3 + 6 * i
    a_j = 1 + 2 * i
    k = (M - a_i)//2
    print("-" * k + ".|." * a_j + "-" * k)
    i -= 1
