public class Image {
    pixels[][]
    public Pixel getPixel(int x, int y){
        return pixels[x][y];
    }
    public void verticalFlip(){
    }
    public void horizontalFlip(){
    }
    public void resize(){
        // resize image by scale
    }
    abstract save();
    abstract load();
}

public class PNG extends Image{
    save(){ \\ override }
    load(){ \\ override }
}

public class JPG extends Image{
    save(){ \\ override }
    load(){ \\ override }
}
public class BTTMAP extends Image{
    save(){ \\ override }
    load(){ \\ override }
}

public class Drawablw extends Image{
    save(){ throw exeption }
    load(){ throw exeption }
}


// From Client code
Image image = new Drawablw();
image.load();
// this will give, exception. Currently client is not ready for handling exception. It will create big problem.


// if we change a little bit like below
public class FileImage extends Image{
    save(){ \\ override }
    load(){ \\ override }
}
 // then we need to change all of the class that extends Image to extends FileImage
 public class JPG extends FileImage{
     save(){ \\ override }
     load(){ \\ override }
 }
public class BTTMAP extends FileImage{
    save(){ \\ override }
    load(){ \\ override }
}

public class Drawablw {

}

// and client also needs to change FileImage every where it uses Image
// From Client code
FileImage image = new Drawablw();
image.load();


// So new requirement/changes makes it hard to maintain. It does not gives flexibility.
1. Exception occur / new exception handling method needed
2. new requirement require lots of changes to make it works

that's why we should avoid inheritance.
We should use composition + interface over inheritance