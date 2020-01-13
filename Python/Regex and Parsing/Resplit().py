import re

if __name__ == "__main__":
    regex_pattern = r",|\."  # Do not delete 'r'.
    print("\n".join(re.split(regex_pattern, input())))
