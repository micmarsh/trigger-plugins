trigger-plugins
===============

A collection of small plugins for [Trigger](http://www.trigger.io) developed primarily for [Fetchnotes](http://fetchnotes.com)

<h1>Usage:</h1>

<h2>Context menu</h2>

forge.internal.call('contextmenu.show',
{
    items:[_string1_,_string2_,...]
},
*successCallback*
);

Creates a native context menu and returns the string of the selected item to the success handler.

<h2>Keyboard</h2>
Developed primarily as a workaround for this bug: http://code.google.com/p/android/issues/detail?id=15245

forge.internal.call('keyboard.typestring',
{
    input:_string_
})

Types the given string by simulating virtual keyboard events