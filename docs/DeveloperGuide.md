---
title: Developer Guide
show-sticky-toc: true
---

## Acknowledgements

* Reused code from [ToothTracker](https://github.com/AY2324S1-CS2103T-W10-3/tp) for table of contents, sticky navigation and auto-numbering of headers for website

--------------------------------------------------------------------------------------------------------------------

## Setting up, getting started

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## Design

### Architecture

<img src="images/ArchitectureDiagram.png" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<img src="images/ComponentManagers.png" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

![Structure of the UI Component](images/UiClassDiagram.png)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

### Logic component

**API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<img src="images/LogicClassDiagram.png" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("delete 1")` API call as an example.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">
:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<img src="images/ParserClasses.png" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

### Model component
**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<img src="images/ModelClassDiagram.png" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects.<br>

<img src="images/BetterModelClassDiagram.png" width="450" />

</div>

### Storage component

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<img src="images/StorageClassDiagram.png" width="550" />

The `Storage` component,
* can save both address book data and user preference data in JSON format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

--------------------------------------------------------------------------------------------------------------------

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## Implementation

This section describes some noteworthy details on how certain features are implemented.

### Hide/unhide feature

The hide/unhide mechanism introduces the capability to selectively hide certain applicants from view, improving user experience and providing greater control over the displayed information. This also includes a way to view all hidden applicants in a list. 

#### Implementation

This feature implements the following operations:

* `HideCommand#execute()` — Hides the specified applicant from the list.
* `UnhideCommand#execute()` — Unhides the specified applicant from the list.
* `UnhideAllCommand#execute()` — Unhides all hidden applicants.
* `ListHiddenCommand#execute()` — Displays a list of all hidden applicants.

Given below is an example usage scenario and how the hide/unhide mechanism behaves at each step.

Step 1. The user launches the application for the first time. The applicant list displays all applicants without any hidden applicants.

Step 2. The user decides to hide the 3rd applicant in the applicant list by executing hide 3. The `hide` command calls `Model#setPerson()` to replace the applicant with a hidden version.  `Model#updateFilteredPersonList()` to update the list of applicants displayed in the UI to exclude the hidden applicant.

Step 3. The user executes `list hidden` to view all hidden applicants. The `list hidden` command calls `Model#updateFilteredPersonList()` to update the list of applicants displayed in the UI to include only hidden applicants.

Step 4. The user decides to unhide the 1st applicant in the hidden applicant list by executing unhide 1. The `hide` command calls `Model#setPerson()` to replace the hidden applicant with a non-hidden version. The `unhide` command calls `Model#updateFilteredPersonList()` to update the list of applicants displayed in the UI to include the unhidden applicant.

Step 5. Alternatively, the user can choose to unhide all hidden applicants by executing unhide all. The `unhide all` command creates a copy of the model and calls `Model#updateFilteredPersonList()` and `Model#getFilteredPersonList()` on that model to receive a list of hidden applicants. It then replaces every hidden person in the original model with a non-hidden version by calling `Model#setPerson()`. The `unhide all` command calls `Model#updateFilteredPersonList()` to update the list of applicants displayed in the UI to include all unhidden applicants.

The following sequence diagram shows how the undo operation works:

![HideSequenceDiagram](images/HideSequenceDiagram.png)

The following activity diagram summarizes what happens when a user executes a new command:

<img src="images/HideActivityDiagram.png" width="250" /

### Bookmark/Unbookmark feature
The bookmark/unbookmark mechanism gives users the ability to bookmark or unbookmark certain applicants they want to take note of, as well as list these bookmarked applicants. This allows users to better differentiate between a long list of applicants, improving the ease of usage of this application and user experience.

#### Implementation

The bookmark/unbookmark mechanism is mainly facilitated by the `BookmarkCommand/UnbookmarkCommand`, `BookmarkCommandParser/UnbookmarkCommandParser`, and `isBookmarked` classes. It extends the abstract class `Command` with an `execute` functionality, to facilitate the execution of the command. Specifically, the bookmark/unbookmark feature is implemented through the following components and operations:
- `BookmarkCommand/UnbookmarkCommand` — Core component responsible for executing the bookmarking/unbookmarking of a specific applicant.
- `BookmarkCommandParser/UnbookmarkCommandParser` — Contains the functionalities for user input parsing. It ensures that user input is valid as a bookmark/unbookmark command by meeting specific requirements.
- `Person` — Represents the TA applicants with their respective fields, such as `isBookmarked`.
- `isBookmarked` — Represents whether an applicant is bookmarked or not through the use of a Boolean value.

Given below is an example usage scenario and how the bookmark/unbookmark mechanism behaves at each step.

Step 0. Assume that there is an existing list of applicants in the application after launch.

Step 1. The user launches the application. Applicant list is displayed.

Step 2. The user executes `bookmark 5` command to bookmark the 5th applicant in TAfinder. The `BookmarkCommmandParser` is invoked to parse the user's input.

Step 3. `BookmarkCommandParser` will then invoke ParserUtil for parsing of the index and check for index errors. If the index is invalid, the system will generate an error message. The error message will be displayed to the user, providing clear feedback about the issue and the specific constraints that are not met.

Step 4. If the index is valid, `BookmarkCommand#execute()` fetches the intended applicant from the currently visible list and bookmarks the applicant with the corresponding index.

Step 5. Then, `BookmarkCommand#execute()` updates `Model#setModel` with the updated Person. Displaying the updated applicant list with a bookmark indicator.

Step 6. A success message is displayed to the user to confirm that the applicant has been bookmarked successfully.

Step 7. The user then decides to view all bookmarked applicants by executing the `list-bookmarked` command. The `list-bookmarked` command calls `Model#updateFilteredPersonList()`, which updates the list of applicants presented in the UI to only include bookmarked applicants.

The following sequence diagram shows how the bookmark operation works:

![BookmarkSequenceDiagram](images/BookmarkSequenceDiagram.png)

The following activity diagram summarizes what happens when a user executes a `bookmark` command:

![BookmarkActivityDiagram](images/BookmarkActivityDiagram.png)


### View feature

#### Implementation

The view mechanism gives users the ability to view a specific applicant's details. This allows users to better focus on and evaluate a singular applicant when they need to, improving the ease of usage of this application and user experience.
The view mechanism is mainly facilitated by the `ViewCommand` and `ViewCommandParser` classes. It extends the abstract class `Command` with an `execute` functionality, to facilitate the execution of the command. Specifically, the view feature is implemented through the following components and operations:
- `ViewCommand` — Core component responsible for executing the the viewing of a singular applicant's details from the list.
- `ViewCommandParser` — Contains the functionalities for user input parsing. It ensures that user input is valid as a view command by meeting specific requirements.
- `Person` — Represents the TA applicants with their respective fields.

Given below is an example usage scenario and how the view mechanism behaves at each step.

Step 0. Assume that there is an existing list of applicants in the application after launch.

Step 1. The user launches the application. Applicant list is displayed.

Step 2. The user executes `view 5` command to view the details of the 5th applicant in TAfinder. The `ViewCommmandParser` is invoked to parse the user's input.

Step 3. `ViewCommandParser` will then invoke ParserUtil for parsing of the index and check for index errors. If the index is invalid, the system will generate an error message. The error message will be displayed to the user, providing clear feedback about the issue and the specific constraints that are not met.

Step 4. If the index is valid, `ViewCommand#execute()` fetches the intended applicant.

Step 5. Then, `CommentCommand#execute()` calls `Model#showPersonAtIndex` to set `Model#currentPerson` with the intended applicant (in the form of a `Person`). `PersonDetailPanel` displays details of the intended applicant corresponding to the given index.

Step 6. A success message is displayed to the user to confirm that specified applicant's details has been displayed successfully.

The following sequence diagram shows how the `view` operation works:

![ViewSequenceDiagram](images/ViewSequenceDiagram.png)

The following activity diagram summarizes what happens when a user executes a `view` command:

![ViewActivityDiagram](images/ViewActivityDiagram.png)


### Compare feature

#### Implementation

The compare mechanism allows users to compare two distinct TA applicants in the TAfinder app. The compare mechanism is mainly facilitated by the `CompareCommand`, `CompareCommandParser`, and `CompareWindow` classes. It extends the abstract class `Command` with an `execute` functionality, to facilitate the execution of the command. Specifically, the compare feature is implemented through the following components and operations:

- `CompareCommand` — Core component responsible for executing the comparison of two TA applicants in the list.
- `Person` — Represents the TA applicants with their respective fields, such as `Gpa`, to be used for comparison.
- `CompareCommandParser` — Contains the functionalities for user input parsing. It ensures that user input is valid as a compare command by meeting specific requirements.
- `CompareWindow` — Main User Interface (UI) for after a compare command is successfully executed. It will display the content of the two TA applicants side by side.


Given below is an example usage scenario and how the compare mechanism behaves at each step.

Step 0. Assume that there is an existing list of applicants in the application after launch.

Step 1. The user enters the compare command `compare 1 2` to compare the first and second applicants in the existing list. The `CompareCommandParser` is invoked to parse the user's input.

Step 2. `CompareCommandParser` will then invoke `ParserUtil` for parsing of the indices and check for index errors. If indices are invalid, the system will generate an error message. The error message will be displayed to the user, providing clear feedback about the issue and the specific constraints that are not met.

Step 3. If indices are valid, `CompareCommand#execute()` fetches the two intended applicants from the currently visible list and ensures that both indexes do not point to the same applicant.

Step 4. Then, `CompareCommand#execute()` creates a new `CompareWindow` instance which is immediately shown, with the two applicants' information passed to `CompareWindow`, in the form of the `Person` model.

The following sequence diagram displays how the compare function works until Step 4:

![CompareSequenceDiagram](images/CompareSequenceDiagram.png)

Step 5. `CompareWindow` handles the GUI presentation aspects, in the form of a pop-up window. It uses the JavaFX `GridPane` layout to display the respective `Person` attributes side-by-side.

Step 6. A success message is displayed to the user to confirm that the comparison of applicants is successful.

The following activity diagram summarizes what happens when a user executes a `compare` command:

![CompareActivityDiagram](images/CompareActivityDiagram.png)

### Comment feature

#### Implementation
The comment command allows users to insert a comment on TA applicants in TAfinder app.
The comment mechanism is mainly facilitated by the `CommentCommand` and `CommentCommandParser` classes. It extends the abstract class `Command` with an `execute` functionality, to facilitate the execution of the command. Specifically, the comment feature is implemented through the following components and operations:

- `CommentCommand` — Core component responsible for executing the adding of comments to a TA applicant in the list.
- `CommentCommand#execute` — Adds the comment to the specific applicant in the list.
- `CommentCommandParser` — Contains the functionalities for user input parsing. It ensures that user input is valid as a compare command by meeting specific requirements.

Given below is an example usage scenario and how the comment mechanism behaves at each step.

Step 1. The user launches the application for the first time. The applicant list displays all applicants.

Step 2. The user decides to comment on the 3rd applicant in the applicant list with `Hardworking` as the comment by executing `comment 3 Hardworking`. The `CommentCommmandParser` is invoked to parse the user's input.

Step 3. `CommmentCommandParser` will then invoke ParserUtil for parsing of the index and check for index errors. If the index is invalid, the system will generate an error message. The error message will be displayed to the user, providing clear feedback about the issue and the specific constraints that are not met.

Step 4. If the index is valid, `CommentCommand#execute()` fetches the intended applicant from the currently visible list and adds the comment `Hardworking` to the applicant with the corresponding index. The adding of comment is destructive, meaning if the specified applicant has an existing comment, it will be overwritten.

Step 5. Then, `CommentCommand#execute()` updates `Model#setModel` with the updated Person. Displaying the updated applicant list with the comment added.

Step 6. A success message is displayed to the user to confirm that the comment has been added to the applicant successfully.

#### Design considerations

**Aspect: Comparison GUI:**

* **Alternative 1 (current choice):** Compare two applicants in one pop-up window.
    * Pros:
      1. Easier to implement the pop-up window
      2. Able to avoid over-dependencies within the UI component.
    * Cons: Design may not be uniform with main window.

* **Alternative 2:** Compare two applicants in the main window.
    * Pros:
      1. Easy view of information.
    * Cons:
      1. Difficult to implement the UI change when a compare command is inputted, as whole window needs to be modified.
      2. Inconvenient to refer back to list of applicants if needed.

* **Alternative 3:** Compare multiple (two or more) applicants.
    * Pros: More convenient to choose between applicants.
    * Cons: Harder to implement the UI.


### Import feature

The import feature allows users to mass-create applicants within the application, from a list of applicants in a CSV file. This file could be exported from mySoC or elsewhere, as long as it is in the correct format.

#### Implementation

The format of the CSV file is as follows:

1. The file must only contain text separated by commas and newlines — a limited subset of the true CSV file format. No escaping or quoting is allowed.
2. The first line must be the header row, containing column names. The columns can be in any order, but must contain the following (case-sensitive):
   - studentNo
   - name
   - phone
   - email
   - gpa
   - previousGrade
   - tags
3. The following lines contain one applicant per row. The data of the applicant should be in the order of which the header row specified the columns i.e. if column 1 is `studentNo`, the first cell of each row should contain the applicant's student number.

Here is an example CSV:

```csv
studentNo,name,phone,email,gpa,previousGrade,tags
A0123486A,Jasmine David,98472983,jasmine_david@u.nus.edu,4.3,B+,deansList;pastTA
A0456123A,Sandeep Kopparthi,86753746,sandeep@u.nus.edu,5.0,B+,pastTA
A0775848D,Lim Boon Kong,97777777,boonkong@u.nus.edu,3.5,C,deansList
A0483910A,Mohammed Taufiq bin Rozaini,85535252,taufiq@u.nus.edu,4.2,A+,
```

The import mechanism is mainly facilitated by the `ImportCommand`, `ImportCommandParser`, and `Attachment` classes. It extends the abstract class `Command` with an `execute` functionality, to facilitate the execution of the command. Specifically, the import feature is implemented through the following components and operations:

- `ImportCommand` — Core component responsible for executing the import of TA applicants from the CSV file.
- `ImportCommandParser` — Contains the functionalities for user input parsing. It ensures that user input is valid as an import command by meeting specific requirements.
- `Person` — Represents the TA applicants with their respective fields, such as `Attachment`, which are created and added to the main model.
- `Attachment` — Represents a reference to a file. This is merely used as a representation and handle to a file rather than to attach to any `Person` in particular.

Given below is an example usage scenario and how the attach mechanism behaves at each step.

Step 0. Assume that there is a valid CSV file to import named `applicants.csv`, such as the one above, and that it is in the same directory as the `tafinder.jar` file that was executed.

Step 1. The user enters the import command `import applicants.csv` to import applicants from the CSV file specified in the previous step.

Step 2. `ImportCommandParser` will then invoke `ParserUtil` for parsing of the file path to check for any invalid path characters. If the file path contains invalid path characters, the system will generate an error message. The error message will be displayed to the user, providing clear feedback about the issue and the specific constraints that are not met.

Step 3. If indices are valid, `ImportCommand#execute()` opens the file and creates a `Scanner` over the file handle.

Step 4. Then, the header row of the CSV is read and the order of the headers is saved into a map for later reference.

Step 5. Next, a loop is executed to read through the rows of the CSV one-by-one. Each row is split via the comma, then parsed in the order that was recorded in the previous step. Any validation errors found cause a new error line number to be reported as an error, but no exception is thrown as we want to parse as many applicants as possible. A `Person` instance is created with the relevant data for each successful line i.e. no validation error.

Step 6. Finally, a message is displayed to the user indicating the number of applicants successfully imported, the number of applicants that failed to be imported, and the line numbers containing those failed applicants.


### Attach feature

The attach feature allows users to attach files to TA applicants in the app. Attaching files *copies* these files into the `data` directory and adds a reference to those files to that `Person` model. This means that even if the original files are deleted, TAfinder would still have access to the copies of those files.

#### Implementation

The attachment mechanism is mainly facilitated by the `AttachCommand`, `AttachCommandParser`, and `Attachment` classes. It extends the abstract class `Command` with an `execute` functionality, to facilitate the execution of the command. Specifically, the attach feature is implemented through the following components and operations:

- `AttachCommand` — Core component responsible for executing the attachment of a file to an applicant.
- `AttachCommandParser` — Contains the functionalities for user input parsing. It ensures that user input is valid as an attach command by meeting specific requirements.
- `Person` — Represents the TA applicants with their respective fields, such as `Attachment`, to attach files to.
- `Attachment` — Represents a reference to a file. This can be a file that has been "attached" to a `Person`, or just a file within the file system of the computer.

Given below is an example usage scenario and how the attach mechanism behaves at each step.

Step 0. Assume that there is an existing list of applicants in the application after launch.

Step 1. The user enters the attach command `attach 1 f/Downloads/resume.pdf f/Downloads/cv.txt` to attach the files `resume.pdf` and `cv.txt` in the `Downloads` directory to the first user in the visible list.

Step 2. `AttachCommandParser` will then invoke `ParserUtil` for parsing of the index and check for index errors, and then parses the file paths to check for any invalid path characters. If index is invalid or the file path contains invalid path characters, the system will generate an error message. The error message will be displayed to the user, providing clear feedback about the issue and the specific constraints that are not met.

Step 3. If indices are valid, `AttachCommand#execute()` fetches the intended applicant from the currently visible list.

Step 4. Then, `AttachCommand#execute()` copies each attachment into the `data` directory, to the path `data/attachments/{student number}/{filename}`.

Step 5. Finally, a success message is displayed to the user indicating the number of attachments that have been copied.

The following sequence diagram shows how the `attach` operation works:

![AttachSequenceDiagram](images/AttachSequenceDiagram.png)

The following activity diagram summarizes what happens when a user executes a `attach` command:

![AttachActivityDiagram](images/AttachActivityDiagram.png)

--------------------------------------------------------------------------------------------------------------------

## Documentation, logging, testing, configuration, dev-ops

We've broken these out into separate guides, do check them out.

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## Appendix: Requirements

### Product scope

**Target user profile**:

* **University Professors**, specifically:
   * Tech-savvy
   * Within NUS SoC
   * Responsible for selecting student TAs
   * Managing a significant number of TA applicants
   * Can type fast
   * Prefers typing over all other means of input

**Value proposition**:

* **Efficient TA Selection:**
  * Simplify the process of identifying and selecting qualified TAs within NUS SoC. Find the most suitable TAs from a diverse pool of applicants efficiently.

* **Enhanced Convenience:**
  * Conveniently connect with students and potential TAs, streamlining communication and making the TA selection process smoother.

* **Effective Evaluation:**
  * Assess TA applicants based on a range of holistic rubrics, including grades, student life involvement, past TA experiences, etc.


### User Stories

#### High Priority (Must-Have)

| As a...                        | I want to...                                        | So that I can...                                      |
| ------------------------------ | -------------------------------------------------- | ---------------------------------------------------- |
| NUS SOC professor              | add a TA applicant and details to the list         | see the TA applicant in the list                      |
| NUS SOC professor              | hide a TA applicant from the list                  | narrow down the list of applicants for review         |
| NUS SOC professor              | edit the details of a TA applicant                 | keep their information up-to-date or correct errors    |
| NUS SOC professor              | click to view the full details of a TA applicant    | determine if they’re a fit for the position accordingly |
| NUS SOC professor              | search for a specific TA applicant by name or details | easily find their information without scrolling        |
| NUS SOC professor              | delete a TA applicant                               | remove entries that are no longer needed               |

#### Medium Priority (Nice-to-Have)

| As a...                        | I want to...                                              | So that I can...                                            |
| ------------------------------ | -------------------------------------------------------- | --------------------------------------------------------- |
| NUS SOC professor who wants the best for my students              | sort TA applicants by grades or other factors             | find the best TA applicant for my module                   |
| NUS SOC professor              | add comments/notes for myself on a TA applicant          | refer to them when comparing applicants                     |
| NUS SOC professor              | export the list of TA applicants to a spreadsheet        | easily share the list with colleagues or refer to it offline |
| NUS SOC professor              | compare between two TA applicants on the same screen     | make a final decision on selecting the TA for my module     |
| NUS SOC professor              | rate and provide feedback on TA applicants after interviews or assessments | collaborate with colleagues on the hiring decision.   |
| NUS SOC professor              | attach files (e.g., resumes) to TA applicant profiles       | keep all pertinent information in one place.                  |

#### Low Priority (Unlikely to Have)

| As a...                        | I want to...                                                | So that I can...                                              |
| ------------------------------ | ---------------------------------------------------------- | ----------------------------------------------------------- |
| NUS SOC professor              | set up automated notifications for when new TA applicants apply | stay informed without constantly checking the list.        |
| NUS SOC professor              | send TA applicants invitations and reminders                | schedule interviews with TA applicants directly through the system. |
| NUS SOC professor              | track the progress and performance of hired TAs throughout the semester | provide feedback and assess their contributions.      |
| NUS SOC professor              | filter applicants by availability and schedule             | match them with suitable time slots for my module            |
| NUS SOC professor              | set up automatic reminders for TA performance evaluations | stay organized and proactive in managing my teaching assistants. |
| NUS SOC professor              | track the number of applicants for each TA position       | gauge the level of interest and competition for specific roles. |
| NUS SOC professor              | archive or store past TA applicant data                   | reference them in future semesters or academic years.       |
| NUS SOC professor              | sort the list of TA applicants by their application status | streamline the selection process.                            |
| NUS SOC professor              | archive previous TA applicant profiles                     | maintain a historical record of applicants.                   |
| NUS SOC professor              | create and manage multiple TA applicant lists               | keep information organized for different modules or terms.   |
| NUS SOC professor              | batch process approvals or rejections of TA applications     | save time during the selection process.                        |
| NUS SOC professor              | access a help feature within the platform                   | understand how to use different functionalities efficiently.  |
| NUS SOC professor              | customize the appearance and layout of the TA applicant list | enhance the user experience.                                  |
| NUS SOC professor              | flag TA applicants for further review                       | remember to revisit certain profiles as the process continues. |
| NUS SOC professor              | generate reports summarizing TA applicant data              | easier overview and presentation to department heads or committees. |
| NUS SOC professor              | retrieve deleted or archived TA applicant data              | recover information if needed.                                |
| NUS SOC professor              | access a log of all actions performed on the system          | enhance security and accountability.                          |
| NUS SOC professor              | receive recommendations on TA applicants based on AI analysis | facilitate a smarter selection process.                       |
| NUS SOC professor              | import a spreadsheet of TA applicants to my module       | save time by not adding them individually                    |
| NUS SOC professor              | search for a TA applicant using an identifier             | contact the TA directly if needed                            |

### Use cases

(For all use cases below, the **System** is `TAfinder` and the **Actor** is `NUS SOC professor`, unless specified otherwise)

**UC01 - Edit an applicant**

**Preconditions:**

* User is logged into the system.
* There is at least one applicant in the list.

**MSS**

1. User requests to edit an applicant's information.
2. System requests the index of the applicant to edit.
3. User specifies the index and information.
4. System validates the input.
5. System updates the applicant's information.
6. System shows the updated list of applicants.

    Use case ends.

**Extensions**

* 4a. The given index or information is invalid.

    * 4a1. System shows an error message.

      Use case resumes at step 2.


**UC02 - Compare Two Applicants**

**Preconditions:**

* User is logged into the system.
* There are at least two applicants in the list.

**MSS**

1. User requests to compare two applicants.
2. System requests the indices of the first and second applicants to compare.
3. User specifies the indices.
4. System validates the input.
5. System retrieves the information of both applicants.

   Use case ends.

**Extensions:**

* 4a. The given indices are missing or invalid.
   * 4a1. System shows an error message

   Use case resumes at step 2.

*{More to be added}*

### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4.  Should be able to process user inputs in at most 100 milliseconds.
4.  Should have intuitive and easy-to-use commands that corresponds closely to their use cases (i.e. 'add' to add an item).
5.  Non-trivial methods and classes should be well-documented.
6.  Should provide a comprehensive help section accessible to professors for all the different features.

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **TA (Teaching Assistant)**: A graduate or undergraduate student who assists a professor in teaching activities, such as grading, leading discussions or conducting tutorials.
* **NUS professor**: A faculty member at the National University of Singapore (NUS) responsible for teaching and academic activities.

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

   1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
