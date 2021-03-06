
def merge(arr, l, m ,r):
    n1 = m-l+1
    n2= r-m
    L = []
    R =[]
    i = j = k =0
    while i < n1 :
        L[i] = arr[l+i]
        i += 1

    while j < n2:
        R[j] = arr[m+1+j]
        j += 1

    i =j = 0
    k = l

    while i< n1 and j< n2:
        if L[i] <= R[j]:
            arr[k] = L[i]   
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1  

    while i< n2:
        arr[k] = L[i]
        i += 1
        k += 1

    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1    


def mergeSort(arr, l, r):
    if r > l :
        m = l+ (int)((r-l)/2)
        print(m)
        print(f'lower Sort - {l}  and {m}')
        mergeSort(arr, l, m)
        mergeSort(arr, m+1, r)
        merge(arr, l, m ,r)

  
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
