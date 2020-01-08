def print_formatted(number):
    padding = len(str(bin(number))[2:])

    for n in range(number):
        decimal = str(n + 1)
        octal = str(oct(n + 1))[2:]
        hexa = str(hex(n + 1)).upper()[2:]
        binary = str(bin(n + 1))[2:]

        decimal = " " * (padding - len(decimal)) + decimal
        octal = " " * (padding - len(octal)) + octal
        hexa = " " * (padding - len(hexa)) + hexa
        binary = " " * (padding - len(binary)) + binary

        print("{} {} {} {}".format(decimal, octal, hexa, binary))
