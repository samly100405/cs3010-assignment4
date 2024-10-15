import random
import sys


def main():
    if len(sys.argv) < 2:
        print("Specify a value for n.")
        exit(1)

    n = int(sys.argv[1])

    for i in range(n):
        print(random.uniform(-99,99), end=" ")

    print("q")
    

if __name__ == '__main__':
    main()