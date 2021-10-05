def findSol(mailId):

    if(mailId.find("@")<0):
        print("Invalid Input")
        return 0
        
    text = mailId.split("@")
    res = ""

    firstPart = len(text[0]) 
    if(firstPart == 0):
        print("Invalid Input")
        return
    elif(firstPart < 6):
        res = "*"*firstPart
    else: 
        s = mailId[:3]
        res = s+"*"*(firstPart-3)

    print(res+"@"+text[1])



t = input()

findSol(t)