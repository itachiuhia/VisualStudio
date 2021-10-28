def partition(array,start, end):
      
    # Initializing pivot's index to start
    pivot_index = start 
    pivot = array[pivot_index]
      
    # This loop runs till start pointer crosses 
    # end pointer, and when it does we swap the
    # pivot with element on end pointer
    while start < end:
          
        # Increment the start pointer till it finds an 
        # element greater than  pivot 
        while start < len(array) and array[start] <= pivot:
            start += 1
              
        # Decrement the end pointer till it finds an 
        # element less than pivot
        while array[end] > pivot:
            end -= 1
          
        # If start and end have not crossed each other, 
        # swap the numbers on start and end
        if(start < end):
            array[start], array[end] = array[end], array[start]
      
    # Swap pivot element with element on end pointer.
    # This puts pivot on its correct sorted place.
    array[end], array[pivot_index] = array[pivot_index], array[end]
     
    # Returning end pointer to divide the array into 2
    return end


def partition_end(arr, l, m):

    # if we choose last element as pivot
    pivot = arr[m]

    i = l-1

    for j in range(l, m):
        if arr[j] < pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i+1], arr[m] = arr[m], arr[i+1]

    return i+1        


def quick_sort(l, r, arr):
    if l< r:
        pivot = partition(arr,l, r)
        quick_sort(l ,pivot-1, arr)
        quick_sort(pivot+1, r, arr)




array = [ 10, 7, 8, 9, 1, 5 ]
quick_sort(0, len(array) - 1, array)
  
print(f'Sorted array: {array}')
