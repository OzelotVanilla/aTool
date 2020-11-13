# Version: 0.1.0.0

import sys
import os
import random as r

# Init Sys


args = sys.argv
flag_insideSet = 0
version = [0, 0, 0, 1, "base"]

# Init Vars


scale = ["C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"]
string = 0
fret = 0
opens = scale[0]
move = 0

# Define Functions


def clr():
    os.system("cls")


def FretRememberTest():
    # M

    # Music Var
    global scale, string, fret, opens, move
    while True:
        string = r.randint(1, 6)
        fret = r.randint(0, 5)
        if string == 1:
            opens = 4
        if string == 2:
            opens = 11
        if string == 3:
            opens = 7
        if string == 4:
            opens = 2
        if string == 5:
            opens = 9
        if string == 6:
            opens = 4
        move += fret + opens
        if move >= 12:
            move -= 12
        if len(scale[move]) != 1:
            print("Pass, because you ask me not to test the thing with \"#\"")
            continue
        print("String " + str(string) + " at " + str(fret))
        answer = input("Input your answer: ")
        if answer == scale[move]:
            print("OK!")
            clr()
            continue
        elif answer == "exit":
            print("Not available exit function. Type \"exit()\" instead.")
            clr()
            continue
        elif answer == "exit()":
            clr()
            print()
            break
        else:
            print("The answer is: "+scale[move])
            clr()
            continue
