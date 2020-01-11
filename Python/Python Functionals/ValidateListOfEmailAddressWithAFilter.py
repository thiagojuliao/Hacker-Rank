valid_username_chars = set("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_")
valid_website_chars = set("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")


def fun(s):
    username = s.split("@")[0]

    if len(username) == len(s) or len(username) == 0:
        return False
    else:
        website = s.split("@")[1].split(".")[0]

        if len(website) == len(s.split("@")[1]):
            return False
        else:
            extension = s.split("@")[1].split(".")[1]
            username_ = set(username).intersection(valid_username_chars)
            website_ = set(website).intersection(valid_website_chars)

            if len(set(username)) == len(username_) and len(set(website)) == len(website_) and len(extension) <= 3:
                return True
            else:
                return False


def filter_mail(emails):
    return list(filter(fun, emails))


if __name__ == '__main__':
    n = int(input())
    emails = []
    for _ in range(n):
        emails.append(input())

    filtered_emails = filter_mail(emails)
    filtered_emails.sort()
    print(filtered_emails)