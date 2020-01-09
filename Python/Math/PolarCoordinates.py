from cmath import phase

if __name__ == "__main__":
    s = input()
    c = complex(s)

    r = abs(complex(c.real, c.imag))
    p = phase(complex(c.real, c.imag))

    print(r)
    print(p)
