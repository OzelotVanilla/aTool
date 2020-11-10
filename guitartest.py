import random as r
d = ["C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"]
while True:
    s = r.randint(1, 6)
    t = r.randint(0, 5)
    e = d[0]
    m = 0
    if s == 1:
        e = 4
    if s == 2:
        e = 11
    if s == 3:
        e = 7
    if s == 4:
        e = 2
    if s == 5:
        e = 9
    if s == 6:
        e = 4
    m += t+e
    if m >= 12:
        m -= 12
    if len(d[m]) != 1:
        print("Pass, because you ask me not to test the thing with \"#\"")
        continue
    print("String " + str(s) + " at " + str(t))
    i = input("Input your answer: ")
    if i == d[m]:
        print("OK!")
        continue
    elif i == "exit":
        print("Not available exit function. Type \"exit()\" instead.")
        continue
    elif i == "exit()":
        print()
        break
    else:
        print("The answer is: "+d[m])
        continue
