def swap_case(s):
    upper_s = s.upper()
    s_ = ""
    for index, char in enumerate(s):
        if char == upper_s[index]:
            s_ += s[index].lower()
        else:
            s_ += s[index].upper()
    return s_