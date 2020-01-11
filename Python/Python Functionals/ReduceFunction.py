from fractions import Fraction
from functools import reduce


def product(fracs):
    t = reduce(lambda F1, F2: Fraction(F1.numerator * F2.numerator,
                                       F1.denominator * F2.denominator), fracs)
    return t.numerator, t.denominator


if __name__ == '__main__':

    fracs = []
    for _ in range(int(input())):
        fracs.append(Fraction(*map(int, input().split())))
    result = product(fracs)
    print(*result)
