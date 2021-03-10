Jathon - For Clearer Java Grammar
=================================

Jathon Suggest You
------------------

### Let's make identifier-naming more explicit

* Var: start with lower case, connect with underscore, and no upper case.
* Function or method: lower case start, upper case to connect.
* Class: start with upper case and try to be short.
* Consonant: start with dollar sign, then do as `var`.
* System reserved consonant: do as upper cased `consonant`.

For example:

```java
    String $VERSION = "1.0.0.0";
    int $short_e    = 2.718;

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

What is Version Guide
---------------------

You can see the discription of the difference versions.