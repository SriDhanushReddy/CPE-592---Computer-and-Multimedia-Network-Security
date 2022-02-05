from numpy.core.arrayprint import printoptions
from ImageSteg import ImageSteg
from PIL import Image
import pandas as pd
import numpy as np


img = ImageSteg()
img.encrypt_text_in_image("images.jpg", "Kondapalli Sri Dhanush Reddy", "output/")

res = img.decrypt_text_in_image("output/images_encrypted.png")
print(res)