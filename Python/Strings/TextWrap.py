def wrap(string, max_width):
    s = ""
    for string in textwrap.wrap(string, max_width):
        s += string + "\n"
        
    return s

