import math
from tkinter import *
 
widht = 600
heigth = 600

root = Tk()

c = Canvas(root, width=widht, height=heigth, bg="white")
c.pack()

r_big1 = 200
r_big2 = 200

ball = c.create_oval(widht/2-r_big1, heigth/2-r_big2, widht/2+r_big1, heigth/2+r_big2, fill='green')

r_small = 15

moving_ball = c.create_oval(widht/2-r_small/2, heigth/2 - r_big2 - r_small/2, widht/2+r_small/2, heigth/2 - r_big2 + r_small/2, fill='black')


fi = 0
fi2 = 0
frequency = 17
direction = -1
koef = 50
step = frequency*direction/50
step2 = direction*frequency**2/20

def change():
    global r_big1
    r_big1 = scale.get()

def change2():
    global r_big2
    r_big2 = scale2.get()

def changer_small():
    global r_small
    r_small = scaler_small.get()

def changekoef():
    global koef
    koef = scalekoef.get()

var = IntVar()
var1 = IntVar()
var2 = IntVar()
var3 = IntVar()

scale = Scale(root, orient = HORIZONTAL, variable = var, from_=10 , to=290, resolution = 10, label = "R1", )
scale2 = Scale(root, orient = HORIZONTAL, variable = var1, from_=10 , to=290, resolution = 10, label = "R2")
scaler_small = Scale(root, orient = HORIZONTAL, variable = var2, from_=10 , to=40, resolution = 1, label = "R-Small")
scalekoef = Scale(root, orient = HORIZONTAL, variable = var3, from_=1 , to=50, resolution = 1, label = "Отклонение")


scale.set(r_big1)
scale2.set(r_big2)
scaler_small.set(r_small)
scalekoef.set(koef)

label = Label(root)
label.pack()

def motion():
    global fi
    global koef
    global fi2
    global step
    global step2
    global direction

    change()
    scale.pack(side = LEFT)

    change2()
    scale2.pack(side = LEFT)

    changer_small()
    scaler_small.pack(side = LEFT)

    changekoef()
    scalekoef.pack(side = LEFT)

    xline = c.coords(moving_ball)[0]+r_small/2
    yline = c.coords(moving_ball)[1]+r_small/2

    c.coords(ball, widht/2-r_big1, heigth/2-r_big2, widht/2+r_big1, heigth/2+r_big2)
    fi2 += step2
    fi += step
    
    if koef == 50:
        x = widht/2 - (math.sin(math.radians(fi)) * r_big1)
        y = heigth/2 - (math.cos(math.radians(fi)) * r_big2)
    else:
        x = widht/2 - (math.sin(math.radians(fi)) * r_big1 * (math.sin(math.radians(fi2)) + koef)/(koef))
        y = heigth/2 - (math.cos(math.radians(fi)) * r_big2 * (math.sin(math.radians(fi2)) + koef)/(koef))

    c.coords(moving_ball, (x-r_small/2,y-r_small/2,x+r_small/2,y+r_small/2))

    c.create_line(xline, yline, c.coords(moving_ball)[2]-r_small/2, c.coords(moving_ball)[3]-r_small/2)

    if fi2 == 359:
        fi2 = 0

    if fi == 359:
        fi = 0

    root.after(10, motion)

motion()
root.mainloop()
