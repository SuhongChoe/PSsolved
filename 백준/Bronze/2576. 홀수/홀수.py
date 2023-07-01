from sys import stdin, stdout
input=stdin.readline
print=stdout.write

def function():
    # write down code
    import sys
    odd_sum, odd_min = 0, sys.maxsize

    for _ in range(7):
        n = int(input())
        if n%2==1:
            odd_sum += n
            odd_min = n if odd_min > n else odd_min

    return '\n'.join(map(str, [odd_sum, odd_min])) if odd_sum else -1
    
if __name__ == "__main__":
    print(str(function()))