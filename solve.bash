python3 generate_points.py 10
python3 generate_points.py 100
python3 generate_points.py 1000

printf "10 points"
python3 generate_inputs.py 4 | java -jar target/cs3010-assignment-4-1.0-SNAPSHOT-runnable.jar data/random_points10.txt
printf "\n100 points\n"
python3 generate_inputs.py 4 | java -jar target/cs3010-assignment-4-1.0-SNAPSHOT-runnable.jar data/random_points100.txt
printf "\n1000 points\n"
python3 generate_inputs.py 4 | java -jar target/cs3010-assignment-4-1.0-SNAPSHOT-runnable.jar data/random_points1000.txt
