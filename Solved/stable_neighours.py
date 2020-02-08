#!/bin/bash/python3

#https://code.google.com/codejam/contest/8294486/dashboard#s=p1

'''
This problem is very simple logic wise, but has a lot of boundary conditions that you have to look for. This makes it difficult. 

In small case there are no boundary case 
But in large case, there are many. 
1. What if I have only one of primary color (R, B, Y) and only one of corresponding secondary color (G, O, V) 
Eg: R - 2, G - 2, rest all is zeo

2. What if I have one of the primary colors and one of corresponding seconday color equal to zero
Eg: R - 3, G - 2, B - 3, O - 2, V - 0, Y - 0

If you think there are more boundary conditions which others would have faced, but I did not cover, then please create a PR. 
'''

'''structure of the dict = {
    'color' : 'R', 'Y' or 'B'
    'num' : <any-number>
}'''

def solveSmall(color_list, total_colors):
    ret_string = ""
    color_list = sorted(color_list, key = lambda k: (k['num']), reverse=True)
    if (color_list[0]['num'] > color_list[1]['num'] + color_list[2]['num']):
        ret_string = "IMPOSSIBLE"
        return ret_string

    arr = [-1] * total_colors

    #First fill in alternative elements of array by the color which is highest
    for i in range(0, color_list[0]['num']):
        arr[i*2] = color_list[0]['color']


    #Then fill from the backwards alternative elements of array by color which is second highest
    i1 = total_colors - 1
    i2 = i1
    count = color_list[1]['num']

    while(count > 0):
        arr[i2] = color_list[1]['color']
        if count == 1:
            break
        while(arr[i2] != -1 or (i1 - i2) < 2 ):
            i2 -= 1
        count -= 1
        i1 = i2

    #Then fill the last color wherever -1 still remains. This strategy works!
    for i in range(total_colors):
        if(arr[i] == -1):
            arr[i] = color_list[2]['color']

    #Create string and return it
    for ele in arr:
        ret_string += ele
        
    return ret_string


        

def test(ret_string, N):
    if(ret_string != "IMPOSSIBLE"):
        if(ret_string[0] == ret_string[-1]):
            # a=0
            print("issue")
        if(len(ret_string) != N):
        #     # print()
        #     a = 0
            print('issue')
        for i in range(1, len(ret_string)):
            if(ret_string[i] == ret_string[i-1]):
                print('issue:' +str(i))


'''
This checks for all the conditions in large for boundary conditions
'''
def checkLarge(N, R, O, Y, G, B, V):
    ret_string = "UNKNOWN"
    if ( (R == G == V == Y == 0) and B == O):
        ret_string = "BO" * B
    elif ( (R == G == B == O == 0) and V == Y ):
        ret_string = "VY" * V
    elif( (B == O == V == Y == 0) and R == G):
        ret_string = "RG" * R
    elif( (R != 0 and G != 0 and R <= G ) or (V != 0 and Y != 0 and Y <= V) or ( B != 0 and O != 0 and B <= O)):
        ret_string = "IMPOSSIBLE"
    return ret_string        

def repl(ret_string, strA, strB, count):
    temp = ""
    for i in range(count):
        temp = temp + strA + strB
    temp = temp + strA

    return ret_string.replace(strA, temp, 1)






T = int(input())
for t in range(T):
    N, R, O, Y, G, B, V = list(map(int, input().split()))
    # D, N = list(map(int, input().split())) #Input the total distance
    # color_list[0]
    ret_string = checkLarge(N, R, O, Y, G, B, V)

    if (ret_string == "UNKNOWN"):
        color_list = []
        color_list.append({'color': 'R', 'num': R - G})
        color_list.append({'color': 'Y', 'num': Y - V}) 
        color_list.append({'color': 'B', 'num': B - O})
        total_colors = R - G + Y - V + B - O 
        ret_string = solveSmall(color_list, total_colors)
        if (ret_string != "IMPOSSIBLE"):
            ret_string = repl(ret_string, 'R', 'G', G)
            ret_string = repl(ret_string, 'B', 'O', O)
            ret_string = repl(ret_string, 'Y', 'V', V)
            test(ret_string, N)
    

    print("Case #" +str(t+1) +": " +ret_string)

