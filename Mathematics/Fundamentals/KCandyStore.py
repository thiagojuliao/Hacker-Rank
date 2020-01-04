#!/bin/python3

import os
import sys
import math

# Complete the solve function below.
def solve(n, k):
    fact01 = math.factorial(n + k - 1)
    fact02 = math.factorial(n - 1)
    fact03 = math.factorial(k)

    result = fact01 // (fact02 * fact03)

    print(str(result))

    if len(str(result)) > 9:
        result = str(result)[-9:]

    return int(result)

  
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        n = int(input())

        k = int(input())

        result = solve(n, k)
        fptr.write(str(result))
        fptr.write("\n")
    fptr.close()