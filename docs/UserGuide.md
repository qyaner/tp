---
layout: page
title: ToothTracker User Guide
show-toc: true
---

ToothTracker is an **All-in-One solution for effortless Dental Clinic Record Management**. From adding new patient and dentist profiles to seamlessly creating appointment schedules,
ToothTracker is engineered to simplify every aspect of your dental clinic administrative responsibilities.

We believe that time is the rarest commodity in a dental office. This means dental clinic administrative management must be efficient.
Therefore, ToothTracker is optimized for use via a Command Line Interface (CLI) while also having the advantages of a Graphical User Interface (GUI), particularly our Calendar feature.
If you type fast, ToothTracker offers your dental clinic a significantly more efficient workflow to get your job done.

Here is an overview of how ToothTracker can help you manage your dental clinic administration more effectively:
- You can add tags to every patient and dentist to highlight additional information about them.
- You need not worry about storing physical copies of patient and dentist profiles and appointment schedules.
- You can access and retrieve patient and dentist records easily using the `search` and `filter` commands.
- You can avoid creating clashing appointments to reduce operational delays.
- You can have the flexibility to add custom treatments that your clinic provides.
- You can view your clinic's appointment schedule in ToothTracker's calendar.

If you are new here, head over to [How to use ToothTracker's User Guide](#how-to-use-toothtrackers-user-guide) to start tracking your dental clinic records!

{% include page-break.html %}

{% include toc.md header=true show-in-toc=true ordered=true %}

{% include page-break.html %}

## How to use ToothTracker's User Guide
Thank you for choosing ToothTracker! We are delighted to have you as a user!
This user guide provides a comprehensive documentation on the various commands supported by ToothTracker.

If you have not installed ToothTracker, head over to the [Installation](#installation) section for assistance in
installing ToothTracker and launching it for the first time.

Once ToothTracker is installed, you can head over to the [Quick Reference Guide](#quick-reference-guide) section which
covers the basics of using ToothTracker.

If you are familiar with ToothTracker already, this user guide serves to give you an overview on how to use specific commands in ToothTracker.

If you are an experienced user, you can refer to the [Command Summary](#command-summary) for a quick overview of all commands.

If you are stuck or encountering issues, head over to the [FAQ](#faq) section.

### Icons used in this guide

Here are some common icons that is used throughout this user guide

| Icon                          | Meaning                                  |
|-------------------------------|------------------------------------------|
| :information_source:  **Note** | Information you should keep in mind.     |
| :bulb: **Tip**                | Information you might find useful.       |
| :exclamation: **Caution**     | Information you should be careful about. |

{% include page-break.html %}

## Installation

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `ToothTracker.jar` from [here](https://github.com/AY2324S1-CS2103T-W10-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your ToothTracker.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar ToothTracker.jar`
   command to run the application.<br>
   A GUI similar to the one shown below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png){: .centered-image }

1. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * `list-dentist` : Lists all dentists.

    * `add-dentist n/Bob p/12345678 e/bobjune@gmail.com s/Orthodontics y/6 s/braces` : Adds a dentist named `Bob`
      to the ToothTracker. See [add-dentist](#adding-a-dentist--add-dentist) for more details.

    * `delete-dentist 3` : Deletes the dentist with `DENTIST_ID` 3.

    * `search-patient 6` : Searches for the patient with `PATIENT_ID` 6.

    * `clear` : Deletes all records from ToothTracker.

    * `exit` : Exits ToothTracker.

1. Refer to the [Features](#features) section for details of each command.

{% include page-break.html %}

## Quick Reference Guide

### Layout
When you launch ToothTracker, ToothTracker appears on your screen as a GUI.
Let’s take a look at the layout of the different components of ToothTracker.

ToothTracker’s GUI consists of a Main Window, a Calendar Window as well as the Help Window. The main window consists of six components:

1. Command Input Box
1. Result Display Box
1. Patient List Panel
1. Dentist List Panel
1. Appointment List Panel
1. Quick Notes Box

The following picture of the main window shows the six components numbered accordingly:

![ToothTracker UI](images/UiAnnotated.png){: .centered-image }

Besides the main window, ToothTracker also has the Calendar Window. It is not part of the main GUI and is only shown after a [Calendar Command](#viewing-calendar--view-calendar) is run.

![Calendar Window](images/ug/CalendarWindow.png){: .centered-image }

ToothTracker also has the Help Window. This is only shown after a [Help Command](#viewing-help--help) is run.

The Help Window looks like the following:

![Help Window](images/ug/HelpWindow.png){: .centered-image }

{% include page-break.html %}

## Features
This section shares with you on how to use each feature in detail.

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the input parameters you need to provide.<br>
  e.g. in `add-dentist n/NAME`, `NAME` is an input parameter which can be used as `add-dentist n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/Professional` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Input parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE s/SPECIALIZATION `, `p/PHONE s/SPECIALIZATION n/NAME` is also acceptable.

* Extraneous input parameters for commands that do not take in input parameters (such as `help`, `list-patient`,
  `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
  as space characters surrounding line-breaks may be omitted when copied over to the application.

</div>

{% include page-break.html %}

### Dentist Features

#### Adding a dentist : `add-dentist`

Adds a dentist to the list of dentists in ToothTracker. This is useful when:
* You are using ToothTracker for the first time, and you have to add your dentists' particulars.
* You are adding a new dentist who has joined your dental clinic.

**Format:** `add-dentist n/NAME p/PHONE s/SPECIALIZATION y/YOE [e/EMAIL] [h/ADDRESS] [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A dentist can have any number of <code>TAG</code>s (including zero tags).

<code>EMAIL</code> and <code>ADDRESS</code> are optional to be put.
You may use the `edit-dentist` command to update them in the future.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about Specializations:**<br>
By default, ToothTracker only accepts a set of predefined recognized dental specializations. They are:<br>
  1. Endodontics<br>
  2. Dental Public Health<br>
  3. Oral and Maxillofacial Surgery<br>
  4. Orthodontics<br>
  5. Paediatric Dentistry<br>
  6. Periodontics<br>
  7. Prosthodontics<br>

This is in accordance to the
[List of Recognised Specializations](https://www.healthprofessionals.gov.sg/dsab/specialist-training/list-of-recognised-specialties)
from The Ministry of Health. Please consult the developers if you need to change the dental specializations!
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding a dentist without email and address:**<br>
ToothTracker will put the <code>EMAIL</code> as "NoEmailProvided@ToBeAdded.com"
and put the <code>ADDRESS</code> as "No Address Provided." by default.

If you wish to update them at a later time, you can use <code>edit-dentist</code> to edit them.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding dentists with the same name:**<br>
Each dentist must have a unique name. ToothTracker does not allow multiple dentists with identical names.
</div>

**Examples:**
* `add-dentist n/Xavier Roald p/99773311 s/Orthodontics y/1 e/roaldxavier@hotmail.com
h/Yishun Street 72, Blk 742, #03-354, Singapore 512742 t/Trainee`<br>
This adds a dentist named 'Xavier Roald' with phone number '99773311', specialising in 'Orthodontics' with '1 year of experience',
email 'roaldxavier@hotmail.com', address 'Yishun Street 72, Blk 742, #03-354, Singapore 512742', who is a 'Trainee' into
the list of dentists in ToothTracker.

![add-dentist-example-1](images/ug/dentist/AddDentistExample1.png){: .centered-image }

* `add-dentist n/Barbara Noel p/93349795 e/barbaranoel@gmail.com y/6 s/Paediatric Dentistry`<br>
This adds a dentist named 'Barbara Noel' with phone number '93349795' and email 'barbaranoel@gmail.com',
who has '6 years of experience' and specializing in 'Paediatric Dentistry' into the list of dentists in ToothTracker.

![add-dentist-example-2](images/ug/dentist/AddDentistExample2.png){: .centered-image }

* `add-dentist n/Emmanuel Chua p/99887766 y/8 s/prosthodontics t/extraction` <br>
This adds a dentist named 'Emmanuel Chua' with phone number '99887766' who has '8 years of experience'
specializing in 'prosthodontics' with a tag of 'extraction' into the list of dentists in ToothTracker.

![add-dentist-example-3](images/ug/dentist/AddDentistExample3.png){: .centered-image }


#### Listing all dentists : `list-dentist`

Shows a list of all dentists in ToothTracker. This is useful when:
* You want to retrieve the information of all dentists.
* You want to verify a dentist is added successfully in ToothTracker.
* You want to verify a dentist is updated successfully in ToothTracker.

**Format:** `list-dentist` (No extra parameters required)

![list-dentist](images/ug/dentist/ListDentistExample.png){: .centered-image }

#### Deleting a dentist : `delete-dentist`

Deletes the dentist with the specified `DENTIST_ID` from ToothTracker.

**Format:** `delete-dentist DENTIST_ID`

<div markdown="span" class="alert alert-warning">:exclamation: **CAUTION:**
This command is DESTRUCTIVE! Dentists deleted will need to be added back and their previous records may be removed.
**Proceed with caution!**
</div>

<div markdown="span" class="alert alert-primary">:bulb: Tip:
To check the <code>DENTIST_ID</code> of a dentist, you can simply enter the command `list-dentist`.
</div>

**Examples:**
* `delete-dentist 2` <br> This deletes the dentist with the `DENTIST_ID` 2.
![delete-dentist-example-1](images/ug/dentist/DeleteDentistExample1.png){: .centered-image }

* `delete-dentist 20` <br> This deletes the dentist with the `DENTIST_ID` 20.


#### Searching for dentists by `DENTIST_ID` : `search-dentist`

Searches for a dentist by their `DENTIST_ID` in ToothTracker.
This command helps you find a unique dentist based on the provided `DENTIST_ID`. This is useful when:
* You want to confirm the identity of a specific dentist before using further commands.
* You need quick access to one specific dentist's particulars.

**Format:** `search-dentist DENTIST_ID`

<div markdown="block" class="alert alert-primary">
:bulb: **Tip:**
The `DENTIST_ID` refers to the ID shown in the displayed list of dentists. <br>
To check the `DENTIST_ID` of a dentist, you can simply enter the command `list-dentist`.
</div>

**Examples:**
* `search-dentist 5` <br> This searches for the dentist with `DENTIST_ID` 5.
![search-dentist-id-example-1](images/ug/dentist/SearchDentistIdExample1.png){: .centered-image }

* `search-dentist 10` <br> This searches for the dentist with `DENTIST_ID` 10.


#### Searching for dentists by keywords : `search-dentist`

Search for dentists by matching names with a keyword.
This command helps you find dentists that match your search criteria. This is useful when:
* You need to find dentists whose names match your search criteria.
* You forget the `DENTIST_ID` for a dentist and want to search using the dentist's name instead.

**Format:** `search-dentist KEYWORD`

<div markdown="block" class="alert alert-info">
**:information_source: Notes for searching dentists by keyword**<br>
  <ul>
    <li>The search is performed only on the dentist's name.</li>
    <li>The search is case-insensitive, meaning that it will match both uppercase and lowercase characters. For example, searching for `James` will match both `James` and `james`.</li>
    <li>The order of the keywords in the name does not matter. For instance, searching for `Mike Lim` will match `Lim Mike` as well.</li>
    <li>Sub-strings will be matched. For example, if you search for `Fred`, it will match `Frederick`.</li>
    <li>More than one dentist result might be returned when searching by keywords, especially if multiple dentists match your search criteria.</li>
  </ul>
</div>

**Examples:**
* `search-dentist John` <br> This searches for dentists with names containing the keyword `John`.
![search-dentist-keyword-example-1](images/ug/dentist/SearchDentistKeywordExample1.png){: .centered-image }

* `search-dentist Ronald Lim` <br> This searches for dentists with names containing the keyword `Ronald Lim`.


#### Filtering dentists : `filter-dentist`

Narrows down your search for dentists based on a specified attributes.
When this command is used, there might be more than one result that matches your search criteria. This is useful when:
* You want to find dentists with specific attributes.
* You want to confirm the identity of a dentist before using further commands.

**Format:** `filter-dentist a/ATTRIBUTE k/KEYWORDS`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the attributes that you can filter by, you can simply enter the command `list-dentist`.
Alternatively, a message will be shown in the text box regarding the attributes that you can filter by if you entered an invalid attribute.
We have set the attributes that can be filtered to be:
`name`, `phone`, `specialization`, `experience`, `email`, `address`, `tags`.
</div>

**Examples:**
* `filter-dentist a/phone k/98225677` <br> This filters for dentists with the phone number 98225677.
![filter-dentist-example-1](images/ug/dentist/FilterDentistExample1.png){: .centered-image }

* `filter-dentist a/specialization k/Orthodontics` <br> This filters for dentists with the specialization Orthodontics.
![filter-dentist-example-2](images/ug/dentist/FilterDentistExample2.png){: .centered-image }


#### Editing a dentist : `edit-dentist`

Edits one or more attributes of the dentist at the specified `DENTIST_ID`. This is useful when:
* The particulars of a dentist need to be updated.
* Optional dentist particulars were not provided previously.
* You accidentally entered incorrect information about a dentist into the ToothTrack database.

**Format:** `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can edit the particulars in any order and edit more than one particulars of the dentist with a single `edit-dentist` command.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `DENTIST_ID` of a dentist, you can simply enter the command `list-dentist`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about editing tags:**<br>
When editing tags, you have to include any previous tags that was already included in the dentist, or else these tags will be removed.
This also means that you can use `t/` to remove all tags from a dentist using the <code>edit-dentist</code> command.
</div>

**Examples:**

* `edit-dentist 1 p/98987676 e/bobjuly@gmail.com` <br> This edits the phone number and email of the dentist with
`DENTIST_ID` 1 into 98987676 and bobjuly@gmail.com respectively.
![edit-dentist-example-1](images/ug/dentist/EditDentistExample1.png){: .centered-image }

* `edit-dentist 5 n/Emmanuel Alexandra t/` <br>
This edits the name of the dentist with `DENTIST_ID` 5 into ‘Emmanuel Alexandra’ and removes all tags of the dentist.
![edit-dentist-example-2](images/ug/dentist/EditDentistExample2.png){: .centered-image }


{% include page-break.html %}

### Patient Features

#### Adding a patient : `add-patient`

Adds a patient to the list of patients in ToothTracker. This is useful when:
* You are using ToothTracker for the first time, and you have to add your patients' particulars.
* A new patient has joined your clinic.

**Format:** `add-patient n/NAME p/PHONE b/BIRTHDATE g/GENDER [r/REMARK] [tr/TREATMENT] [e/EMAIL] [h/ADDRESS] [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A patient can have any number of <code>TAG</code>s (including zero tags).

<code>EMAIL</code>, <code>ADDRESS</code>, <code>REMARK</code> and <code>TREATMENT</code> are optional to be put.
You may use the `edit-patient` command to update them in the future.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding a patient without remark and treatment:**<br>
ToothTracker will put the <code>REMARK</code> and <code>TREATMENT</code> as `NIL` by default.

If you wish to update them at a later time, you can use <code>edit-patient</code> to edit them.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding a patient without email and address:**<br>
ToothTracker will put the <code>EMAIL</code> as "NoEmailProvided@ToBeAdded.com"
and put the <code>ADDRESS</code> as "No Address Provided." by default.

If you wish to update them at a later time, you can use <code>edit-patient</code> to edit them.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding Treatments:**<br>
The new treatment must be a valid treatment in ToothTracker. To add a new treatment for your clinic, use the command `add-treatment`.
To view the list of treatments, you can use the command `list-treatment`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding patients with the same name:**<br>
Each patient must have a unique name and ToothTracker does not allow multiple patients with identical names.
</div>

**Examples:**

* `add-patient n/John p/90676622 b/26-06-1998 g/M r/Allergic to Peanuts tr/Braces e/johntan@gmail.com h/60 Harvey Avenue t/Urgent` <br>
This adds a new patient named ‘John’, with phone number ‘90676622’, birthdate of '26 June 1998', gender 'M' (Male), remark that he is 'allergic to peanuts',
requesting for 'Braces' treatment, email of ‘johntan@gmail.com’, with an address at '60 Harvey Avenue', and a tag 'Urgent'.
![add-patient-example-1](images/ug/patient/AddPatientExample1.png){: .centered-image }


* `add-patient n/Jean p/95339212 b/14-09-2001 g/F` <br>
This adds a new patient named 'Jean', with phone number '95339212', birthdate of 14 September 2001, gender F (Female).
![add-patient-example-2](images/ug/patient/AddPatientExample2.png){: .centered-image }


#### Listing all patients : `list-patient`

Shows a list of all patients in ToothTracker. This is useful when:
* You want to retrieve the information of all patients.
* You want to verify a patient is added successfully in ToothTracker.
* You want to verify a patient is updated successfully in ToothTracker.

Format: `list-patient` (No extra parameters required)
![list-patient-example](images/ug/patient/ListPatientExample.png){: .centered-image }

#### Deleting a patient : `delete-patient`

Deletes the patient with the specified `PATIENT_ID` from ToothTracker.

**Format:** `delete-patient PATIENT_ID`

<div markdown="span" class="alert alert-warning">:exclamation: **CAUTION:**
This command is DESTRUCTIVE! Patients deleted will need to be added back and their previous records may be removed.
**Proceed with caution!**
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `PATIENT_ID` of a patient, you can simply enter the command `list-patient`.
</div>

Examples:
* `delete-patient 5` <br> This deletes the patient with the `PATIENT_ID` 5.
![delete-patient-example-1](images/ug/patient/DeletePatientExample1.png){: .centered-image }

* `delete-patient 34` <br> This deletes the patient with the `PATIENT_ID` 34.
![delete-patient-example-2](images/ug/patient/DeletePatientExample2.png){: .centered-image }


#### Searching for patients by `PATIENT_ID` : `search-patient`

Searches for a patient by their `PATIENT_ID` in ToothTracker.
This command helps you find a unique patient based on the provided `PATIENT_ID`. This is useful when:
* You want to confirm the identity of a specific patient before using further commands.
* You need quick access to one specific patient's particulars.

**Format:** `search-patient PATIENT_ID`

<div markdown="block" class="alert alert-primary">
:bulb: **Tip:**
The `PATIENT_ID` refers to the ID shown in the displayed list of patients. <br>
To check the `PATIENT_ID` of a patient, you can simply enter the command `list-patient`.
</div>

**Examples:**
* `search-patient 2` <br> This searches for the patient with `PATIENT_ID` 2.
![search-patient-id-example-1](images/ug/patient/SearchPatientIdExample1.png){: .centered-image }

* `search-patient 8` <br> This searches for the patient with `PATIENT_ID` 8.


#### Searching for patients by keywords : `search-patient`

Search for patients by matching names with a keyword.
This command helps you find patients that match your search criteria. This is useful when:
* You need to find patients whose names match your search criteria
* You forget the `Patient_ID` for a patient and want to search using the patient's name instead.

**Format:** `search-patient KEYWORD`

<div markdown="block" class="alert alert-info">
**:information_source: Notes for searching patients by keyword**<br>
  <ul>
    <li>The search is performed only on the patient's name.</li>
    <li>The search is case-insensitive, meaning that it will match both uppercase and lowercase characters. For example, searching for `James` will match both `James` and `james`.</li>
    <li>The order of the keywords in the name does not matter. For instance, searching for `Mike Lim` will match `Lim Mike` as well.</li>
    <li>Sub-strings will be matched. For example, if you search for `Fred`, it will match `Frederick`.</li>
    <li>More than one patient result might be returned when searching by keywords, especially if multiple patients match your search criteria.</li>
  </ul>
</div>

**Examples:**
* `search-patient John` <br> This searches for patients with names containing the keyword `John`.
![search-patient-keyword-example-1](images/ug/patient/SearchPatientKeywordExample1.png){: .centered-image }

* `search-patient Ronald Lim` <br> This searches for patients with names containing the keyword `Ronald Lim`.


#### Filtering patients : `filter-patient`

Narrows down your search for patients based on a specified attribute.
When this command is used, there might be more than one result that matches your search criteria. This is useful when:
* You want to find patients with specific attributes.
* You want to confirm the identity of a patient before using further commands.

**Format:** `filter-patient a/ATTRIBUTE k/KEYWORDS`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the attributes that you can filter by, you can simply enter the command `list-patient`.
Alternatively, a message will be shown in the text box regarding the attributes that you can filter by if you entered an invalid attribute.
We have set the attributes that can be filtered to be:
`name`, `phone`, `birthday`, `gender`, `remark`, `treatment`, `email`, `address`, `tags`.
</div>

**Examples:**
* `filter-patient a/phone k/81076655` <br> This filters for patients with the phone number '81076655'.
![filter-patient-example-1](images/ug/patient/FilterPatientExample1.png){: .centered-image }

* `filter-patient a/treatment k/Braces` <br> This filters for patients with the treatment 'Braces'.
![filter-patient-example-2](images/ug/patient/FilterPatientExample2.png){: .centered-image }


#### Editing a patient : `edit-patient`

Edits one or more attributes of the patient at the specified `PATIENT_ID`. This is useful when:
* The particulars of a patient need to be updated.
* Optional patient particulars were not provided previously.
* You accidentally entered incorrect information about a patient into the ToothTrack database.

**Format:** `edit-patient PATIENT_ID [n/NAME] [p/PHONE] [b/BIRTHDATE] [g/GENDER] [r/REMARK] [tr/TREATMENT] [e/EMAIL] [h/ADDRESS] [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can edit the particulars in any order and edit more than one particular of the patient with a single `edit-patient` command.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `PATIENT_ID` of a patient, you can simply enter the command `list-patient`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about editing tags:**<br>
When editing tags, you have to include any previous tags that was already included in the patient, or else these tags will be removed.
This also means that you can use `t/` to remove all tags from a patient using the `edit-patient` command.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about editing Treatments:**<br>
The edited treatment must be a valid treatment in ToothTracker. For a list of valid treatments, you can use the command `list-treatment`.
</div>

**Examples:**
* `edit-patient 1 p/91234567 e/johndoe@example.com r/Allergic to Peanuts`<br>
This edits the phone number, email, and remarks of the patient with `PATIENT_ID` 1 into
'91234567', 'johndoe@example.com', and 'Allergic to Peanuts' respectively.
![edit-patient-example-1](images/ug/patient/EditPatientExample1.png){: .centered-image }

* `edit-patient 2 n/Alex` <br>
This edits the name of the patient with `PATIENT_ID` 2 to 'Alex'.
![edit-patient-example-2](images/ug/patient/EditPatientExample2.png){: .centered-image }

{% include page-break.html %}

### Appointment Features

#### Adding an appointment : `add-appointment`

Adds a dental appointment to ToothTracker. This is useful when you:
* need to schedule future dental appointments for patients with specific dentists at designated times.
* want to check for clashes with existing appointments.
* want to add in past appointments for record keeping.

**Format:** `add-appointment dentist/DENTIST_ID patient/PATIENT_ID start/START_DATE_TIME tr/TREATMENT`


<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding Appointments**<br>
  <ul>
    <li>ToothTracker will not allow the addition of appointments that clashes with existing appointments
                with the same dentist or patient.</li>
    <li>ToothTracker only allows for the addition of appointments from the year 2000 and onwards.</li>
    <li>When adding an appointment, the list of appointments shown may get filtered, resulting in the new appointment not showing up in the appointment list.
                Please use `list-appointment` if you want the new appointment to show up.</li>
  </ul>
</div>

**Example:**
* `add-appointment dentist/1 patient/1 start/2023-10-12 16:00 tr/Braces` <br>
This command adds an appointment with the `PATIENT_ID` 1 and the `DENTIST_ID` 1.
The appointment starts on '12 October 2023, 4pm'. The treatment provided during the appointment is 'Braces'.
The duration of the appointment is automatically set based on the selected treatment in ToothTracker.
![add-appointment-example](images/ug/appointment/AddAppointmentExample.png){: .centered-image }

#### Listing all appointments : `list-appointment`

Shows a list of all appointments in ToothTracker. This is useful when you:
* want to retrieve the information of all appointments.
* want to verify that the appointment is added to ToothTracker.

**Format:** `list-appointment` (No extra parameters required)
![list-appointment-example](images/ug/appointment/ListAppointmentExample.png){: .centered-image }


#### Deleting an appointment : `delete-appointment`

Deletes the appointment with the specified `APPOINTMENT_ID` from ToothTracker.

**Format:** `delete-appointment APPOINTMENT_ID`

<div markdown="span" class="alert alert-warning">:exclamation: **CAUTION:**
This command is DESTRUCTIVE!
Appointments deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the `APPOINTMENT_ID` of an appointment, you can simply enter the command `list-appointment`.
</div>

**Example:**
* `delete-appointment 2` <br>
This deletes the appointment with `APPOINTMENT_ID` 2 from ToothTracker.
![delete-appointment-example](images/ug/appointment/DeleteAppointmentExample.png){: .centered-image }


#### Filtering Appointments by `DENTIST_ID` : `filter-appointment dentist`

Narrows down your search for appointments by filtering the appointment list to
show the list of appointments under the dentist with the specified `DENTIST_ID`.
This is useful when you:
* want to view the list of appointments under a specific dentist.

**Format:** `filter-appointment dentist DENTIST_ID`

<div markdown="block" class="alert alert-primary">:bulb: **Tip:**
`DENTIST_ID` refers to the ID shown in the displayed list of dentists. <br>
You may use `list-dentist` to check out the `DENTIST_ID` first.
</div>

**Example:**
* `filter-appointment dentist 1` <br>
This gives you all appointments under the dentist with `DENTIST_ID` 1.
![filter-appointment-dentist-example](images/ug/appointment/FilterAppointmentDentistExample.png){: .centered-image }


#### Filtering Appointments by `PATIENT_ID` : `filter-appointment patient`

Narrows down your search for appointments by filtering the appointment list to
show the list of appointments under the patient with the specified `PATIENT_ID`.
This is useful when you:
* want to view the list of appointments under a specific patient.

**Format:** `filter-appointment patient PATIENT_ID`

<div markdown="block" class="alert alert-primary">:bulb: **Tip:**
`PATIENT_ID` refers to the index number shown in the displayed list of patients. <br>
You may use `list-patient` to check out the `PATIENT_ID` first.
</div>

**Example:**
* `filter-appointment patient 1` <br>
This gives you all appointments under the patient with the `PATIENT_ID` 1.
![filter-appointment-patient-example](images/ug/appointment/FilterAppointmentPatientExample.png){: .centered-image }


{% include page-break.html %}

### Treatment Features

#### Adding a treatment : `add-treatment`

Adds a dental treatment to the ToothTracker system.
This command allows you to specify the treatment name, the cost of treatment, and how long the treatment would take.

**Format:** `add-treatment tr/NAME cs/PRICE ti/DURATION`

<div markdown="block" class="alert alert-info">
**:information_source: Notes about adding treatments with the same name:**<br>
Each treatment must have a unique name. ToothTracker does not allow multiple treatments with identical names.
</div>

**Example:**
* `add-treatment tr/Tooth Extraction cs/1080 ti/10:30` <br>
This adds a 'Tooth Extraction' treatment to ToothTracker with a cost of '$1080 SGD', and duration of '10 hours and 30 minutes'.
![add-treatment-example](images/ug/treatment/AddTreatmentExample.png){: .centered-image }


#### Listing all treatments : `list-treatment`

Shows a list of all treatments in ToothTracker. This is useful when:
* You want to view the currently available treatments stored in ToothTracker.

Format: `list-treatment` (No extra parameters required)
![list-treatment-example](images/ug/treatment/ListTreatmentExample.png){: .centered-image }


#### Deleting a treatment : `delete-treatment`

Deletes the treatment with the specified `TREATMENT_NAME` from ToothTracker.

**Format:** `delete-treatment TREATMENT_NAME`

<div markdown="span" class="alert alert-warning">:exclamation: **CAUTION:**
This command is DESTRUCTIVE!
Treaments deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
`TREATMENT_NAME` must be an **exact** match (case-sensitive) with the name of the treatment to be deleted.
</div>

**Example:**
* `delete-treatment Braces` <br> This deletes the treatment `Braces` from ToothTracker.
![delete-treatment-example](images/ug/treatment/DeleteTreatmentExample.png){: .centered-image }



{% include page-break.html %}

### Calendar Features

#### Viewing calendar : `view-calendar`

Shows a calendar filled with all scheduled appointments in ToothTracker. This is useful when:
* You want a visual summary of all appointments, allowing for a comprehensive overview.

Format: `view-calendar` (No extra parameters required)
![view-calendar-example](images/ug/ViewCalendarExample.png){: .centered-image }


### General Features

#### Viewing help : `help`

Shows a message explaining how to access the help page.

**Format**: `help`

![help message](images/ug/HelpWindow.png){: .centered-image }



#### Clearing all data : `clear`

Clears all data from ToothTracker. **PROCEED WITH CAUTION!**

<div markdown="span" class="alert alert-warning">:exclamation: **CAUTION:**
Data cleared cannot be recovered.
</div>

**Format:** `clear`


#### Exiting the program : `exit`

Exits ToothTracker app.

**Format:** `exit`


#### Saving the data
ToothTracker data is saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.


#### Editing the data file
ToothTracker data is saved automatically as a JSON file `[JAR file location]/data/toothtracker.json`. Advanced users are
welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **CAUTION:**
If your changes to the data file makes its format invalid, ToothTracker will discard all data and start with an empty
data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>


{% include page-break.html %}

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous ToothTracker home folder.

**Q**: Why do I get an error while trying to edit an existing dentist/patient?<br>
**A**: The dentist/patient to be edited may not be shown in ToothTracker.
To display the to-be-edited dentist/patient, you may use these commands:
1. `list-dentist` or `list-patient`
2. `search-dentist` or `search-patient`

Thereafter, you may edit the particulars using `edit-dentist` or `edit-patient` with their `DENTIST_ID` or `PATIENT_ID`
respectively.


{% include page-break.html %}

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only
   the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the
   application before running the application again.


{% include page-break.html %}

## Command summary

### Dentist Commands

| Action                           | Format                                                                                                     | Example                                                                                                                               |
|----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Dentist**                  | `add-dentist n/NAME p/PHONE s/SPECIALIZATION y/YOE [e/EMAIL] [h/ADDRESS] [t/TAG]…​`                     | `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`                                                                       |
| **List Dentist**                 | `list-dentist`                                                                                             | `list-dentist`                                                                                                                        |
| **Delete Dentist**               | `delete-dentist DENTIST_ID`                                                                                | `delete-dentist 3`                                                                                                                    |
| **Search Dentist by Dentist ID** | `search-dentist DENTIST_ID`                                                                                | `search-dentist 2`                                                                                                                    |
| **Search Dentist by Keyword**    | `search-dentist KEYWORD`                                                                                   | `search-dentist Tom`                                                                                                                  |
| **Filter Dentist**               | `filter-dentist a/ATTRIBUTE k/KEYWORDS`                                                                    | `filter-dentist a/phone k/90182211`                                                                                                   |
| **Edit Dentist**                 | `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​` | `edit-dentist 1 p/98987676 e/bobjuly@gmail.com`                                                                                       |


### Patient Commands

| Action                           | Format                                                                                                                | Example                                                                                                                               |
|----------------------------------|-----------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| **Add Patient**                  | `add-patient n/NAME p/PHONE b/BIRTHDATE g/GENDER [r/REMARK] [tr/TREATMENT] [e/EMAIL] [h/ADDRESS] [t/TAG]…​`           | `add-patient n/John p/90676622 b/06-06-1998 g/M r/Allergic to Peanuts tr/Braces e/johntan@gmail.com h/60 Harvey Avenue t/Urgent`   |
| **List Patient**                 | `list-patient`                                                                                                        | `list-patient`                                                                                                                        |
| **Delete Patient**               | `delete-patient PATIENT_ID`                                                                                           | `delete-patient 3`                                                                                                                    |
| **Search Patient by Patient ID** | `search-patient PATIENT_ID`                                                                                           | `search-patient 3`                                                                                                                    |
| **Search Patient by Keyword**    | `search-patient KEYWORD`                                                                                              | `search-patient John`                                                                                                                 |
| **Filter Patient**               | `filter-patient a/ATTRIBUTE k/KEYWORDS`                                                                               | `filter-patient a/phone k/98776211`                                                                                                   |
| **Editing Patient**              | `edit-patient PATIENT_ID [n/NAME] [p/PHONE] [b/BIRTHDATE] [g/GENDER] [r/REMARK] [tr/TREATMENT] [e/EMAIL] [h/ADDRESS] [t/TAG]…​` | `edit-patient 1 p/91234567 e/johndoe@example.com r/Allergic to Peanuts`                                                  |


### Appointment Commands

| Action                           | Format                                                                                                     | Example                                                                                                                       |
|----------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| **Add Appointment**              | `add-appointment dentist/DENTIST_ID patient/PATIENT_ID start/START_TIME tr/TREATMENT`  | `add-appointment dentist/1 patient/1 start/2023-10-12 16:00 tr/Braces`                                                        |
| **List Appointment**             | `list-appointment`                                                                     | `list-appointment`                                                                                                            |
| **Delete Appointment**           | `delete-appointment APPOINTMENT_ID`                                                    | `delete-appointment 3`                                                                                                        |
| **Filter Appointment by Dentist ID** | `filter-appointment dentist DENTIST_ID`                                            | `filter-appointment dentist 1`                                                                                                |
| **Filter Appointment by Patient ID** | `filter-appointment patient PATIENT_ID`                                            | `filter-appointment patient 1`                                                                                                |


### Treatment Commands

| Action                           | Format                                       | Example                                             |
|----------------------------------|----------------------------------------------|-----------------------------------------------------|
| **Add Treatment**                | `add-treatment tr/NAME cs/PRICE ti/DURATION` | `add-treatment tr/Tooth Extraction cs/150 ti/01:00` |
| **List Treatment**               | `list-treatment`                             | `list-treatment`                                    |
| **Delete Treatment**             | `delete-treatment NAME`                      | `delete-treatment Braces`                           |


### Calendar Commands

| Action            | Format          | Example         |
|-------------------|-----------------|-----------------|
| **View calendar** | `view-calendar` | `view-calendar` |


### General Commands

| Action                | Format           | Example |
|-----------------------|------------------|---------|
| **Help**              | `help`           | `help`  |
| **Clear all data**    | `clear`          | `clear` |
| **Exit ToothTracker** | `exit`           | `exit`  |


