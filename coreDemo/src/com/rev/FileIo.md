#File IO
-java.io package provide useful classes to preform input and output

**InputStream**
used to read data to a destination

**OutputStream**
used to write data to a destination

## ByteStream
when we use a bytstream to read/write to a file, data is transfered by a single bytes

>FileInputStream
>FileOutputStream

## CharectorStream

>FileReader
>FileWriter
## Buffering ByteStreams and CharecterStreams
-going by one byte or charector at a time can be pretty costl, so we read/write in larger chauncks using buffered streams
>BufferedInputStream / BufferedOutputStream -> buffere bytestreams
>BufferedReader / BufferedWriter -> buffered charecter stream
#### BufferedWriter
 ```java
 FileWriter fw = new FileWriter("putput.txt");
 BufferedWriter bw = new BufferedWriter(fw);
 //write or append to file
 ```
 
#### BufferedReader
 ```java 
 FilesReader fr = new FileReader("input.txt");
 BufferedReader br = new BufferedReader(fr);
 //read a single charector or an entire line
 ```
 
# Serialization 
- Serialization allows for objects to be writtern direclty to streams 
- we convert java object to a bytestream which can then be written to a file 
-"Serializable" a maker interface (no methods) which indicates that the implementing class intends to be serialized
-serialization is a mean for persistence; up until now we havent seen java objects with a lifcylce longer than the lifecycle of or java program
- SerivalVersionID is used to define the version of a java object, it's used at runtime to assure that the serializer and the desiaralizer are compatible objects
-***Transient** keyword indicates that a particular instance variable will not be serialized 

>ObjectOutputStream 
>ObjectInputStream

## ObjectOutputStream
```java
FIleOutputStream f = new Fileoutputstream("Myserializedfile.ser");
Objectoutputstream o = new objectoutputstream(f);
```
### Deserialization with ObjectInputStream
```java 
fileInputstream f = new fileinputstreaam("Myserializedfile.ser");
objectinputstream o = new objectinputstream(f);
// read object 

 
 
 
 
 
 
 
 
 
 
 
 
 
 