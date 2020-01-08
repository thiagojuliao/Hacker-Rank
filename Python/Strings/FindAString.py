def count_substring(string, sub_string):
    index = 0
    count = 0
    
    while True:
        found_at = string[index:].find(sub_string)
        if found_at == -1:
            break
        else:
            count += 1
            index += found_at + 1
            
    return count

