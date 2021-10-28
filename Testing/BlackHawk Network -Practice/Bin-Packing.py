
def nextfit(weights, c):
    res = 0
    rem = c

    for k in range(len(weights)):
        if rem >= weights[k] :
            rem = rem - weights[k]
        else:
            res += 1
            rem = c - weights[k]
    return res


weight = [2, 5, 4, 7, 1, 3, 8]
c = 10
 
print("Number of bins required in Next Fit :",
                           nextfit(weight, c))