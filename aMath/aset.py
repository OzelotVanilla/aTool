# TODO: The Set in Python cannot contain Set (unhashable), however it should.

from aMath.amath import amath

global version
version = [0, 1, 0, 1, "alpha"]


def plainlist(obj):
    if isinstance(obj, aset):
        return obj.data
    elif type(obj) == type(set()):
        return list(obj)
    elif type(obj) == type(list()):
        return obj
    else:
        print("The object you want to operate on is not supported.")


def SameElementDeleted(listobj):
    ret = []
    [ret.append(x) for x in listobj if x not in ret]
    return ret


def StrIptToList(ipt):
    d = ipt.split(",")


class TestError(Exception):
    def __init__(self, *args):
        self.info = args
        self.reason = "You are tesing the TestError."


class aset(amath):
    """aMath Class aSet for set in math. Inherit from aMath.\n
    A set should contain every type of element.\n
    To create new set, please enter the elements to initialize.\n
    Please note that aSet is fit for math, do not add string or other non-math object into an aSet object.\n
    """
    data = ["Initialize failed aSet Object"]
    prop = "Initialize failed aSet Object"
    propDict = {-1: "Normal", 0: "Null", 1: "Natual", 1.1: "Positive Natual",
                2: "Zahlen (Integer)", 2.1: "Positive Zahlen (Interger)", 2.2: "Negative Zahlen (Interger)",
                3: "Quotient (Rational)", 3.1: "Positive Quotient (Rational)", 3.2: "Negative Quotient (Rational)",
                4: "Real", 4.1: "Positive Real", 4.2: "Negative Real",
                5: "Complex",
                "Initialize failed aSet Object": "Initialize failed"}
    propInput = {"N": 1, "n": 1, "N+": 1.1, "n+": 1.1,
                 "failtest": "Initialize failed aSet Object"}  # TODO: Add more!
    isconst = "Initialize failed aSet Object"

    def __init__(self, *element, prop=-1, isconst=False):
        self.data = []
        self.append(element)
        if type(prop) == type(int()):
            self.prop = prop
        elif type(prop) == type(str()):
            self.prop = self.propInput[prop]
        else:
            print("The property you inputed on is not supported.")
        self.isconst = bool(isconst)
        del element, prop, isconst

    def __str__(self):
        return "{" + str(self.data)[1:-1] + "}"

    def __repr__(self, showAddress=False):
        """aMath.aSet Class __repr__ Function\n
        bool showAddress: is false by default. If you want to see the address, please assign it true.
        """
        if bool(showAddress) == True:
            print("<PyMath aSet Object at " + str(hex(id(self.data))) + ">")
        return ("Const" if self.isconst == True else "") + "aSetObj: " + str(self)

    def __len__(self):
        return len(self.data)

    def __eq__(self, cmpableObj):
        ntcmp = [type(int()), type(float()), type(str())]
        return None if type(cmpableObj) in ntcmp else self.data == plainlist(cmpableObj)

    def __lt__(self, cmpableObj):
        if not isinstance(cmpableObj, aset):
            ntcmp = [type(int()), type(float()), type(str())]
            if type(cmpableObj) in ntcmp:
                return False
            else:
                print("The comparation between aSet Object and " + str(type(cmpableObj)) +
                      " type is not supported.")
                return None
        else:
            if len(self) == len(cmpableObj):
                for x in range(len(self)):
                    if self.data[x] < plainlist(cmpableObj)[x]:
                        return True
                    elif self.data[x] > plainlist(cmpableObj)[x]:
                        return False
                    else:
                        continue
            else:
                return True if len(self) < len(cmpableObj) else False

    def __gt__(self, cmpableObj):
        return not self.__lt__(cmpableObj)

    def __or__(self, setObj):
        return unioneda(self, setObj)

    def __and__(self, setObj):
        return itscteda(self, setObj)

    def __sub__(self, setObj):
        return moinseda(self, setObj)

    def __xor__(self, setObj):
        return difrceda(self, setObj)

    def append(self, *element, addWholeAsAset=False):  # TODO
        """aMath.aSet Class append Function\n
        bool addWhole: is false by default. If you want to add the
        """
        if len(element) == 0:
            self.prop = 0
        elif len(element) == 1:
            t1 = [type(tuple()), type(list()), type(set())]
            if type(element[0]) in t1:
                self.data = list(element[0])
            else:
                self.data = [element[0]]
        else:
            [self.data.append(x) for x in element]
        if addWholeAsAset == True:
            self.data.append(aset(element))
        self.data = sorted(SameElementDeleted(self.data))

    def show(self, showType=1, showData=1):
        """PyMath Class aSet's function.
        This function can show the detail of a aSet object.\n
        Please note that str() is used to contrete,
        to see the status of aSet object, please use show().
        """
        exc = [-1, 0]
        attr = " Number" if self.prop not in exc else ""
        isconst = "Const " if self.isconst == 1 else ""
        if showType == 1:
            print("Type: " + isconst + self.propDict[self.prop] + attr + " set.")
        if showData == 1:
            print("Data: " + str(self))

    def error(self):
        raise TestError("Error entered.")


def unioneda(setObjA, setObjB):
    return aset(SameElementDeleted(plainlist(setObjA) + plainlist(setObjB)))


def itscteda(setObjA, setObjB):
    ret = []
    [ret.append(x) for x in plainlist(setObjA) if x in plainlist(setObjB)]
    return aset(ret)


def moinseda(setObjA, setObjB):
    ret = []
    [ret.append(x) for x in plainlist(setObjA) if x not in plainlist(setObjB)]
    return aset(ret)


def difrceda(setObjA, setObjB):
    ret = []
    i = itscteda(setObjA, setObjB)
    [ret.append(x) for x in plainlist(setObjA) if x not in i.data]
    [ret.append(x) for x in plainlist(setObjB) if x not in i.data]
    del i
    return aset(ret)

# TODO: compare between asetObj and others
