def addEdge(adj, v, w):
     
    adj[v].append(w)
     
    # Note: the graph is undirected
    adj[w].append(v) 
    return adj

def greedyColoring(adj, v):
    result = [-1]*v 
    result[0] = 0 

    avail = [False]*v

    for u in range(1, v):
        for i in adj[u]:
            if ( result[i] != -1):
                avail[result[i]] = True

        cr = 0
        while cr < v:
            if(avail[cr] == False):
                break

            cr += 1
        
        result[u] = cr

        for i in adj[u]:
            if result[i] != -1:
                avail[result[i]] = False

    for u in range(v):
        print(f'Vertext {u} ->>>> color {result[u]}')            

if __name__ == '__main__':
     
    g1 = [[] for i in range(5)]
    g1 = addEdge(g1, 0, 1)
    g1 = addEdge(g1, 0, 2)
    g1 = addEdge(g1, 1, 2)
    g1 = addEdge(g1, 1, 3)
    g1 = addEdge(g1, 2, 3)
    g1 = addEdge(g1, 3, 4)
    print("Coloring of graph 1 ")
    greedyColoring(g1, 5)