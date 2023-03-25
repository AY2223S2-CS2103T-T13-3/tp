---
layout: page
title: User Guide
---

Welcome to **sprINT's User Guide**. sprINT is a **desktop application** for managing internship applications,
optimized for use via a Command Line Interface (CLI) while still incorporating the benefits of a Graphical User
Interface (GUI).

The app is optimized greatly for *fast typers*. If you can type fast, sprINT will be of great assistance in
your internship hunt!

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `sprint.jar` from [here](https://github.com/AY2223S2-CS2103T-T13-3/tp/releases/tag/v1.2).

3. Copy the file to the folder you want to use as the _home folder_ for your sprINT application.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar sprINT.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data already.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add r/SWE Intern c/Goggle e/goggle_careers@gmail.com s/interested d/01-01-2023` : Adds an
   application for Software Engineer Intern position @ Goggle that I'm interested in. Deadline of application is 1st of
   January.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add c/COMAPNY_NAME`, `COMPANY_NAME` is a parameter which can be used as `add c/John Doe's Company`.

* Items in square brackets are optional.<br>
  e.g `c/COMPANY_NAME [t/TAG]` can be used as `c/John Doe's Company t/highsalary` or as `c/John Doe's Company` only.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/highsalary`, `t/highsalary t/creditbearing` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `r/ROLE c/COMPANY_NAME`, `c/COMPANY_NAME r/ROLE` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `r/SWE Intern r/Software Intern`, only `r/Software Intern` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message with a link to the user guide.

![help message](images/helpMessage.png)

Format: `help`


### Adding an application: `add` 

Adds an internship application to be tracked.

Format: `add r/ROLE c/COMPANY_NAME e/EMAIL s/STATUS [t/TAG]...​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Job Description and Deadline are optional fields for an application.
An application can have any number of tags (including 0).
</div>

Examples:
* `add r/SWE Intern c/Goggle e/goggle_careers@gmail.com s/interested`
* `add r/Data Analyst Intern c/Bloomberg e/bloomberg_hires@bloomberg.com`


### Listing all internship applications : `list`

Shows a list of all internship applications, in the order of when they are added. Application
entries that are added more recently will be shown on top.

Format: `list`

Example:
* `list` Returns the current list of internship applications tracked by sprINT.

### Editing an internship : `edit`

Edits an existing internship application to be tracked.

Format: `edit INDEX [r/ROLE] [c/COMPANY_NAME] [e/COMPANY EMAIL] [s/STATUS]​`

* Edits the internship application at the specified `INDEX`. The index refers to the index number shown in the displayed application list. The index **must be a positive integer** 1, 2, 3, …​
<!--* At least one of the optional fields must be provided.-->
* Existing values will be updated to the input values.
<!--* When editing job description, deadline and tags, the existing corresponding values of the these fields in the application will be removed i.e. adding of tags is not cumulative.-->
<!--* You can remove all the application’s job description, deadline and tags by typing `j/` `d/` `t/` without
    specifying any values after it.-->

Examples:
*  `edit 1 r/Cloud Engineer e/goggleHR@example.com` Edits the role and email address of the 1st application to be `Cloud Engineer` and `goggleHR@gmail.com` respectively.
*  `edit 2 s/Rejected t/` Edits the status of the 2nd application to be `Rejected` and clears all existing tags.

### Finding internship applications by keywords: `find`

Finds internship applications with information containing any of the given keywords.

Format: `find keyword(s)` or `find [r/keyword(s)] [c/keyword(s)] [s/keyword(s)]`

* The search is case-insensitive. e.g. `goggle` will match `Goggle`.
* In `find keyword(s)`, when none of the prefixes is specified, the keyword(s) will be searched globally in all prefixes.
* In `find [r/keyword(s)] [c/keyword(s)] [s/keyword(s)]`, `r/`, `c/` and `s/` are prefixes that stand for `role`, `company name` and `status` respectively.
* When at least one prefix is provided, the keyword(s) is searched according to the information under that particular prefix.
* Only full words will be matched e.g. `Han` will not match `Hans` but `Goggle` will match with `Goggle LLC`.

Examples:
* `find Goggle` returns internship applications for `Goggle` and `Goggle LLC`.
* `find Goggle Mata` returns internship applications for `Goggle LLC`, `Mata Platforms`.<br>
* `find r/SWE Intern c/Mata s/Offered` returns internship application(s) for the role of `SWE Intern` at `Mata` that is of the status `Offered`.<br>

### Deleting an application : `delete` 

Deletes the specified application from the internship book.

Format: `delete INDEX`

* Deletes the application at the specified `INDEX`.
* The index refers to the index number shown in the displayed application list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd application in the internship book.
* `find Google` followed by `delete 1` deletes the 1st application in the results of the `find` command.

### Sorting internship applications by specified order: `sort`

Sorts internship applications in the order you want. 

Format: `sort ORDER`: `sort alphabetical` or `sort deadline`

Currently, there are two orders you can choose:
1. `sort alphabetical` sorts applications by their company names in alphabetical order. Should
there be multiple applications to the same company, they will be ranked alphabetically by their roles.
2. `sort deadline` sorts applications by the deadline of their upcoming task. Earlier deadlines will be higher
up in the list.

### Clearing all entries : `clear` 

Clears all entries from the internship book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.
Alternatively, you can exit the program by clicking the top-right X button to close the window.

Format: `exit`

### Saving the data

Data in the internship book are automatically saved in the hard disk after any command that modifies the data. There is no need to save manually.

### Editing the data file

Data in the internship book are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update their data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, the internship book will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous internship book's home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                       | Format, Examples                                                                                                                               |
|------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add** <br/> Application    | `add-app r/ROLE c/COMPANY_NAME e/COMPANY_EMAIL s/STATUS​` <br> e.g., `add-app r/Teaching Assistant c/NUS SOC e/ta_portal@nus.edu.sg s/Offered` |
| **Add** <br/> Task           | `add-task d/DESCRIPTION by/DEADLINE` <br> e.g., `add-task d/Technical Interview by/01-05-2023`                                                 |
| **Clear**                    | `clear`                                                                                                                                        |
| **Delete** <br/> Application | `delete-app INDEX`<br> e.g., `delete-app 3`                                                                                                    |
| **Delete** <br/> Task        | `delete-task INDEX`<br> e.g., `delete-task 3`                                                                                                  |
| **Edit** <br/> Application   | `edit-app INDEX [r/ROLE] [c/COMPANY_NAME] [e/COMPANY EMAIL] [s/STATUS]​`<br> e.g., `edit-app 1 r/Research Intern e/example@bstar.com.sg`       |
| **Edit** <br/> Task          | `edit-task INDEX [d/DESCRIPTION] [by/DEADLINE]` <br> e.g., `edit-task 1 d/Accept offer by/07-05-2023`                                          |
| **Exit**                     | `exit`                                                                                                                                         |
| **Find**                     | `find [search term]` e.g. `find Mata` <br/>`find [r/search term] [c/search term] [s/search term]` e.g. `find r/SWE Intern c/Mata s/Offered`    |
| **List**                     | `list`                                                                                                                                         |
| **Help**                     | `help`                                                                                                                                         |
| **Sort**                     | `sort ORDER` i.e., `sort alphabetical` or `sort deadline`                                                                                      |
| **Undo**                     | `undo`                                                                                                                                         |
