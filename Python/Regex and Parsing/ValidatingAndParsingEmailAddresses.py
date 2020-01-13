import re

if __name__ == "__main__":
    n = int(input())
    pattern = r"^[a-zA-Z][a-zA-Z0-9-._]+@[a-zA-Z]+\.[a-zA-Z]{1,3}$"

    for _ in range(n):
        name, email = input().split()

        if bool(re.match(pattern, email[1:len(email) - 1])):
            print(name + " " + email)
