class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None 
        self.parent = None

def insert(tree, par, child):

    if( par in tree):
        parent_node = tree[par]
        child_node = node(child)
        if(parent_node.left == None):
            parent_node.left = child_node
        else :
            parent_node.right = child_node

        child_node.parent = parent_node    

        tree[child] = child_node
    else:
        parent_node = node(par)
        tree[par] = parent_node

        child_node = node(child)
        child_node.parent = parent_node

        parent_node.left = child_node
        tree[child] = child_node
def depth(tNode):
    if tNode is None:
        return 0
    else:
        lDepth = depth(tNode.left)
        rDepth = depth(tNode.right)

        if( lDepth > rDepth):
            return lDepth+1
        else:
            return rDepth+1      

def findDepth(tree):

    keys = tree.keys()
    root = (list(keys)[0])
    return depth(tree[root])

def removeParent(pNode, cNode):
    if(pNode.left == cNode):
        pNode.left = None
    else:
        pNode.right = None

def deleteNode(ver, tree):
    ver_node = tree[ver]
    if( ver_node.left == None and ver_node.right == None):
        parentNode  = ver_node.parent
        removeParent(parentNode, ver_node)
        nodeData= tree.pop(ver)
        return True

    return False    

def visit(tree, n):
    for v  in range(1, n+1):
        nD = tree[v]
        print(nD.data, "->", end= " ")
        if( nD.left is not None):
            c1 = nD.left
            print(c1.data," - ", end= " ")
        if( nD.right is not None):
            print(nD.right.data)  

        print()      


def max_depth(n , edges, w):

    tree_map = {}

    for i in range(n-1):
        p = edges[i][0]
        c = edges[i][1]

        insert(tree_map, p, c)

    w_dict = []

    for ind in range(len(w)):
        if w[ind]%2 == 0: 
            w_dict.append(ind+1)

    evenW = len(w_dict)
    again = True
    while again:
        again = False
        # k = []
        for ele in w_dict :
            confirm = deleteNode(ele, tree_map)
            if confirm:
                w_dict.remove(ele)
                again = True

   
    itemRemoved = evenW - len(w_dict)
    cLen = len(w) - itemRemoved

    depth = findDepth(tree_map) -1


    return([ cLen,depth])   


# n = int(input())
n=7
edges = [[1,2],[1,3],[2,4],[2,5],[3,6],[3,7]]
# edges = [list(map(int, input().split())) for i in range(n-1)]
# w = list(map(int, input().split()))
w = [1,3,8, 6, 4, 6,2]
out_ = max_depth(n, edges, w)
print(out_)