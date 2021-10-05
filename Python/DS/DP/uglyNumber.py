def printuglyNo(n):
    uglyNo = [0]*n

    uglyNo[0] = 1
    i2 = i3 = i5 =0

    for k in range(1,n):

        uglyNo[k] = min(uglyNo[i2]*2,uglyNo[i3]*3,uglyNo[i5]*5)

        if(uglyNo[k] == uglyNo[i2]*2):
            i2 += 1
        if(uglyNo[k] == uglyNo[i3]*3):
            i3 += 1
        if(uglyNo[k] == uglyNo[i5]*5):
            i5 += 1   


    for i in uglyNo:
        print(i, end= "")             





if __name__ == "__main__":
    n = 15
    printuglyNo(n)