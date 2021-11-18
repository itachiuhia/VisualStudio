



def mergeSort(arr, l, r):

    if r>l 


def printList(arr):
    for i in range(len(arr)):
        print(arr[i], end=" ")
    print()


if __name__ == '__main__':
    arr = [12, 11, 13, 5, 6, 7]
    print("Given array is", end="\n")
    printList(arr)
    mergeSort(arr, 0, len(arr))
    print("Sorted array is: ", end="\n")
    printList(arr)