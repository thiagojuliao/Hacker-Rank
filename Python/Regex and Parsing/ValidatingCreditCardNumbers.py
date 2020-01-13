import re

if __name__ == "__main__":
    n = int(input())

    for _ in range(n):
        s = input()

        # Checks if the credit card number starts with 4,5 or 6
        valid_start = bool(re.match(r"^[456]", s))

        # Checks the count number of digits
        valid_count = bool(len(re.findall(r"\d", s)) == 16)

        # Checks the presence of even groups of 4
        valid_groups = bool(re.match(r"(-?[0-9]{4}-?){4}", s))

        # Checks the presence of any non digit character rather than - (hiphen)
        invalid_chars = bool(re.match(r"[^\d-]", s))

        # Checks the number of consecutive digits that can not exceed 3
        invalid_consecutive = bool(re.match(r".*(\d)\1{3,}.*", re.sub(r"[^a-zA-Z0-9]", "", s)))

        if valid_start and valid_count and valid_groups \
                and not invalid_chars and not invalid_consecutive:
            print("Valid")
        else:
            print("Invalid")
