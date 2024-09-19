# 3x-1-Problem
A tool that may be help to find a number that dont return 1 from the 3x+1 problem

# What is the 3x+1 Problem?
Giving a positive integer and applaing 2 rules to it - it will always (until what we know now) return one at the end of the recurtions actions on the number
### Rules
Rule #1 - if the number is even => do num / 2
Rule #2 - if the number is odd => do num*3 + 1

from thies rules - all the numbers we know will get to the loop of 4 - 2 - 1.
Meaning if num is 4 => 4 / 2 = 2 => 2 / 2 = 1
If num is 1 => 1*3+1 = 4
the loop will continue for ever - and a number that will not fall for this loop will get stuck in it.

# What Did I Do?
I created a class where I created my own linked list function that will do a cashe to the "run" func - and will help run it more eficiant.
The linked list function contains a static ptr to the head of the linked list, to access the head quickly, and to be able to build the linked list just by using the create method I built.

## Functions in the CasheSaves Class

### Empry and full constractors
Empty constractor to create empty value if the user wants.
A constractor with all the data - not including the next var.
the next var is only for the "create" method that will continue the linked list.
### Getters for the vars in the class
All the vars are private or protected - so I create a get func to get the user a way to get the value of them
### toString override func
To be able to specify the object for the user if needed - return the string
### Create func
Add a node with the givan value to the end of the list
### len func
get the len of the linked list
### del func
To delete a node from the linked list by its index
### findIndex func
find the index of a node base of its input value
### search func
return the res value of a node base of its input value and return it
raise an exception if not found
### exist func
is the node with this input exist?


## Main
the main class contains the functions that do the calculations and print to the user when the cashe used and if a return value of non-one was found
See the docstring inside the code for more ditails
