


# from collections import Counter

# print(Counter(['B','B','A','B','C','A','B','B','A','C']))

# print(Counter({'A':3, 'B': 5, 'C':2}))


#
#  # importing libraries
# import time
# import math
  
# # decorator to calculate duration
# # taken by any function.
# def calculate_time(func):
      
#     # added arguments inside the inner1,
#     # if function takes any arguments,
#     # can be added like this.
#     def inner1(*args, **kwargs):
  
#         # storing time before function execution
#         begin = time.time()
          
#         func(*args, **kwargs)
  
#         # storing time after function execution
#         end = time.time()
#         print("Total time taken in : ", func.__name__, end - begin)
  
#     return inner1
    
# # this can be added to any function present,
# # in this case to calculate a factorial
# @calculate_time
# def factorial(num):
  
#     # sleep 2 seconds because it takes very less time
#     # so that you can see the actual difference
#     time.sleep(2)
#     print(math.factorial(num))
  
# # calling the function.
# factorial(10)








# def decorate_message(fun):
  
#     # Nested function
#     def addWelcome(site_name):
#         return "Welcome to " + fun(site_name)
  
#     # Decorator returns a function
#     return addWelcome
  
# @decorate_message
# def site(site_name):
#     return site_name;
  
# Driver code
  
# This call is equivalent to call to
# decorate_message() with function
# site("GeeksforGeeks") as parameter
# print (site("GeeksforGeeks"))


# def n():
#     i =1
#     while True:
#         yield i*i
#         i += 1

# for num in n():
#     if num > 100:
#         break
#     print(num)
