import xml.etree.ElementTree as etree

maxdepth = 0


def depth(elem, level):
    global maxdepth

    if len(elem) == 0:
        return level
    else:
        maxdepth = level

        for child in elem:
            maxdepth = max(maxdepth, depth(child, max(level, 0) + 1))

        return maxdepth


if __name__ == '__main__':
    n = int(input())
    xml = ""
    for i in range(n):
        xml = xml + input() + "\n"
    tree = etree.ElementTree(etree.fromstring(xml))
    depth(tree.getroot(), -1)
    print(maxdepth)
