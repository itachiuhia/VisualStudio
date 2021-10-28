
def BubbleSort(arr):

    for i in range(len(arr)):
        for j in range(len(arr)-i-1):
            # if i == j:
            #     continue
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp


arr = [12, 11, 13, 5, 6]
BubbleSort(arr)
for i in range(len(arr)):
    print ("% d" % arr[i])