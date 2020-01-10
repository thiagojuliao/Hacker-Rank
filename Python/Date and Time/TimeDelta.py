from datetime import datetime

months = ["", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]


def time_delta(t1, t2):
    t1_ = t1.split()
    t2_ = t2.split()
    hms1 = list(map(int, t1_[4].split(":")))
    hms2 = list(map(int, t2_[4].split(":")))
    t1z = int(t1_[5][0] + t1_[5][1:3]) * 3600 + int(t1_[5][0] + t1_[5][3:]) * 60
    t2z = int(t2_[5][0] + t2_[5][1:3]) * 3600 + int(t2_[5][0] + t2_[5][3:]) * 60
    dt1 = datetime(int(t1_[3]), months.index(t1_[2]), int(t1_[1]), hms1[0], hms1[1], hms1[2])
    dt2 = datetime(int(t2_[3]), months.index(t2_[2]), int(t2_[1]), hms2[0], hms2[1], hms2[2])

    diff = dt1 - dt2
    total_diff_in_seconds = abs((diff.days * 24 * 3600) + diff.seconds - (t1z - t2z))

    return total_diff_in_seconds


if __name__ == "__main__":
    n = int(input())

    for _ in range(n):
        t1 = input()
        t2 = input()

        print(time_delta(t1, t2))
