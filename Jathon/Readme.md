Jathon - Try to Make things Clearer and Easier
==============================================

What is Jathon
--------------

Jathon is a library which contains some Java classes to help Java developers
write programs with clearer and easier grammar.

Jathon has many functions that compress original Java functions in one place.
For example, you can use `print()` or `len()` to print or calculate the data length.
You only need to think about your steps,
we can help you with the part like this <!-- Some example of Jathon needed -->.

What does Jathon have
---------------------

All modules are still in developing.

- builtin: Idea got from Python. Make your code pretty.
- IntList: If you want to have a list like thing saving int in Java, try this 
  (Considering, a bit like repeat work (Java already has ArrayList\<Integer\>))
- Fecha: Can save time point or period, can be formatted easier.

Jathon Suggest You
------------------

### Let's make identifier-naming more explicit

* Var: start with lower case, connect with underscore, and no upper case.
* Function or method: lower case start, upper case to connect.
* Class: start with upper case and try to be short.
* Consonant: start with dollar sign, then do as `var`.
* System reserved consonant: do as upper cased `consonant`.

For example (in Java):

```java
    final String $VERSION  =  "1.0.0.0";
    final int    $short_e  =  2.718;

    class Cell
    {
        int test_var = 0;
        public boolean isTestClass()
        {
            return true;
        }
    }
```

Please note
-----------

The class `.lib/builtin.java`, which is **not** a class that can be initialized.
To follow the original name in Python,
and **avoid people to use it to create instance**,
this class's name is "`builtin`", but not "*BuiltIn*" or "*Builtin*".

What is other files in this folder
----------------------------------

Version Guide:
You can see the discription of the difference versions.

updater:
Save it in the folder which contains these three modules,
and fetch latest version **in repo** (**not releases**).
