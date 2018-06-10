#!/usr/bin/env python3

'''
SOLUTION DESCRIPTION:
    First we read the input file and save its context on a list that its elements
    is a list of the elements of each line.
    Then we are saving in an object the data, time (which is 0 initially)
    and the coordinates of the initial '+','-'.
    Then we add all those objects in a queue.
    After that we dequeue an object and make new objects with data same as
    the dequeued object, coordinates same with its neighbouring
    coordinates and with time = time + 1 and if an opposite sign exists
    in one of the neighbouring cells then the end of the world has came and
    we continue to dequeue the objects with time equal to that of the end of
    the world - 1.
'''
# TODO:
# 1.Find a better way of getting all the initial +,- and their indexes

from collections import deque


end = False
death = -1      # time of death of the universe


def solve(view):

    class cell:

        # object constructor
        def __init__(self, data, x, y, time):
            self.data = data
            self.x = x
            self.y = y
            self.time = time

    # this function takes a cell, a line and a column as arguemnts
    # then it proceeds with filling the neighbouring squares with the
    # appropriate values.

    def check_and_set(s, line, column):
        if(view[line][column] == '.'):
            view[line][column] = s.data
            ns = cell(s.data, line, column, s.time+1)
            Q.append(ns)
        elif((view[line][column] == '-' and s.data == '+') or (view[line][column] == '+' and s.data == '-')):
                view[line][column] = '*'
                global end, death
                end = True
                death = s.time+1

        # QUESTION: is there a more pythonic way of getting all the '+','-'
        # in the list of lists and finding the index of each one???
        # view =[ [...] ,...., ['+','.','X','-', '.','.'], ..., [...]]

#---------------------------START---------------------------------------------

    Q = deque()
    i = len(view)
    j = 0
    for k in range(i):
        j = len(view[k])
        for l in range(j):
            if(view[k][l] == '+' or view[k][l] == '-'):
                s = cell(view[k][l], k, l, 0)
                Q.append(s)

    # Now that the queue is made proceed as in description
    result = 'the world is saved'
    while Q:
        s = Q.popleft()
        if(s.time == death and end):
            break

        if (s.x-1 >= 0):
            check_and_set(s, s.x-1, s.y)
        if (s.x+1 < i):
            check_and_set(s, s.x+1, s.y)
        if (s.y-1 >= 0):
            check_and_set(s, s.x, s.y-1)
        if (s.y+1 < j):
            check_and_set(s, s.x, s.y+1)
    if(end):
            result = ''+str(death)
    print(result)
    for i in view:
        print("".join(i))
    return

if __name__ == "__main__":
        import sys
        # read file arguement and copy it in a list
        # containung the list of elements of each line
        # e.g. uni = [ ['',...,''], [...], ..., [...]]

        if len(sys.argv) != 2:
                print("".join(("<Usage>: python ", sys.argv[0], " argv[1] ")))
                sys.exit()
        else:
            try:
                with open(sys.argv[1], "rt") as f:
                    # list of strings of each line
                    unin = f.read().splitlines()
                    uni = []
                    for i in unin:
                        uni = uni + [list(i)]
                    solve(uni)
            except:
                print("Error while opening the file")
                raise
