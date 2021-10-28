Max = 256

def compare(arr1, arr2):
    for i in range(Max):
        if arr1[i] != arr2[i]:
            return False
    return True



def search(pat,txt):
    m = len(pat)
    n = len(txt)

    countp = [0]*Max
    count_tw = [0]*Max

    for i in range(m):
        (countp[ord(pat[i])]) += 1
        (count_tw[ord(pat[i])]) += 1

    for i in range(m, n):

        if compare(countp, count_tw):
            print("Found at index", (i-m))

        count_tw[ord(txt[i])] += 1
        count_tw[ord(txt[i-m])] -= 1

    if compare(countp, count_tw):
        print("Found at index",n-m)        



txt = "BACDGABCDA"
pat = "ABCD"      
search(pat, txt)  