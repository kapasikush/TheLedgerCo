Set 1 Problem - The Ledger Co
===========================

Problem Context
-------
You work at a startup called The Ledger Co., a marketplace for banks to lend money to borrowers and receive payments for the loans.
The interest for the loan is calculated by I = P*N*R where P is the principal amount, N is the number of years and R is the rate of interest. The total amount to repay will be A = P + I
The amount should be paid back monthly in the form of EMIs. The borrowers can also pay a lump sum (that is, an amount more than their monthly EMI). In such a case, the lump sum will be 
deducted from the total amount (A) which can reduce the number of EMIs. This doesn’t affect the EMI amount unless the remaining total amount is less than the EMI. All transactions happen through The Ledger Co.
You need to design a system to find out how much amount a user has paid the bank and how many EMIs are remaining .

Steps to Test
----

> - Unzip TheLedgerCo.zip
> - Open cmd in Geektrust folder.
> - Run : **mvn clean install**
> - Run : **java -jar ./target/geektrust.jar input-file-location**
