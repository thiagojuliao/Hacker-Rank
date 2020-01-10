from collections import OrderedDict

if __name__ == "__main__":
    n = int(input())
    net_balance = OrderedDict()

    for _ in range(n):
        k, space, v = input().rpartition(" ")

        if net_balance.get(k):
            net_balance[k] += int(v)
        else:
            net_balance[k] = int(v)

    for item in net_balance:
        print(item + " " + str(net_balance[item]))
