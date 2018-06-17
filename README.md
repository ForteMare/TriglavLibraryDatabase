# TriglavLibraryDatabase
Project for FIS. Program with GUI that can add, remove, and control library inventory.

> Reviewer of this program should not get discouraged by abundance of methods, classes, and code in general.
While it may seem overwhelming, most classes and methods highly resemble each other, with only minor differences.

# Program Overview

The program has to have the following properties:

- GUI for displaying the program.
- non-GUI main class for working with program through presumably IDE.
- OOP approach to project.
- Must have hieararchical structure of classes.
- Adding objects to library.
- Removing objects from library.
- Reading a .txt with libary data.
- Writing a .txt with library data.
- Library objects must be sorted and displayed according to their properties.

# Running The Program

- The program has two main() classes.
- Class _MainGUI_ interacts with program with JavaFX GUI.
- Class _Main_ interacts with program without GUI. This class is mandatory for the assignment.

- Package _gui_ holds all the classes related to running and supporting _MainMethodGUI_.
- _MainMethodGUI_ runs the program and displays the main window.
- _AlertBox_ class holds methods of additional windows that _MainMethodGUI_ can call through buttons.
_AlertBox_ also holds error windows.
- _PeripheralBox_ has brief, simple methods that other GUI classes utilize.
These methods were causing too much clutter when integrated into other classes.
- _AddItemBox_ has windows for adding ojbects to library. 16 methods for 16 objects.
- _AddItemBox_ class adds items to library; _inventoryDisplay_ package shows items in library.

- Package _inventory_ holds classes which are 16 objects that can be added to the library.
- Package _inventory_ also holds LibraryDatabase class which is a collection of ArrayLists of 16 library objects.
- All classes (except Inventory) also include FX for displaying TableView of information. This was previously
done through special package and set of classes, but is now merdeg with original classes for brevity.



