Version Guide
=============

Ver 0.2.5.1 04/18/2021
----------------------

 ### What is new for `builtin`?
 * New function cls().
 * Change some math function using Java component `StrictMath`.
 * Delete deprecated printa() and println() function.
 * doubled() String splits.
 * deciFmt() function.

Ver 0.2.4.0 04/06/2021
----------------------

### What is new?


#### For `builtin`
 * Change print() to printx(). If you do not need line break, use printx(). <br>
 * Fix printx with array cannot output bug. <br>
 * New function hex(), oct(), bin(), change radio (return int). <br>
 * Preview inputOneDouble() <br>
 * sqrt() add (Use java.Math's function)

#### For `IntList`
 * Iterable IntList <br>
 * Delete confusing constructor IntList(String, String) <br>


Ver 0.2.2.0 03/07/2021
----------------------
### What is new?

#### For `builtin`
 * Change max() and min() return type to generics type

#### For `IntList`
 * popIndex() and popObj()
   * popIndex(): Pop the element at the place you want (`index`)
   * popObj():   Pop the element if IntList have that
 * append(): Append new data after old data
 * setAllTo(): Set all element to what you want
 * reset(): Reset the data to 0 length

Ver 0.2.1.0 03/03/2021
----------------------
### Important Notice

From this version, the filename of `./lib/built_in` will **pernamently
changed** to "**`builtin`**".
Python call it "builtin", and this author will do that as well.

### What is new?
* OK version of randint().
* Very first version of abs(), min() and max(), reversed().
* Shorter name for Math.pow -> pow(), Python already has that.

Ver 0.2.0.0 Alpha 03/02/2021
----------------------------

* First published version
* OK to use at the most case
* No complete fuction document