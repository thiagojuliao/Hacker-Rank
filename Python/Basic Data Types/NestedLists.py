if __name__ == '__main__':

    students = []

    for _ in range(int(input())):
        name = input()
        score = float(input())
        students.append([name, score])
    
    scores = [student[1] for student in students]
    low_grade = min(scores)
    sec_low_grade = min([score for score in scores if score != low_grade])

    sec_low_grade_students = [student for student in students if
    student[1] == sec_low_grade]
    sec_low_grade_students.sort()

    [print(student[0]) for student in sec_low_grade_students]
    

