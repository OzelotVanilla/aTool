import os
import urllib.request as ul

# Init functions


def update():
    doUpdate(checkUpdate("./program.py"))


def transVerListToInt(given_ver_list):
    for x in range(4):
        given_ver_list[x] = int(given_ver_list[x].rstrip())
    return given_ver_list


def checkProgramVersion(program_py):
    file = open(program_py)
    readingfile = file.readline()
    while readingfile:
        if readingfile[0:11] == "# Version: ":
            version = transVerListToInt(readingfile[11:].split("."))
            print("Find version " + str(version))
            break
        readingfile = file.readline()
    return version


def checkUpdate(program_py):
    # Check
    print("Checking update, please wait.")
    url = "https://raw.githubusercontent.com/OzelotVanilla/GuitarTool/main/upd"
    upd = ul.urlopen(url).readlines()[1].decode("utf-8")
    upd = upd.rstrip().split(".")
    for i in range(4):
        upd[i] = int(upd[i])
    print(upd)
    # Read the version of current program.py
    version = checkProgramVersion(program_py)
    # Check whether the current version is out of date
    flag_needUpd = 0
    for x in range(len(upd)):
        if upd[x] != "rls" and upd[x] != "alpha" and upd[x] != "beta" and upd[x] != "base":
            if upd[x] > version[x]:
                flag_needUpd = 1
    print(upd)
    if flag_needUpd == 1:
        flag_doUpd = input("Need update. Input \"y\" to update.")
    if flag_doUpd == "y":
        return 1


def doUpdate(flag_doUpd):
    # Go to update
    if flag_doUpd == 1:
        print("Will go to update.")
    else:
        print("No update is running!")


# Update
version = [0, 0, 0, 1, "base"]
update()
os.system("python.exe ./program.py")
