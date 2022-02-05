
from Stegno import Stegno
from PIL import Image

img = Image.open(r'C:\Users\kdsri\PycharmProjects\592-Assignment_1-MSB\images.jpg').convert('L')
x = Stegno(img)
x.encode(img)
res = x.decode()
print(res)