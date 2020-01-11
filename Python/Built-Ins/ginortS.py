if __name__ == "__main__":
    s = input()
    lowers = [c for c in s if c.islower()]
    uppers = [c for c in s if c.isupper()]
    odd_digits = [d for d in s if d.isdigit() and int(d) % 2 != 0]
    even_digits = [d for d in s if d.isdigit() and int(d) % 2 == 0]

    lowers.sort()
    uppers.sort()
    odd_digits.sort()
    even_digits.sort()

    sorted_s = lowers + uppers + odd_digits + even_digits
    print(*sorted_s, sep="")
