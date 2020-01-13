import re

regex_integer_in_range = r"^[123456789]\d{5}$"
regex_alternating_repetitive_digit_pair = r"(?=((\d)\d\2))"

if __name__ == "__main__":
    P = input()

    print(bool(re.match(regex_integer_in_range, P))
          and len(re.findall(regex_alternating_repetitive_digit_pair, P)) < 2)
