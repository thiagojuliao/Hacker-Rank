def wrapper(f):
    def fun(l):
        for index, phone in enumerate(l):
            aux = phone
            diff = len(aux) - 10
            l[index] = "+91 " + aux[diff:5 + diff] + " " + aux[5 + diff:]
        return f(l)
    return fun


@wrapper
def sort_phone(l):
    print(*sorted(l), sep='\n')


if __name__ == '__main__':
    l = [input() for _ in range(int(input()))]
    sort_phone(l)
