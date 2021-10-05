class fMemb:
    def __init__(self,mother,child,gender,partner=None):
        # super().__init__()
        self._mother = mother
        self._child = child
        self._gender = gender
        self._partner = partner

    def getMother(self):
        return self._mother

    def getChild(self):
        self._child

    def getGender(self):
        return self._gender

    def getPartner(self):
        return self._partner                
