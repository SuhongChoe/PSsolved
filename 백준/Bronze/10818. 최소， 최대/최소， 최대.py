from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    _ = input()
    arr = list(map(int, input().split()))

    return ' '.join(map(str, (min(arr), max(arr))))
    
if __name__ == "__main__":
    print(str(function()))