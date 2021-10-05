# class node:
#     def __init__(self, nodeNumber,value, pNode):
#         self.parent = pNode
#         self.listOfNode =list()
#         self.name = nodeNumber
#         self.val = value

#     def __init(self, value):
#         self.parent = 0 
#         self.val = value 
#         self.listOfNode = list() 
#         self.name = 1 

# def addNode(self,tree, nodeNumber,value, parent):
#     newNode = node(nodeNumber, value, parent)

#     pNode = tree[parent]
#     pNode.listOfNode.append(newNode)
#     newNode.parent = pNode
#     tree[nodeNumber] = newNode
    
def findSmallest(nodes, sNum):
    max_node = max(nodes)
    for i in range(sNum+1,max_node):
        if i not in nodes:
            return i

    return max_node+1

def addNode(tree,nodeNum, val, parent, out):
    print('inputs:', nodeNum, val, parent, tree)
    nodeList = tree[parent]
    nl_2 = nodeList.copy()
    nl_2.append(val)
    print(f'{nodeNum} : {nl_2}')
    tree[nodeNum] = nl_2

    if(out[parent] != val):
        toAppend = out[parent]
        out[nodeNum] = toAppend
    else:
        smallest = findSmallest(nl_2, val)
        out[nodeNum] = smallest    

    # if( out[parent-1] != val):
    #     toAppend = out[parent-1]
    #     out.append(toAppend)
    # else:
    #     smallest = findSmallest(nodeList, val)
    #     out.append(smallest)   


def solve(n, val, parent):

    tree = {}

    tree[1] = [val[0]]

    out = {}

    k = 0
    if( val[0] == 1):
        k = 2
    else:
        k = 1
    # out.append(k)
    out[1] = k

    for i in range(2, n+1):
        addNode(tree, i, val[i-1], parent[i-2], out)

    return out.values()


# T = int(input())
# for _ in range(T):
# N = int(input())
# val = list(map(int, input().split()))
# parent = list(map(int, input().split()))

N = 4
val = [1,3,2,8]
parent= [1,2,2]
out_ = solve(N, val, parent)
print (' '.join(map(str, out_)))  

