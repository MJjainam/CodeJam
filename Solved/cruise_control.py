#!/bin/bash/python3

# https://code.google.com/codejam/contest/8294486/dashboard
import os

T = int(input())
for t in range(T):
    D, N = list(map(int, input().split())) #Input the total distance
    # N = int(input()) #Input the total number of horses
    horses = [] #This will be list of 2 cell list. 

    #Stores the time taken by the horses to reach the destination
    for n in range(N):
        # k, s = int(input().split(" ")) #Position of the horse
        k, s = list(map(int, input().split()))
        # arr = list(map(int, input().split()))

        # s = int(input()) #Speed of the horse
        dist_left = D - k
        time_needed = dist_left / s
        horses.append(time_needed) 

    #Find the max time. 
    max_time = horses[0]
    for n in range(1, N):
        if (max_time < horses[n]):
            max_time = horses[n]

    #The main horse also takes max_time to reach the destination
    #So given the distance and speed, calculate the velocity
    speed = D / max_time

    print("Case #" +str(t+1) +": " +str(speed))



