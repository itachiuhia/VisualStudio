
from concurrent.futures import ThreadPoolExecutor
res = []
def findMin(tpl:  tuple):
    p1,p2 = tpl
    x = abs(p1[0]- p2[0])
    y = abs(p1[1]-p2[1])
    minDist = min(x,y)
    res.append(minDist)

def threading(line, n):
    # executer = ThreadPoolExecutor()
    with ThreadPoolExecutor(max_workers=3) as exe:
        exe.map(findMin , ((line[i], line[j]) for i in range(n-1) for j in range(i+1, n)))

def printKth(res, k):
    res.sort()
    print(res[k-1])


n = 9
k= 20
line = [ [1,5],[1,8],[2,3],[4,1],[5,1],[5,9],[6,3],[6,8],[8,1]]

threading(line, n)

# print(len(res), res)
printKth(res, k)
# print(res)



















