# friends-on-vacation
The goal of the program "Friends on vacation" is to help friends track their expenses 
and make sure that everyone has spent equal amount of money. It is possible to enter 
an expense details - name of person, who made an expense, type of expense (e.g. food,
entertainment, hotel etc.) and amoun of an expense. Then program calculates sum of 
all expenses made, average expense value and number of friends (according to the number
of different friends' names).
To execute program run Main.java

Here I provide short user manual.
1. To add new expense that a friend made, type an expense details in text fields and press Save button.
    1.1. Name must not be empty. You also cannot leave default expression in the name text field.
    1.2. Expense type is not mandatory field. If You leave there default expression, it will be called "not defined".
    1.3. Expense amount is mandatory field. It should be numeric and positive. Use . as decimal separator.
2. When You save data it appears in the first table. Please, remember that data You entered is not saved in a data base.
3. The second table will show sum of each friend's expenses.
    * If You need to take in account friends who haven't made any expenses, type their names and enter amount 0.
4. The third table willl display transactions to be made.
    * If You have several friends with the same names You should distinguish them (e.g. add digits 1, 2 etc. at the end of their names).
5. To save data to PDF document press button Save to PDF.
    *PDF created will be saved to project directory.
