# CSCI-722-Project

## Membership Management Project

## Overview
This is a Java-based Membership Management System that allows users to read and write member data from a file, manage memberships using a `Hashtable`, and handle command-line arguments for input and output operations.

## Features
- Read member data from an input file.
- Store member information in a `Hashtable`.
- Add new members dynamically via command-line arguments.
- Write member details to an output file.
- Prevent duplicate IDs. (Phone number is the ID)
- Optionally print the most recently added member.
- Optionally print all members to the specified output file.

## Prerequisites
- Java Development Kit (JDK) 8 or later.

## Usage

## Compile the Project
```sh
javac *.java

## Run the Project
Note: The order or case does not matter for the flags
```sh
java Membership -inputFile=input.txt -outputFile=output.txt -id=123 -firstname=John -lastname=Doe -age=25 -NewYork=true -printAllMemberships=true
```

## CommandLine Arguments

| Argument               | Description                                                                | Example                |
|------------------------|----------------------------------------------------------------------------|------------------------|
| -inputFile	         | Specifies the input file containing member records                         | -inputFile=input.txt   |
| -outputFile	         | Specifies the output file to store results                                 | -outputFile=output.txt |
| -id	                 | Unique identifier for a member                                             | -id=1234567890         |
| -firstname	         | First name of the member                                                   | -firstname=Steve       |
| -lastname	             | Last name of the member                                                    | -lastname=Smith        |
| -age	                 | Age of the member                                                          | -age=26                |
| -NewYork	             | Boolean flag indicating if the member lives in New York                    | -NewYork=true          |
| -printAllMemberships   | Prints all Memberships if true, else it prints only the recently added one | -firstname=Steve       |

### Example Input file
```txt
First name | Last name | id Number | age | Lives in New York? 
John|Doe|123|25|true
Jane|Smith|456|30|false
```

### Example Output file

```txt
First name | Last name | id Number | age | Lives in New York?
John|Doe|123|25|true
Jane|Smith|456|30|false
```
