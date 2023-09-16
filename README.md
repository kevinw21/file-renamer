Reference Documentation

### Reference Documentation
File Renamer

The problem: Creating smooth looking spotify canvas videos can be tricky. This program was created to help with that.
Let's assume you want about an 8 second video that smoothly loops at 24 fps (totalling about 190 frames). Rather than
play frames 1-190 and then 1-190 and then 190.....we aim to make it easy to achieve 1-90 then 89-2 then 1-90 then 89-2.
This will provide a 8 second that appears to never restart.

To do this we take a provided fir of images and create a dir of images in reverse order. Blender is an great tool for animation.
Now we can add frames 1-90 then 89-2, print or animation, hand it over to spotify and it will do the rest.

Note, that this program can reverse the order of any provided group of files.

Example request: provide the location of the folder + filetype

http://localhost:8080/fileRenamer/reverse?dir=/Users/kevs/Desktop/home&fileType=png

Your reverse folder will be created within the provided directory

todo
1. jar + dockerize
2. fix springfox
3. mas tests