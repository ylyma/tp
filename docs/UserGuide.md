---
title: TAfinder User Guide
---
# TAfinder User Guide
## Overview

Introducing **TAfinder - the one-stop solution for all your TA selection needs**.

With TAfinder, you can easily:
1. **Manage** troves of TA applicants.
2. Make more **informed decisions** with the help of our **compare** and **sort** functions.
3. **Import** and **export** data to and from the TAfinder application.

TAfinder utilises a Command Line Interface (CLI), while still enjoying the benefits of a Graphical User Interface (GUI),
for a more efficient user experience.

So say goodbye to the days of manually sifting through hundreds of TA applications. Enrich your TA selection process with
the power of TAfinder today!

## About This Guide
This guide shows you the relevant information for setting up and using TAfinder to manage your TA applications.

You can click on any of the links below to navigate to the respective sections for more information.


## Table of Contents
<!-- TOC -->
- [1 Quick Start](#1-quick-start)
    - [1.1 Prerequisites](#11-prerequisites)
        - [1.1.1 Java](#111-java)
        - [1.1.2 Glossary](#112-glossary)
    - [1.2 Installation](#12-installation)
    - [1.3 Utilisation](#13-utilisation)
    - [1.4 Navigating the User Interface](#14-navigating-the-user-interface)
- [2 Features](#2-features)
    - [2.1 Basic applicant management](#21-basic-applicant-management)
      - [2.1.1 Adding an applicant: `add`](#211-adding-an-applicant-add)
      - [2.1.2 Editing all applicants: `edit`](#212-editing-an-applicant-edit)
      - [2.1.3 Deleting an applicant: `delete`](#213-deleting-an-applicant-delete)
      - [2.1.4 Listing all applicants: `list`](#214-listing-all-applicant-list)
      - [2.1.5 Viewing an applicant: `view`](#215-viewing-the-details-of-a-single-applicant-view)
      - [2.1.6 Hiding/unhiding an applicant: `hide/unhide`](#216-hiding-an-applicant-from-list-hideunhide)
    - [2.2 Applicant evaluation & comparison](#22-applicant-evaluation--comparison)
      - [2.2.1 Sorting applicants by grades: `sort-gpa`](#221-sorting-applicants-by-gpa-sort-gpa)
      - [2.2.2 Sorting applicants by grades: `sort-grade`](#222-sorting-by-module-grade-sort-grade)
      - [2.2.3 Sorting applicants by interview score: `sort-interview`](#223-sorting-by-interview-score-sort-interview)
      - [2.2.4 Comparing 2 applicants: `compare`](#224-comparing-2-applicants-compare)
      - [2.2.5 Bookmarking/Unbookmarking applicants: `bookmark/unbookmark`](#225-bookmarkingunbookmarking-applicants-bookmarkunbookmark)
      - [2.2.6 Commenting on TA applicant: `comment`](#226-commenting-on-ta-applicant-comment)
    - [2.3 Files and data management](#23-files-and-data-management)
      - [2.3.1 Importing applicants from spreadsheet: `import`](#231-importing-applicants-from-spreadsheet-import)
      - [2.3.2 Attaching file to applicant profiles: `attach`](#232-attaching-file-to-applicant-profiles-attach)
- [3 Data management](#3-data-management)
    - [3.1 Saving the data](#31-saving-the-data)
    - [3.2 Editing the data file](#32-editing-the-data-file)
- [4 Upcoming Features](#4-upcoming-features-coming-in-a-future-update)
- [5 FAQ](#5-faq)
- [6 Known Issues](#6-known-issues)
- [7 Summary](#7-summary)
    - [7.1 Prefix Summary](#71-prefix-summary)
    - [7.2 Command Summary](#72-command-summary)
      - [7.2.1 Basic applicant management commands](#721-basic-applicant-management-commands)
      - [7.2.2 Applicant comparison and evaluation commands](#722-applicant-comparison-and-evaluation-commands)
      - [7.2.3 Data management and export commands](#723-data-management-and-export-commands)

--------------------------------------------------------------------------------------------------------------------

## 1 Quick start

### 1.1 Prerequisites

#### 1.1.1 Java
Ensure you have [Java `11`](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html)
or above installed. Java is the language that your computer uses to understand TAfinder.

<box type="tip">

**Not sure how to check your Java version?**

**Step 1.** Open up **Command Prompt** (Windows) or **Terminal** (Mac and Linux).

**Step 2.** Type and run the command `java -version`.

**Step 3.** Check the version number provided (`xxx`) is at least `11`.

An example is shown below.

  ```
  > java -version
  java version "xxx" <Other information>
  ```

</box>

<div style="page-break-after: always;"></div>

#### 1.1.2 Glossary
| Words/Abbreviations | Explanation                                                                                                                         |
|---------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| **TA**              | Teaching Assistant                                                                                                                  |
| **Applicant**       | Applicant refers to a student who has applied as a TA                                                                               |
| **Mainstream OS**   | Windows, Linux or Mac                                                                                                               |
| **CLI**             | Command-Line Interface                                                                                                              |
| **GUI**             | Graphical User Interface                                                                                                            |
| **Toast**           | A popup alert to inform users about certain information                                                                             |
| **Tag**             | Tags are associated with applicants, users can tag applicants with any keyword they want,<br/>the number of tags are not restricted |

### 1.2 Installation

**Step 1.** Download the latest `tafinder.jar` from [here]().

**Step 2.** Copy the file to the folder you want to use as the _home folder_ for your TAfinder.

**Step 3.** Double-click on the `tafinder.jar` file to start the app.

<box type="tip">

**TAfinder does not open?**

**Step 1.** Open a command terminal.

**Step 2.** Type in `java -jar ` (Keep in mind of the space at the end).

**Step 3.** Drag and drop `tafinder.jar` into the command terminal.

**Step 4.** Press enter and execute the command.

An example of the final command is displayed below.

  ```
  > java -jar xxxx/xxxx/tafinder.jar
  ```

</box>

The GUI similar to the below should appear in a few seconds. ![Ui](images/Ui.png)

### 1.3 Utilisation

**Step 1:** Type the command in the Command Input Box and press Enter to execute it. e.g. typing **`help`** and
pressing Enter will open the help window.<br>
Some example commands you can try:

- `list` : Lists all contacts.

- `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

- `delete 3` : Deletes the 3rd contact shown in the current list.

- `clear` : Deletes all contacts.

- `exit` : Exits the app.

**Step 2:** Observe the changes to the application.<br>

<box type="tip">

**Not sure what the commands above does?**

You can find all about the usable commands [here](#2-features),<br>
look at a summary of all the usable commands [here](#72-command-summary),<br>
OR return to the [Table of Contents](#table-of-contents) to find your desired command.

</box>

### 1.4 Navigating the User Interface
![UI with shaded areas](images/tafinder-UI.png)

The UI has the following areas:
- <span style="background-color:rgba(126, 217, 87, 1)">Navigation bar</span>
  - This is where you can navigate to the `File` and `Help` menus.
- <span style="background-color:rgba(255, 222, 89, 1)">Command Input Box</span>
  - This where commands are typed
  - press `Enter` to execute it.
- <span style="background-color:rgba(255, 112, 112, 1)">Command Result Screen</span>
  - This is where the result of the command is displayed. Applicants are displayed in a list format.
- <span style="background-color:rgba(170, 210, 232, 1)">Applicant list</span>
  - This is where the list of applicants is displayed.

--------------------------------------------------------------------------------------------------------------------

## 2 Features

<box type="info">

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`,<br>
`NAME` is a parameter which can be used as `add n/John Doe`.


* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` ,<br>
can be used as `n/John Doe t/friend` or as `n/John Doe`


* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​`,<br>
can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.


* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`,<br>
`p/PHONE_NUMBER n/NAME` is also acceptable.


* Extraneous parameters will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.


* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple
lines as space characters surrounding line-breaks may be omitted when copied over to the application.

</box>

---

### **2.1 Basic applicant management**

#### 2.1.1 Adding an applicant: `add`

![add.jpg](images/add.jpg)

<box type="definition">

Adds a new applicant to the list of applicants.

</box>

<box type="info">

**Format:**

**`add [s/STUDENT_NUMBER] [n/NAME] [p/PHONE] [e/EMAIL] [g/GPA] [c/comment] [t/TAG]…`**

<box no-icon type="info" light>

- **`s/STUDENT_NUMBER`**: Student number of the applicant
- **`n/NAME`**: Name of the applicant.
- **`p/PHONE`**: Phone number of the applicant.
- **`e/EMAIL`**: Email address of the applicant.
- **`g/GPA`**: GPA of the applicant.
- **`c/COMMENT`**: Comments for the applicant.
- **`t/TAG`**: Tags of the applicant. Note that editing tags will replace existing tags; it is not cumulative.

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`add s/A0269357C n/john doe p/91234567 e/johndoe@example.com g/5.0 c/ t/pastTA t/deanslist`**
- Adds a person with the following information:
  - **Student number**: A0269357C
  - **Name**: John Doe
  - **Phone number**: 91234567
  - **Email address**: johndoe@example.com
  - **GPA**: 5.0
  - **Comment**: -
  - **Tags**: pastTA, deanslist

</box>

<box type="default" light>

**`add s/A0251647W n/amanda p/89064678 e/amanda@example.com g/4.3 c/Hardworking`**
- Adds a person with the following information:
  - **Student number**: A0251647W
  - **Name**: Amanda
  - **Phone number**: 89064678
  - **Email address**: amanda@example.com
  - **GPA**: 4.3
  - **Comment**: Hardworking

</box>

</box>

<box type="success">

**Expected Outputs:**

<box type="success" light>

Successfully adding applicant and applicant's information.<br>
Confirmation message:<br>
**`"New applicant added: Student number: <student number>; Name: <name>; Phone: <phone>; Email: <email>; GPA: <gpa>; Comment: <comment>; Tags: <tags>"`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Invalid command format:<br>
**`"Invalid command format!"`<br>
`"add: Adds an applicant to the list. Parameters: s/STUDENT NUMBER n/NAME p/PHONE e/EMAIL g/GPA c/comment [t/TAG]..."`<br>
`"Example: add s/A0343434C n/John Doe p/98765432 e/johnd@example.com g/4.9 c/Hardworking and diligent t/pastTA"`**

</box>

<box type="wrong" light>

Repeated applicant:<br>
**`"This applicant already exists in the applicant list."`**

</box>

<box type="wrong" light>

Missing fields:<br>
**`"Error: Missing fields. Please follow the format: add [n/NAME] [p/PHONE] [e/EMAIL] [g/GPA] [t/TAG]…"`**

</box>

</box>

---

#### 2.1.2 Editing an applicant: `edit`

![edit function UI](images/editUI.png)

<box type="definition">

Edits an existing applicant in the list of applicants.

</box>

<box type="info">

**Format:**

**`edit INDEX [s/STUDENT NUMBER] [n/NAME] [p/PHONE] [e/EMAIL] [g/GPA] [c/comment] [t/TAG]…`**

<box no-icon type="info" light>

- **`INDEX`**: The index of the applicant to edit. The index must be a positive integer (e.g., 1, 2, 3…).

</box>

<box no-icon type="info" light>

- `[optional fields]`: **At least one** of the following optional fields must be provided for editing:
    - **`s/STUDENT NUMBER`**: Student number of the applicant.
    - **`n/NAME`**: Name of the applicant.
    - **`p/PHONE`**: Phone number of the applicant.
    - **`e/EMAIL`**: Email address of the applicant.
    - **`g/GPA`**: GPA of the applicant.
    - **`c/comment`**: Comment of the applicant.
    - **`t/TAG`**: Tags of the applicant. Note that editing tags will replace existing tags; it is not cumulative.
    - To remove all existing tags, use **`t/`** without specifying any tags after it.

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`edit 1 p/91234567 e/johndoe@example.com`**
- Edits the following fields of the first person in the list:
  - **Phone number**: **`91234567`**
  - **Email address**: **`johndoe@example.com`**

</box>

<box type="default" light>

**`edit 2 n/Betsy Crower t/`**
- Edits the following fields of the second person in the list:
  - **Name**: **`Betsy Crower`**
  - Clears all existing tags

</box>

</box>

<box type="success">

**Expected Outputs:**

<box type="success" light>

Successfully editing applicant and applicant's information.<br>
Confirmation message:<br>
  **`"Edited applicant: Student number: <student number>; Name: <name>; Phone: <phone>; Email: <email>; GPA: <gpa>; Comment: <comment>; Tags: <tags>"`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Invalid command format:<br>
  `"Invalid command format!`<br>
  `edit: Edits the details of the applicant identified by the index number used in the displayed applicant list. Existing values will be overwritten by the input values.`<br>
  `Parameters: INDEX (must be a positive integer) [n/NAME] [p/PHONE] [e/EMAIL] [g/GPA] [c/COMMENT] [t/TAG]..."`

</box>

<box type="wrong" light>

Index out of range:<br>
**`"Error: Invalid index. Please enter an index within range."`**

</box>

</box>

---

#### 2.1.3 Deleting an applicant: `delete`
![delete function UI](images/delete-UI.png)

<box type="definition">

Delete an existing applicant in the list of applicants.

</box>

<box type="info">

**Format:**

**`delete INDEX`**

<box no-icon type="info" light>

**`INDEX`**: The index corresponding to the applicant to be deleted. The index must be a positive integer (e.g., 1, 2, 3…).

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`delete 3`**
- Deletes the third applicant in the list.

</box>

</box>

<box type="success">

**Expected Outputs:**

<box type="success" light>

Successfully delete applicant and applicant's information at the given index.<br>
Confirmation message:<br>
**`"Deleted applicant: Student number: <student number>; Name: <name>; Phone: <phone>; Email: <email>; GPA: <gpa>; Comment: <comment> ; Tags: <tags>"`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Missing index: <br>
  **`"Invalid command format!`<br>
  `delete: Displays the applicant identified by the index number used in the displayed applicant list.`<br>
  `Parameters: INDEX (must be a positive integer)`<br>
  `Example: delete 1"`**

</box>

<box type="wrong" light>

Index out of range:<br>
  **`"Error: Invalid index. Please enter an index within range."`**

</box>

</box>

---

#### 2.1.4 Listing all applicant: `list`
![listUI-1](images/listUI-1.png)
![listUI-2](images/listUI-2.png)

<box type="definition">

Shows a list of all applicants.

</box>

<box type="info">

**Format:**

**`list`** / **`list-hidden`** / **`list-bookmarked`**

<box no-icon type="info" light>

**`list`**
- Shows a list of all applicants.

</box>

<box no-icon type="info" light>

**`list-hidden`**
- Shows a list of all hidden applicants.

</box>

<box no-icon type="info" light>

**`list-bookmarked`**
- Shows a list of all bookmarked applicants.

</box>

</box>

---

#### 2.1.5 Viewing the details of a single applicant: `view`

![edit function UI](images/viewUI.png)

<box type="definition">

Displays a single applicant.

</box>

<box type="info">

**Format:**

**`view INDEX`**

<box no-icon type="info" light>

**`INDEX`**: The index corresponding to the applicant to be displayed. The index must be a positive integer (e.g., 1, 2, 3…).

</box>

</box>

<box type="default" theme="dark">

**Examples:**

<box type="default" light>

**`view 3`**
- Displays the following details about the third applicant.
  - Name
  - Student number
  - Phone number
  - Email Address
  - GPA
  - Comments
  - Tags

</box>

</box>

<box type="success">

**Expected Outputs:**

<box type="success" light>

Successfully displaying all details of an applicant in the following format:\
- **`Name: John Doe`**
- **`Student number: A0358289S`**
- **`Phone Number: 91234567`**
- **`Email Address: johndoe@example.come`**
- **`GPA: 5.0`**
- **`Comments: Good fit, has teaching experience`**
- **`Tags: pastTA, deansList`**

</box>

<box type="success" light>

Confirmation message:<br>
**`"Displaying: APPLICANT_NAME"`**

</box>

</box>


<box type="wrong">

**Errors:**

<box type="wrong" light>

Missing index: <br>
**`"Invalid command format!`<br>
  `view: Displays the applicant identified by the index number used in the displayed applicant list.`<br>
  `Parameters: INDEX (must be a positive integer)`<br>
  `Example: view 1"`**

</box>

<box type="wrong" light>

Index out of range:<br>
**`"Error: Invalid index. Please enter an index within range."`**

</box>

</box>

---
#### 2.1.6 Hiding an applicant from list: `hide`/`unhide`

![hide function UI](images/hideUI.png)

<box type="definition">

Hides/unhides an applicant from the list of applicants.

</box>

<box type="info">

**Format:** 

`hide INDEX` / `unhide INDEX` / `unhide-all`

<box no-icon type="info" light>

`hide INDEX`
- Hides the applicant at the specified INDEX from all future lists. The index refers to the number shown in the displayed person list.

</box>

<box no-icon type="info" light>

`unhide INDEX`
- Unhides the applicant at the specified INDEX from all future lists. The index refers to the number shown in the displayed person list.

</box>

<box no-icon type="info" light>

`unhide-all`
- Unhides all applicants that were previously hidden.

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`hide 2`**
- Hides the applicant at index 2

</box>

<box type="default" light>

**`unhide 2`**
- Unhides the applicant at index 2

</box>

<box type="default" light>

**`unhide-all`**
- Unhides all applicants

</box>

</box>

<box type="success">

**Expected Outputs:**

<box type="success" light>

Successfully hiding/unhiding applicant(s).<br>
Confirmation message:<br>
**`APPLICANT_NAME hidden successfully.`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Missing index:<br>
**`"Invalid command format!`<br>
  `hide: Hides an applicant, identified by the index number used in the last list, from all future lists of applicants.`<br>
  `Parameter: INDEX (must be a positive integer)`<br>
  `Example: hide 1"`**

</box>

<box type="wrong" light>

Index out of range:<br>
**`“Error: Invalid index. Please enter an index within range.”`**

</box>

</box>

---

### **2.2 Applicant evaluation & comparison**

#### 2.2.1 Sorting applicants by GPA: `sort-gpa`

![sort function UI](images/sortUI.png)

<box type="definition">

Sorts applicants by grades in descending order

</box>

<box type="info">

**Format:**

**`sort-gpa`**

</box>

<box type="success">

**Expected Output:**

<box type="success" light>

- A list of applicants sorted by grades in descending order.

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Empty list:<br>
**`"No applicants to sort."`**

</box>

</box>

---

#### 2.2.2 Sorting by module grade: `sort-grade`

---

#### 2.2.3 Sorting by interview score: `sort-interview`

---

#### 2.2.4 Comparing 2 applicants: `compare`

![compare function UI](images/compareUI.png)

<box type="definition">

Compares two applicants side by side to make informed decisions.

</box>

<box type="info">

**Format:**

**`compare INDEX1 INDEX2`**

<box no-icon type="info" light>

**`INDEX1`**: The index of the first applicant to compare.

</box>

<box no-icon type="info" light>

**`INDEX2`**: The index of the second applicant to compare.<br>
Both indices must be a positive integer (e.g., 1, 2, 3…), and should not be the same.

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`compare 1 2`**
- Compares the first and second applicants.

</box>

</box>

<box type="success">

**Expected Output:**

<box type="success" light>

- A side-by-side comparison of the two applicants is displayed in a user-friendly format.
- This comparison window will include:
  - Student number
  - Name
  - Various TA selection criteria such as:
    - GPA
    - CCA count
    - Interview Performance Rating (IPR)
    - tags
- The system highlights the differences between the two applicants, making it easy to see variations in their profiles.

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Applicant not found:<br>
**`"Error: One or both of the specified applicants were not found in the list."`**

</box>

<box type="wrong" light>

Comparing the same applicant:<br>
**`"Error: Please provide distinct indices. You cannot compare the same applicant."`**

</box>

</box>

---

#### 2.2.5 Bookmarking/Unbookmarking applicants: `bookmark/unbookmark`

![bookmark function UI](images/bookmarkUI.png)

<box type="definition">

Bookmarks/Unbookmarks a specific applicant.

</box>

<box type="info">

**Format:**

**`bookmark INDEX` / `unbookmark INDEX`**

<box no-icon type="info" light>

**`INDEX`**: The index corresponding to the applicant to be bookmarked/unbookmarked. The index must be a positive integer (e.g., 1, 2, 3…).

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`bookmark 3`**
- Bookmarks the third applicant.

</box>

<box type="default" light>

**`unbookmark 3`**
- Unbookmarks the third applicant.

</box>

</box>

<box type="success">

**Expected Output:**

<box type="success" light>

- Successfully bookmark/unbookmark applicant at the given index.
- Confirmation message:<br>
**`"Applicant at index INDEX has been successfully bookmarked/unbookmarked."`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Missing index:<br>
**`"Invalid command format!`<br>
  `bookmark: Bookmarks an applicant, identified by the index number used in the last list, from all future lists of applicants.`<br>
  `Parameter: INDEX (must be a positive integer)`<br>
  `Example: bookmark 1"`**

</box>

<box type="wrong" light>

Index out of range:<br>
**`"Error: Invalid index. Please enter an index within range."`**

</box>

</box>

---

#### 2.2.6 Commenting on TA applicant: **`comment`**

![comments.jpg](images/comment.jpg)

<box type="definition">

Add comments on a specific applicant

</box>

<box type="info">

**Format:**

**`comment INDEX COMMENT`**

<box no-icon type="info" light>

**`INDEX`**: The index corresponding to the applicant to be commented. The index must be a positive integer (e.g., 1, 2, 3…).

</box>

<box no-icon type="info" light>

**`COMMENT`:** The comment to be made about the applicant.

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`comment 3 Hardworking and studious`**
- Comments on the third applicant with the comment: "Hardworking and studious"

</box>

</box>

<box type="success">

**Expected outputs:**

<box type="success" light>

- Successfully commenting on the applicant at the corresponding index.
- Confirmation message:<br>
**`"Applicant at index INDEX has been successfully commented on."`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Missing index:<br>
**`“Error: Missing index. Please follow the format: 'view INDEX'.”`**

</box>

<box type="wrong" light>

Index out of range:<br>
**`“Error: Invalid index. Please enter an index within range.”`**

</box>

</box>

---

### 2.3 Files and data management

#### 2.3.1 Importing applicants from spreadsheet: `import`

<box type="definition">

Imports an entire list of applicants along with their details from a CSV file.

</box>

<box type="info">

**Format:**

**`import FILENAME`**

<box no-icon type="info" light>

**`FILENAME`**: The desired filename of the CSV file to import from (including the file extension)

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`import ta-applicants.csv`**
- Imports a entire list of applicants, from a file in the CSV format called `ta-applicants.csv` in the same directory as the JAR file, into TAfinder

</box>

</box>

<box type="success">

**Expected Output:**

<box type="success" light>

- Successfully attaching a file to the applicant at the corresponding index.
- Sample confirmation message:<br>
**`"Imported 10 applicants successfully!"`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Missing file permissions or invalid file path:<br>
**`"Failed to open and load applicant file."`**

</box>

</box>

---

#### 2.3.2 Attaching file to applicant profiles: `attach`

![attach function UI](images/attachUI.png)

<box type="definition">

Attaches local files to the profiles of applicants to provide even more richness and insight into their applications

</box>

<box type="info">

**Format:**

**`attach INDEX f/FILEPATH`**

<box no-icon type="info" light>

**`INDEX`**: The index of the applicant to edit. The index must be a positive integer (e.g., 1, 2, 3…).

</box>

<box no-icon type="info" light>

**`FILEPATH`**: The desired path of the file to attach to the applicant’s profile. This is relative to the path of the JAR file unless either `/` or `C:\` is at the start of the path, then the path will be treated as an absolute path.

</box>

</box>

<box type="info" theme="dark">

**Examples:**

<box type="default" light>

**`attach 2 f/john-resume.pdf`**
- Attaches the file called `john-resume.pdf` in the same directory as the `tafinder.jar` file to the second applicant in the applicant list

</box>

<box type="default" light>

**`attach 78 f//home/jennifer/resumes/benson-resume.pdf`**
- Attaches the file called `benson-resume.pdf` in the directory `/home/jennifer/resumes` to the 78th applicant in the applicant list

</box>

</box>

<box type="success">

**Expected Output:**

<box type="success" light>

- Successfully attaching a file to the applicant at the corresponding index.
- Sample confirmation message:<br>
**`"Attached 1 attachments to Alex Yeoh!"`**

</box>

</box>

<box type="wrong">

**Errors:**

<box type="wrong" light>

Invalid file path or corrupted data:<br>
**`"Failed to copy attachment."`**

</box>

<box type="wrong" light>

Any other unexpected error:<br>
**`"Error: Unknown error. Please contact the app developer at contact@email.com"`**

</box>

</box>

---
## 3 Data Management
### 3.1 Saving the data

TAfinder data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### 3.2 Editing the data file

TAfinder data are saved automatically as a JSON file `[JAR file location]/data/tafinder.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning">

**Warning:**

If your changes to the data file makes its format invalid, TAfinder will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.

</box>

--------------------------------------------------------------------------------------------------------------------
## 4 Upcoming Features [coming in a future update!]

--------------------------------------------------------------------------------------------------------------------

## 5 FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## 6 Known Issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------
## 7 Summary
### 7.1 Prefix Summary
| Parameter      | Prefix | Rules                                                                                                                                                                                                              |
|----------------|--------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Student number | s/     | - Should be in the format `AdddddddL`, <br/>where `d` represents digit and `L` represents capital letters.                                                                                                         |
| Name           | n/     | - Should only contains alphanumeric characters and spaces.                                                                                                                                                         |
| Phone          | p/     | - Should only contain digits<br/>- Should have at least 3 digits.                                                                                                                                                  |
| Email          | e/     | - Should only be of the form `local@domain` and only accept alphanumeric characters<br/>- `local` allows for special characters `+`, `_`, `.` and `-` as well.<br/>- `domain` must be at least 2 letters long<br/> |
| GPA            | g/     | - Should be in the range of 0.00 to 5.00 inclusive.<br/>- Can be given in 0, 1 or 2 decimal places.                                                                                                                |
| Comment        | c/     | - Can be any character.                                                                                                                                                                                            |
| Tag            | t/     | - Should only contain alphanumeric characters.<br/>- Should not contain spaces.                                                                                                                                    |


### 7.2 Command Summary
#### 7.2.1 Basic applicant management commands
| Action          | Format, Examples                                                                                                                                                               |
|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**         | - `add [s/STUDENT_NUMBER] [n/NAME] [p/PHONE] [e/EMAIL] [g/GPA] [t/TAG]…` <br> - e.g., `add s/A0269357C n/john doe p/91234567 e/johndoe@example.com g/5.0 t/pastTA t/deanslist` |
| **Edit**        | - `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> - e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                                |
| **Delete**      | - `delete INDEX`<br> - e.g., `delete 3`                                                                                                                                        |
| **List**        | - `list`                                                                                                                                                                       |
| **View**        | - `view INDEX`<br> - e.g., `view 3`                                                                                                                                            |
| **Hide/Unhide** | - `hide INDEX` / `unhide INDEX`<br/> - e.g., `hide 3` / `unhide 3`                                                                                                             |
                                                                                                                                                       |
#### 7.2.2 Applicant comparison and evaluation commands
| Action                  | Format, Examples                                                                  |
|-------------------------|-----------------------------------------------------------------------------------|
| **Sort GPA**            | - `sort-gpa`                                                                      |
| **Compare**             | - `compare INDEX1 INDEX2`<br> - e.g.,`compare 1 2`                                |
| **Bookmark/Unbookmark** | - `bookmark INDEX` / `unbookmark INDEX`<br> - e.g., `bookmark 3` / `unbookmark 3` |
| **Comment**             | - `comment INDEX COMMENT`<br/> - e.g., `comment 3 Hardworking`                    |


#### 7.2.3 Data management and export commands
| Action                  | Format, Examples                                                |
|-------------------------|-----------------------------------------------------------------|
| **Export**              | - `export FILENAME`<br/> - e.g., `export ta-applicants.csv`     |
| **Attach**              | - `attach INDEX FILEPATH`<br> - e.g.,`attach 2 john-resume.pdf` |
