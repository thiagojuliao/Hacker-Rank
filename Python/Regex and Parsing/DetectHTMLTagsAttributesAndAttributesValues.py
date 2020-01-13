from html.parser import HTMLParser


class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print(tag)
        for ele in attrs:
            print('->', ele[0], '>', ele[1])

    def handle_startendtag(self, tag, attrs):
        print(tag)
        for ele in attrs:
            print('->', ele[0], '>', ele[1])


if __name__ == "__main__":
    MyParser = MyHTMLParser()
    MyParser.feed(''.join([input().strip() for _ in range(int(input()))]))
