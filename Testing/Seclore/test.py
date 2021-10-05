import os.path
from os import path
import re



from math import floor, log


# arr = [8,25,4,30,2,8,32,32,28]
# K = 88
list = []
arr = [5,7,1]
K = 1

m = max(arr)


def getCoundDp(arr):
    arr.sort()
    maxVal = arr[-1]
    maxXor = 2**(floor(log((maxVal), 2)) + 1)
    dp = [[0 for i in range(maxXor+1)] for a in arr]
    dp[0][0] = 1
    # in the 1st row, mark the arr[0] to have count 1
    dp[0][arr[0]] = 1
    
    for row in range(1, len(arr)):
        for col in range(maxXor):
            if(row == 1):
                print(row, col)
                if(col^K == 0):
                    list.append(col)
            dp[row][col] += dp[row-1][col] 
            neededXor = col ^ arr[row]
            dp[row][col] += dp[row-1][neededXor]
    # return sum(dp[-1][:k])
    return (dp,maxXor)


# print(getCoundDp(arr, K))
print(list)
dp, maxXor  = getCoundDp(arr)

list = []
s = 0
for i in range(0,maxXor+1):

    if( i&K == 0):
        s += (dp[-1][i])
        # list.append(i)

    

print(s)








# s = "11 degree temp in 23"
# numbers = sum(s.isdigit() for i in s)
# print(numbers)

# print(len(re.sub("[^0-9]", "", s))
# item = []
# myList = []

# for i in myList:
#     if isinstance(i,int):
#         if( i%3 == 0 and i%5 == 0):
#             item.append(-3)
#         elif (i%5) :
#             item.append(-2)
#         elif (i%3):
#             item.append(-1)
#         else:
#             item.append(i)

#     return item




# def fun(d, fname):
#     filePath = d+"/"+fname
#     confirm = path.isdir(filePath)
#     if confirm:
#         print(True)
#     else:
#         print(False) 

# fun('/etc', 'xdg')




















# def cycle(i):
#     sample = []
#     for element in i:
#         yield element
#         sample.append(element)
#         # print(sample)
#     while sample:
#         for element in sample:
#             yield element

# a = cycle({10,-3,70,27, 'ABC'})
# for n in a:
#     print(n, end=" ")
#     break




# from typing import List

# class Contactdata:
#     def __init__(self):
#         self.name: str = None
#         self.birth_date: str = None
#         self.phone_number: List[str] = []
#         self.last_update_time: int = 0


# def read_console_input() -> List[ContactData]:
#     contact_input_list = []
#     no_of_contacts = int(input())
#     for i in range(no_of_contacts):
#         contact = Contactdata()
#         contact.name = input()

#         birth_date_output = input()
#         contact.birth_date = birth_date_output \
#             if birth_date_output != "empty" else ""

#         num_of_phones = int(input())
#         phone_number_input = input()

#         if num_of_phones > 0:
#             phone_number_input = phone_number_input.split(" ")
#             for phone in phone_number_input:
#                 contact.phone_number.append(phone if phone != "empty" else "")


#         contact.last_update_time = int(input())
#         contact_input_list.append(contact)

#     return contact_input_list


# def print_output_to_console(merged_contact: List[Contactdata]):
#     merged_contact.sort(key = lambda x : x.name)
#     for contact_data in merged_contact:
#         print(contact_data.name)
#         print(contact_data.birth_date if contact_data.birth_date !="" else "empty")

#         phone_number_output = ""
#         if contact_data.phone_number:
#             contact_data.phone_number.sort()

#         for phone in contact_data.phone_number:
#             phone_number_output = phone_number_output + \
#                 (phone if phone != "" else "empty") + " "

#         if phone_number_output:
#             phone_number_output = phone_number_output[:-1]

#         print(contact_data.last_update_time)

# contact_input: List['Contactdata'] = read_console_input()

# merged_contact: List['Contactdata'] = []

# def mergetContact(contact_input: List[Contactdata]):
    
#     pass

# print_output_to_console(merged_contact)

