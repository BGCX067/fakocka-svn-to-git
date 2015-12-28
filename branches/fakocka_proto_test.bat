@echo off
FOR %%A IN (1 2 3 4 5 6 7 8 9 10) DO @(
	fakocka_proto_run < ./input/input%%A.txt > ./output/generated_output%%A.txt
	echo.
	echo ********** %%A. teszt **********
	diff ./output/generated_output%%A.txt ./output/output%%A.txt >> ./output/diffutilscheck.txt && echo A teszt sikeresen lezajlott!
)
echo.