buttonText: ‘…’, // Display text for trigger button
buttonStatus: ‘Open the keypad’, // Status text for trigger button
closeText: ‘Close’, // Display text for close link
closeStatus: ‘Close the panel’, // Status text for close link
clearText: ‘Clear’, // Display text for clear link
clearStatus: ‘Erase the current entry’, // Status text for clear link
backText: ‘Back’, // Display text for back link
backStatus: ‘Erase the previous character’, // Status text for back link
enterText: ‘Enter’, // Display text for carriage return
enterStatus: ‘Carriage return’, // Status text for carriage return
tabText: ‘Tab’, // Display text for tab
tabStatus: ‘Horizontal tab’, // Status text for tab
shiftText: ‘Shift’, // Display text for shift link
shiftStatus: ‘Toggle upper/lower case characters’, // Status text for shift link
alphabeticLayout: this.qwertyAlphabetic, // Default layout for alphabetic characters
fullLayout: this.qwertyLayout, // Default layout for full keyboard
isAlphabetic: this.isAlphabetic, // Function to determine if character is alphabetic
isNumeric: this.isNumeric, // Function to determine if character is numeric
isRTL: false, // True if right-to-left language, false if left-to-right

showOn: ‘focus’, // ‘focus’ for popup on focus,
// ‘button’ for trigger button, or ‘both’ for either
buttonImage: ”, // URL for trigger button image
buttonImageOnly: false, // True if the image appears alone, false if it appears on a button
showAnim: ‘show’, // Name of jQuery animation for popup
showOptions: {}, // Options for enhanced animations
duration: ‘normal’, // Duration of display/closure
appendText: ”, // Display text following the input box, e.g. showing the format
useThemeRoller: false, // True to add ThemeRoller classes
keypadClass: ”, // Additional CSS class for the keypad for an instance
prompt: ”, // Display text at the top of the keypad
layout: ['123' + this.CLOSE, '456' + this.CLEAR,
'789' + this.BACK, this.SPACE + '0'], // Layout of keys
separator: ”, // Separator character between keys
target: null, // Input target for an inline keypad
keypadOnly: true, // True for entry only via the keypad, false for keyboard too
randomiseAlphabetic: false, // True to randomise the alphabetic key positions, false to keep in order
randomiseNumeric: false, // True to randomise the numeric key positions, false to keep in order
randomiseOther: false, // True to randomise the other key positions, false to keep in order
randomiseAll: false, // True to randomise all key positions, false to keep in order
beforeShow: null, // Callback before showing the keypad
onKeypress: null, // Define a callback function when a key is selected
onClose: null // Define a callback function when the panel is closed