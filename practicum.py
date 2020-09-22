import math
from tkinter import *
 
root = Tk()
c = Canvas(root, width=600, height=600, bg="white")
c.pack()
 
ball = c.create_oval(100, 100, 500, 500, fill='green')

moving_ball = c.create_oval(485, 285, 515, 315, fill='black')

speed = 0
direction = 1

def motion():
    global speed
    global direction
    fi = 359 + speed*direction
    x = 300 + 200*math.cos(fi)
    y = 300 + 200*math.sin(fi)
    c.coords(moving_ball, (x-15,y-15,x+15,y+15))
    speed += 0.0078
    if fi == 0:
        speed = 0
    root.after(10, motion)



motion()
root.mainloop()