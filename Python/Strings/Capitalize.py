def solve(s):
    S = ""

    for index, char in enumerate(s):
        if index == 0 or s[index - 1] == " ":
            S += char.capitalize()
        else:
            S += char
            
    return S

