import math
import time
from tkinter import *
 
widht = 600
heigth = 600

root = Tk()

c = Canvas(root, width=widht, height=heigth, bg="black")
c.pack()

r = 200

ball = c.create_oval(widht/2-r, heigth/2-r, widht/2+r, heigth/2+r, outline = "white")

fi = 0
frequency = 17
direction = -1
divided = 200
x_pr = widht/2 - r
y_pr = heigth/2
counter = 0
speed = 20
easy_numbers = [2,3,4,5,6,29,41,61,67,97,101,103,149,151,193,197,199,331]
en = easy_numbers.copy()
N = en.pop(0)

def change():
    global divided
    global counter
    global fi
    if divided != scale.get():
        divided = scale.get()
        counter = 0
        fi = 0
        c.delete("all")
        ball = c.create_oval(widht/2-r, heigth/2-r, widht/2+r, heigth/2+r, outline = "white")

def change2():
    global N
    global en
    global counter
    global fi
    if N != scale2.get():
        N = scale2.get()
        counter = 0
        fi = 0
        en = [i for i in easy_numbers if i > N]
        c.delete("all")
        ball = c.create_oval(widht/2-r, heigth/2-r, widht/2+r, heigth/2+r, outline = "white")

var = IntVar()
scale = Scale(root, orient = HORIZONTAL, variable = var, from_=1 , to=360, resolution = 1, label = "Деление окружности", length = widht/2)
scale.set(divided)

var2 = IntVar()
scale2 = Scale(root, orient = HORIZONTAL, variable = var2, from_=1 , to=360, resolution = 1, label = "N",length = widht/2)
scale2.set(N)

label = Label(root)
label.pack()

def motion():
    global fi
    global divided
    global x_pr
    global y_pr
    global N
    global counter
    global en

    change()
    scale.pack(side= LEFT)

    change2()
    scale2.pack(side= LEFT)

    step = 360/divided

    fi1 = (((fi) * N) % 360)

    x = (widht/2 - (math.cos(math.radians(fi1)) * r))
    y = (heigth/2 - (math.sin(math.radians(fi1)) * r))

    c.create_line(x_pr,y_pr,x,y,fill = "white")
    # print(x_pr, y_pr, x, y, fi, fi1)
    
    x_pr = widht/2 - (math.cos(math.radians(fi+step)) * r)
    y_pr = heigth/2 - (math.sin(math.radians(fi+step)) * r)

    fi += step

    counter += 1

    if fi == 360:
        fi = 0

    if counter == divided:
        if len(en) == 0:
            en = easy_numbers.copy()
        N = en.pop(0)
        counter = 0
        scale2.set(N)
        c.delete("all")
        ball = c.create_oval(widht/2-r, heigth/2-r, widht/2+r, heigth/2+r, outline = "white")
    
    root.after(speed, motion)
    time.sleep(2)

motion()
root.mainloop()