50
14
1 2
1 13
12 9
10 14
8 5
2 4
14 7
13 11
3 1
14 6
10 3
14 12
8 13
13
10 1
7 6
4 1
1 2
12 4
1 3
13 7
1 11
9 1
1 8
7 1
5 1
18
6 10
8 12
2 3
9 13
14 16
12 18
15 17
7 16
8 17
8 16
3 13
5 18
4 6
2 7
14 6
11 7
1 5
20
13 20
10 15
6 19
7 1
17 2
1 13
5 16
4 13
14 9
16 6
14 1
1 10
11 13
6 1
14 8
1 2
18 1
1 3
1 12
16
14 12
13 7
9 10
1 8
8 16
1 15
1 11
3 1
4 9
6 1
14 1
7 14
2 1
9 1
5 1
14
5 14
13 12
3 6
4 9
14 4
10 11
10 9
7 8
6 2
11 8
3 7
5 1
13 3
13
12 6
6 5
7 6
3 11
11 13
8 9
4 8
7 10
2 9
13 10
3 1
2 12
18
1 18
14 6
15 9
11 14
7 5
4 11
7 9
6 8
16 2
3 15
2 13
13 9
13 12
10 18
4 18
4 17
8 2
14
13 4
7 14
5 4
13 1
8 6
12 8
4 8
2 11
3 6
10 11
8 14
10 12
13 9
15
9 3
7 12
10 3
15 8
6 3
3 1
11 3
8 1
14 13
13 1
4 1
1 5
1 7
2 5
16
16 13
5 4
15 4
1 4
1 10
12 9
4 2
11 1
8 1
4 3
14 1
6 1
1 7
13 1
1 9
16
6 14
1 16
14 8
13 15
4 3
10 6
12 5
7 16
11 4
9 2
13 12
2 8
7 5
15 11
4 10
19
18 17
17 5
11 16
3 7
16 12
19 10
9 15
9 2
15 7
2 8
4 19
8 14
11 5
2 6
16 13
3 1
19 11
6 4
18
8 1
2 4
13 9
17 1
13 11
1 5
1 12
1 16
3 7
6 1
13 1
4 1
7 15
7 1
18 11
10 4
1 14
13
1 11
13 1
1 5
12 8
10 12
2 1
6 7
7 4
1 12
1 9
1 3
7 1
19
4 17
7 2
8 12
11 1
12 16
6 14
2 18
12 13
15 13
6 19
6 3
5 17
7 3
17 7
9 13
10 16
18 13
11 10
18
14 7
12 11
4 8
1 9
3 18
17 15
3 2
1 7
14 5
11 9
4 3
10 3
13 1
1 3
9 16
6 14
3 15
18
1 18
14 2
18 5
4 13
18 17
8 2
10 4
6 17
9 18
14 12
15 12
17 2
10 11
3 7
8 10
9 7
16 10
18
2 8
17 1
8 9
4 6
6 11
10 3
10 15
6 15
14 4
10 16
5 16
18 17
6 13
12 8
5 18
4 2
7 9
11
5 1
9 1
6 7
1 6
6 2
1 4
9 11
8 10
10 9
3 5
10
8 1
2 8
7 1
1 5
5 3
1 9
10 5
6 1
8 4
20
2 7
19 9
13 8
13 11
16 19
9 6
18 16
14 7
6 12
20 15
3 4
5 17
10 20
17 6
8 4
7 8
18 15
14 5
1 10
10
8 5
5 9
3 10
4 1
8 4
7 1
10 9
2 9
6 1
20
11 6
4 7
9 3
20 12
18 15
1 9
1 7
15 13
3 8
2 8
11 14
15 3
10 17
10 14
7 16
5 20
1 17
4 5
19 15
15
6 1
15 3
14 6
8 4
1 13
9 1
5 11
1 4
14 10
11 1
1 7
1 15
9 12
2 6
12
10 2
3 2
11 10
8 12
3 1
9 12
6 8
9 5
8 4
7 9
11 7
12
1 4
10 11
8 1
5 1
12 11
11 1
6 5
2 10
9 2
7 5
11 3
14
3 8
2 13
8 7
14 13
10 7
11 5
6 3
4 1
12 3
11 12
4 5
3 9
10 2
10
1 8
6 4
7 4
1 6
5 8
3 4
8 10
2 4
8 9
11
1 5
8 5
7 11
6 7
2 7
3 9
6 9
4 9
11 8
10 9
10
1 2
10 9
5 8
9 7
6 5
10 8
3 8
7 2
4 5
13
7 4
7 8
2 1
13 6
7 1
6 1
1 5
12 1
1 3
7 9
11 6
6 10
11
4 9
3 10
2 9
5 3
8 7
10 7
6 10
11 2
6 1
7 9
13
7 3
1 2
3 5
1 11
13 12
13 3
1 3
8 3
4 6
6 9
6 3
10 1
10
3 8
2 6
4 1
1 2
10 1
3 1
1 5
1 9
7 3
13
10 13
11 2
6 5
2 4
2 5
11 12
1 10
13 3
3 12
7 8
12 7
11 9
14
1 10
11 1
2 1
14 8
14 6
7 14
1 14
12 14
5 1
12 3
9 8
1 4
2 13
19
13 12
15 1
8 13
4 1
4 9
19 7
16 13
1 10
13 14
19 13
13 1
6 1
1 5
6 2
18 14
17 13
1 3
11 13
10
7 1
5 1
7 3
7 2
10 1
8 1
6 4
4 7
9 5
18
11 10
4 16
12 13
14 10
17 9
8 6
17 3
2 18
1 15
5 8
18 8
18 12
2 3
16 5
2 15
7 1
10 3
10
1 10
9 10
1 2
3 5
6 4
1 7
1 8
5 1
4 1
14
14 9
13 10
4 8
7 1
13 7
12 9
8 14
2 9
4 6
12 5
12 10
3 2
10 11
15
6 12
4 11
12 9
11 6
5 4
14 2
13 3
2 9
13 1
7 15
15 4
10 7
8 10
2 3
17
5 16
1 10
2 8
1 14
1 15
4 3
17 1
9 17
5 12
11 14
7 10
2 6
6 13
8 1
4 8
15 5
15
3 1
2 4
12 14
4 8
3 10
14 13
4 7
11 2
9 5
15 9
6 5
14 6
7 13
10 15
14
9 3
2 5
8 7
11 4
1 13
14 5
11 8
3 4
14 9
8 6
14 10
7 12
13 8
17
14 17
14 1
7 4
1 5
1 8
6 16
8 11
6 13
10 1
6 7
9 7
15 1
7 1
1 12
3 1
2 14
17
1 6
14 13
10 6
8 1
1 16
8 3
1 15
4 10
13 10
5 6
1 7
9 12
17 6
10 11
2 12
12 1
12
8 6
9 2
4 9
5 10
10 6
11 9
5 1
7 3
10 11
3 9
12 8
13
5 7
5 3
4 11
8 12
7 11
6 5
9 1
13 6
4 2
10 12
9 2
3 8