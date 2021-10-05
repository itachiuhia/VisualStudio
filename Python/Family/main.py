import json
import csv


fName = "fMembers.csv"
class family():
    def __init__(self,fileName):
        
        self.csvFile = fileName
        self.feedIntoJson(self.csvFile)

    def feedIntoJson(self,csvFile):
        # jsonFile = json.loads('members.json')
        # fM = open("members.json",'a')
        # fM.write(",\n")
        # fM.close()
        line_count =0
        with open(file=csvFile) as csvFile:
            csv_reader = csv.reader(csvFile, delimiter=",")
            for row in csv_reader:
                if line_count == 0:
                    line_count += 1
                    pass
                else:
                   # jsonFile = (members.json)
                    data = {                        
                        "members" : {
                            "name" : row[1] ,
                            "motherName" :row[0],
                            "gender" : row[2],
                            "parther" : row[3]
                            }
                         }
                    

                    # data = '{\n' + row[0]," : {" + "name :"+ row[0],  
                    # '\n},\n'+ '}'
                    
                    # with open('members.json','a+') as jFile:
                    #     # lines = jFile.read().splitlines()

                    #     # print(lines)
                    #     # print(len(lines))
                    #     # last_line = lines[2]
                    #     # print(last_line)
                    #     jFile.write(",\n")

                    #     json.dump(data, jFile, indent=2)

                    # with open("members.json",'r') as f:
                    #     lines = f.read().splitlines()
                    #     # print(lines)
                    #     # print(len(lines))
                    #     print(lines[-2:-1])


            fComma = open('members.json', 'r')  
            fComma.close() 

    # def getfamilyMembers(self):
    #     data = None
    #     with open("members.json", 'r') as toRead:
    #         data = json.load(toRead)

    #     print(data)   

def mains():
    # with open(fName) as csvFile:
    #     csv_reader = csv.reader(csvFile, delimiter=',')
    #     for row in csv_reader:
    #         if l
    #         # print(f'\t{row[0]} works in the {row[1]} department, and was born in {row[2]}.')
    res = family(fName)
    # res.getfamilyMembers()

    return 0

if __name__ == "__main__":
    print("help")
    mains()

# with open(file=fName) as csvFile:
#     csv_reader = csv.reader(csvFile,delimiter=',')
#     for row in csv_reader:
#         print(row[0])

 