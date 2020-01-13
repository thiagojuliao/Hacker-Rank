import operator


def person_lister(f):
    def inner(people):
        sorted00 = sorted(people, key=lambda p: people.index(p))
        sorted01 = sorted(sorted00, key=lambda p: int(p[2]))
        return list(map(f, sorted01))
    return inner


@person_lister
def name_format(person):
    return ("Mr. " if person[3] == "M" else "Ms. ") + person[0] + " " + person[1]


if __name__ == '__main__':
    people = [input().split() for i in range(int(input()))]
    print(*name_format(people), sep='\n')
