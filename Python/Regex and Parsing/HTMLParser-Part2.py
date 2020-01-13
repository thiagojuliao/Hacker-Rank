from html.parser import HTMLParser


class MyHTMLParser(HTMLParser):

    def handle_comment(self, data):
        if len(data.split("\n")) == 1 and data != "\n":
            print(">>> Single-line Comment\n" + data)
        elif data != "\n":
            print(">>> Multi-line Comment\n" + data)

    def handle_data(self, data):
        if data != "\n":
            print(">>> Data\n" + data)


if __name__ == "__main__":
    html = ""

    for _ in range(int(input())):
        html += input().rstrip()
        html += '\n'

    parser = MyHTMLParser()
    parser.feed(html)
    parser.close()
