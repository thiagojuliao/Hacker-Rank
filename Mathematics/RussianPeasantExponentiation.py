#!/bin/python3

import os
import sys

def multiply_complex(C1, C2, m):
    real_part = C1[0] * C2[0] - C1[1] * C2[1]
    imaginary_part = C1[0] * C2[1] + C1[1] * C2[0]

    return [real_part % m, imaginary_part % m]

def rpa_complex(C, n, m):
    P = [1, 0]
    base = C
    exp = n

    while exp > 1:
        if (exp % 2 != 0):
            P = multiply_complex(P, base, m)
        base = multiply_complex(base, base, m)
        exp = exp // 2

    return multiply_complex(P, base, m)

# Complete the solve function below.
def solve(a, b, k, m):
    C = [a, b]
    P = rpa_complex(C, k, m)

    return P

if __name__ == '__main__':

    q = int(input())
    results = []

    for q_itr in range(q):
        abkm = input().split()

        a = int(abkm[0])

        b = int(abkm[1])

        k = int(abkm[2])

        m = int(abkm[3])

        result = solve(a, b, k, m)
        results.append(result)

    for result in results:
        print(result)
