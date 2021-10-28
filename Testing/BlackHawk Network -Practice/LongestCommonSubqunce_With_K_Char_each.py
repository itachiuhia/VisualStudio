def longestSubseqWithK(str, k):
    max_char = 26
    n = len(str)

    freq = [0]*max_char
    for i in range(n):
        freq[ord(str[i]) -ord('a')] += 1

    for i in range(n):
        if (freq[ord(str[i]) - ord('a')]) >=k:
            print(str[i], end="")    



if __name__ == "__main__":
     
    str = "geeksforgeeks"
    k = 2
    longestSubseqWithK(str, k)
    print()