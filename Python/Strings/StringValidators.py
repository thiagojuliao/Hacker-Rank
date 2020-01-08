if __name__ == '__main__':
    s = input()
    has_alphanum = False
    has_alphabetical = False
    has_digits = False
    has_lowercase = False
    has_uppercase = False

    for char in s:
        if char.isalnum() and not has_alphanum:
            has_alphanum = True
        if char.isalpha() and not has_alphabetical:
            has_alphabetical = True
        if char.isdigit() and not has_digits:
            has_digits = True
        if char.islower() and not has_lowercase:
            has_lowercase = True
        if char.isupper() and not has_uppercase:
            has_uppercase = True

    print(has_alphanum)
    print(has_alphabetical)
    print(has_digits)
    print(has_lowercase)
    print(has_uppercase)
