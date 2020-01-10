from collections import namedtuple

if __name__ == "__main__":
    n = int(input())
    Student = namedtuple("Student", input().split())
    sum_of_marks = 0

    for _ in range(n):
        std = Student(*(input().split()))
        sum_of_marks += int(std.MARKS)

    print("%.2f" % round(sum_of_marks / n, 2))
