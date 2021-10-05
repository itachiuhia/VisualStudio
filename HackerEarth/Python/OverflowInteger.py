def nxtHighWithNumOfSetBits(x): 
    rightOne = 0
    nextHigherOneBit = 0
    rightOnesPattern = 0
  
    next = 0

    if (x): 
        rightOne = x & (-x) 
        nextHigherOneBit = x + rightOne 
  
        rightOnesPattern = x ^ nextHigherOneBit 
  
        rightOnesPattern = (rightOnesPattern) // rightOne 
  
        rightOnesPattern >>= 2
  
        next = nextHigherOneBit | rightOnesPattern 
  
    return next

def mthSmallestWithKSetBits(m, k): 

    num = (1 << k) - 1

    for i in range(1, m):
        num = nxtHighWithNumOfSetBits(num) 

    return num 
  
# Driver Code 
if __name__ == '__main__':
    m = 4
    k = 4
    print(mthSmallestWithKSetBits(m, k)) 


# def nxtHigh(x):
#     rightOne = 0
#     nextHighBit = 0
#     rightOnesPattern = 0

#     next = 0

#     if(x):
#         rightOne = x &(-x)
#         nextHighBit = x + rightOne
#         rightOnesPattern = x^nextHighBit
#         rightOnesPattern = (rightOnesPattern) // rightOne
#         rightOnesPattern >>= 2
#         next = nextHighBit | rightOnesPattern

#     return next    

# def mthStallest(m,k):
#     num = (1 << k) -1

#     for i in range(1,m):
#         num = nxtHigh(num)
    

# if __name__ == '__main__':
#     m = 6
#     k = 4
#     print(mthStallest(m,k))