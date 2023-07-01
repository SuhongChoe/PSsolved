from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    res = [0, 0] # num, idx

    for i in range(1, 10):
        n = int(input())
        if res[0] < n:
            res[0], res[1] = n, i


    return '\n'.join(map(str, res))
    
if __name__ == "__main__":
    print(function())