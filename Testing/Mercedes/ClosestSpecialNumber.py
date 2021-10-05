# Global Data
data = {
    1: [1],
    2: [],
    3: [122,212,221],
    4: [],
    5: [14444,22333,32233,41444,44441],
    6: [],
    7: [1666666,2255555, 3334444,4333444,5225555,6166666,6666661],
    8: [],
    9: [188888888,227777777,333666666,444455555,544445555,633366666,722777777,818888888,888888881],
    10: [1223334444,4122333444,4444333221],
    11: [2299999999,33388888888,44447777777,55555666666,65555566666,74444777777,83338888888,92299999999,99999999922],
    12: [122444455555]
}

def findExactValue(x,y,num):
    uniqueX = set(str(x))

    dict_x = {k : int(k) for k in uniqueX}

    l_x = list(str(x))
    d_num = str(num)
    
    if(int(d_num[0]) > int(l_x[0]) ):
        return y

    out_ = l_x[0] 
    
    for e in range(1, len(d_num)):
        for k in sorted(dict_x.keys()):
            if d_num[e] == k:
                out_ += k
                dict_x[k] -= 1

            elif int(d_num[e]) < int(k) :
                out_ += k
                for numkey in sorted(dict_x.keys()):
                    out_ += numkey*dict_x[numkey]

                return out_
            else:
                continue

            if dict_x[k] == 0:
                del dict_x[k]

        if len(out_) != e+1:
            return y
    return out_                    
     
def giveSplNumber(k, num):
    # print(k, num)
    if data[k] == []:
        giveSplNumber(k+1, num)
    else:
        numList = data[k]
        # print(numList)
        if numList[-1] < num:
            # print("this")
            return giveSplNumber(k+1, num)
        elif numList[0] > num:
            # print(numList[0])
            res= numList[0]
            print(res)
            return
            # return str(res)   
        else:
            # print("something")
            for i in range(1,len(numList)):
                if(numList[i-1] < num < numList[i] ):                    
                    ans = findExactValue(numList[i-1],numList[i],num)
                    print(ans)
                    return

def specialNumber(ele):    
    l = len(str(ele))
    giveSplNumber(l, ele)
    # print(k)
    # return k

n = 9
l = [23172]

for ele in l:

    # out_ = specialNumber(ele)
    specialNumber(ele)