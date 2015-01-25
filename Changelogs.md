Changelog
-----

[ **Commit:** ... | **Date:** ... ]

**Changes planned for upcoming build**
+ **Bug Fix** scrollbar when dashboard sidebar expands all nodes
+ **Moved** procedures for new form addition to a new independent method

**Possible but not planned**
+ **Redesign** complete design overhaul using third-party swing library

[ **Commit:** 538771c582 | **Date:** Sun, Jan 25 2015 ]

**Changes**
+ **Removed** following deprecated classes and forms
	+ `src\classes\gui\mainmenu\DashMenuItem.java`
	+ `src\classes\gui\mainmenu\MenuTreeCellRenderer.java`
	+ `src\gui\frames\mainmenu\Dashboard.form`
	+ `src\gui\frames\mainmenu\Dashboard.java`

**Bug Reports:**

+ No scrollbar for dashboard menu bar, can not see last few elements of the menu when all menu nodes expanded

[ **Commit:** a6154e6960 | **Date:** Sun, Jan 25 2015 ]

**Changes**
+ Refactored packages' name
+ Refactored classnames
+ Reformatted code organization
+ **Added** Fullscreen support
+ **Added** Frame call and display in dashboard window
+ **Added** `Test` node in Dashboard menubar
+ **Added** two icons(assets) for `Test` node
	+ `assets/dash_menu_test_root.png`
	+ `assets/dash_menu_test_window.png`
+ **Removed** redundant methods from `JTreeNode` class
+ **Removed** `currentSelection()` method from `JTreeCellRenderer` class
+ **Removed** redundant comments from all classes
