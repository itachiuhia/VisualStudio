class graph:
    def __init__(self,ver):
        # super().__init__()
        self.v = ver
        self.adj = [[] for i in range(v)]

    def addEdge(self, v, w):
        self.adj[v].append(w)
        
          

g = graph(7)