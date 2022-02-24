import string

def perming(str:string, prefix : string):

    if len(str) == 0:
        print(prefix)
    else:
        for i in range(len(str)):

            rem = str[0:i] + str[i+1]

            perming(rem, prefix+str[i])    



def perm(str: string):
    perming(str, "")




s = "ABC"

perm(s)