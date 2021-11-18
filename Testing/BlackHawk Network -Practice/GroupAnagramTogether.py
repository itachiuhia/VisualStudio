from collections import defaultdict

def printAnagramTogether(words):
    groupWords = defaultdict(list)

    for word in words:
        groupWords["".join(sorted(word))].append(word)

    for group in groupWords.values():
        print(" ".join(group))    


if __name__ == '__main__':
    arr = ["cat", "dog", "tac", "god", "act"] 
    printAnagramTogether(arr)