# Version: 0.1.1.0 alpha

import random as r
import sys
import os
import urllib.request as ul
import winsound as ws

# Init Sys
version = [0, 1, 1, 0, "alpha"]
args = sys.argv
flag_insideSet = 0

# Init functions


def update():
    if checkUpdate(version) == 1:
        doUpdate()


def transVerListToInt(given_ver_list):
    for x in range(4):
        given_ver_list[x] = int(given_ver_list[x].rstrip())
    return given_ver_list


def checkUpdate(ver):
    # Check
    print("Checking update, please wait.")
    url = "https://raw.githubusercontent.com/OzelotVanilla/GuitarTool/main/upd"
    upd = ul.urlopen(url).readlines()[1].decode("utf-8")
    upd = transVerListToInt(upd.rstrip().split("."))
    # Check exist
    if ver == [0, 0, 0, 0]:
        print("Bad file version. Downloading newest version.")
        return 1
    # Check whether the current version is out of date
    flag_needUpd = 0
    for x in range(len(upd)):
        if upd[x] != "rls" and upd[x] != "alpha" and upd[x] != "beta" and upd[x] != "base":
            if upd[x] > ver[x]:
                flag_needUpd = 1
    print(upd)
    if flag_needUpd == 1:
        flag_doUpd = input("Need update. Input \"y\" to update.")
        if flag_doUpd == "y":
            return 1

# Need to be modified


def doUpdate():
    # Go to update
    print("Will download file.")
    url = "https://raw.githubusercontent.com/OzelotVanilla/GuitarTool/main/upd"
    ver = ul.urlopen(url).readlines()[1].decode("utf-8").rstrip()
    url = "https://raw.githubusercontent.com/OzelotVanilla/GuitarTool/main/guitartest.py"
    print(ver)
    newVerFileName = "temp." + str(ver) + ".py"
    ul.urlretrieve(url, newVerFileName)
    os.system("python \"" + newVerFileName + "\"")


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


def Chord_AlphaTest():
    ws.Beep(262, 300)
    ws.Beep(330, 300)
    ws.Beep(392, 300)
    exit()


print("Enter number to select.")
print("1. Fret Remember Test")
print("2. Chord (Alpha Test)")
modeSelect = int(input("Enter number: "))
while True:
    if modeSelect == 1:
        clr()
        FretRememberTest()
        break
    elif modeSelect == 2:
        clr()
        Chord_AlphaTest()
        break
    elif modeSelect == 0:
        exit()
    else:
        continue
