import random
import sys


def main():
    if len(sys.argv) < 2:
        print("Specify a value for n.")
        exit(1)

    n = int(sys.argv[1])
    f = open(f"data/random_points{n}.txt", "w")

    for i in range(n):
        f.write(str(random.uniform(-99,99)) + " ")

    f.write("\n")

    for i in range(n):
        f.write(str(random.uniform(-99,99)) + " ")
    

if __name__ == '__main__':
    main()