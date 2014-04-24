algo
====

### Algorithms course assignments 

(t14) Write a programm that reads multiple images from one big file. File can be found [here] (http://yann.lecun.com/exdb/mnist/train-images-idx3-ubyte.gz).
Example of data: 
```
[offset] [type]          [value]          [description]
         0000     32 bit integer  0x00000803(2051) magic number
         0004     32 bit integer  60000            number of images
         0008     32 bit integer  28               number of rows
         0012     32 bit integer  28               number of columns
         0016     unsigned byte   ??               pixel
         0017     unsigned byte   ??               pixel
         ........
         xxxx     unsigned byte   ??               pixel
         
         Pixels are organized row-wise. Pixel values are 0 to 255. 0 means background (white),
         255 means foreground (black).
```
