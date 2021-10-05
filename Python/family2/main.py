import family2.members as members



class addfamilygraph:
    def __init__(self):
        # super().__init__()
        self.v = 1000
        self.ftree = [[] for i in range(v)]


    def addIntoFamilyTree(self, m, c):
        self.ftree[m].add(c)
        self.ftree[c].add(m)



if __name__ == "__main__":
    s = list()
    s = input().split()

    createFamily = addfamilygraph()


    member = members(s[0],s[1],[2],s[3])
    createFamily.addIntoFamilyTree()

