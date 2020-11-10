import sys
import random as r
import urllib.request as ul

# Init Sys
args = sys.argv
flag_insideSet = 0
version = [0, 1, 0, 0, "rls"]
update()

# Update


def update():
    doUpdate(checkUpdate())


def checkUpdate():
    # Check
    print("Checking update, please wait.")
    url = "https://raw.githubusercontent.com/OzelotVanilla/GuitarTool/main/upd"
    upd = ul.urlopen(url).readlines()[1].decode("utf-8").split(".")
    print(upd)
    flag_needUpd = 0
    for x in upd:
        while upd[x] != "rls" and upd[x] != "alpha" and upd[x] != "beta":
            if upd[x] > version[x]:
                flag_needUpd = 1
    if flag_needUpd == 1:
        flag_doUpd = input("Need update. Input \"y\" to update.")
    if flag_doUpd == "y":
        return 1


def doUpdate(flag_doUpd):
    # Go to update
    if flag_doUpd == 1:
        print("Will go to update.")
    else:
        print("Do not need update.")


# Init Vars
scale = ["C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"]
string = 0
fret = 0
opens = scale[0]
move = 0

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
        continue
    elif answer == "exit":
        print("Not available exit function. Type \"exit()\" instead.")
        continue
    elif answer == "exit()":
        print()
        break
    else:
        print("The answer is: "+scale[move])
        continue
