from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    # 모든 점수를 grade/max_grade*100

    n = int(input())
    grades = list(map(int, input().split()))

    max_grade = max(grades)
    grades = list(map(lambda grade : grade/max_grade*100, grades))

    return sum(grades) / n
    
if __name__ == "__main__":
    print(str(function()))