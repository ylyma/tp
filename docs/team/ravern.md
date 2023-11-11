---
title: Ravern's Project Portfolio Page
---

## Project: TAfinder

TAfinder is a desktop resource management application used by NUS SoC professors to choose TAs from a large pool of applicants. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the `attach` command.
  * What it does: allows the user to attach files to TA applicants to store additional data about them (e.g. resume, transcript).
  * Justification: This feature allows the users to avoid needing to copy and paste information from files submitted by the applicants into the comments field of each TA applicant, instead attaching them directly. This saves the users a lot of time and effort.
  * Highlights: This enhancement required an understanding of how Java interacts with users' filesystems. The implementation was challenging as there were many corner cases to deal with when interacting with the filesystem, so there had to be additional tests added to cover them.

* **New Feature**: Added the `import` command.
  * What it does: allows the user to attach files to TA applicants to store additional data about them (e.g. resume, transcript).
  * Justification: This feature allows the users to avoid needing to manually transfer the details of all the TA applicants from mySoC to TAfinder. Instead, the users can simply export the data from mySoC and import it directly into TAfinder.
  * Highlights: Parsing the CSV file format was a challenge. This enhancement required figuring out a way of reading the order of the columns in the CSV file, so as to correctly interpret the data contained within it.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=ravern&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByAuthors&breakdown=true&checkedFileTypes=docs~functional-code~test-code&since=2023-09-22&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=ravern&tabRepo=AY2324S1-CS2103T-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Project management**:
  * Managed releases `v1.2` - `v1.4` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Update the GUI to include a detailed view of an applicant (Pull request [\#90](https://github.com/AY2324S1-CS2103T-W10-1/tp/pull/90))
  * Added the ability to store and show previous module grade and an arbitrary interview score (Pull requests [\#100](https://github.com/AY2324S1-CS2103T-W10-1/tp/pull/100))

* **Documentation**:
  * User Guide:
    * Added documentation for the features `attach` and `import`
    * Added the automatic numbering of headings and table of contents generation (Pull request [\#187](https://github.com/AY2324S1-CS2103T-W10-1/tp/pull/187))
  * Developer Guide:
    * Added implementation details of the `attach` and `import` feature

* **Tools**:
  * Integrated a Github plugin (CodeCov) to the team repo
