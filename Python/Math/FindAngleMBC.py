from math import atan, degrees

if __name__ == "__main__":
    AB = int(input())
    BC = int(input())

    teta = round(degrees(atan(AB / BC)))
    print("{}°".format(teta))
