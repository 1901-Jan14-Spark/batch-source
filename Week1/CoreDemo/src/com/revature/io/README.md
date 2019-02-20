# File IO
- java.io package provide useful classes to perform input and output (I/O) in java

**InputStream**
- used to read data from a source

**OutputStream**
- used to write data to a destination

### ByteStream
- when we use a bytestream to read/write to a file, data is transfered by single bytes

> FileInputStream
> FileOutputStream

### CharacterStream
- while a bytestream represents a stream of data in the form of 8-bit bytes, character streams are used to perform input/output for characters
- includes encoding of characters (this must be specified with a bytestream)

> FileReader 
> FileWriter

### Buffering ByteStreams and CharacterStreams
- going by one byte or character at a time can be pretty costly, so we read/write in larger chunks using buffered streams

> BufferedInputStream / BufferedOutputStream -> buffered bytestreams
> BufferedReader / BufferedWriter -> buffered character streams

#### BufferedWriter
```java
FileWriter fw = new FileWriter("output.txt");
BufferedWriter bw = new BufferedWriter(fw);
// write or append to a file
```

#### BufferedReader 
```java
FileReader fr = new FileReader("input.txt");
BufferedReader br = new BufferedReader(fr);
// read a single character, or an entire line
```

# Serialization
- Serialization allows for objects to be written directly to streams
- we convert java objects to a bytestream which can then be written to a file
- "Serializable" is a marker interface (no methods) which indicates that the implementing class intends to be serialized
- serialization is a means for persistence; up until now we haven't seen java objects with a lifecycle longer than the lifecycle of our java program
- SerialVersionUID is used to define the version of a java object; it's used at runtime to assure that the serializer and the deserializer are compatible objects
- **transient** keyword indicates that a particular instance variable will not be serialized

> ObjectOutputStream
> ObjectInputStream

#### Serialization with ObjectOutputStream
```java
FileOutputStream f = new FileOutputStream("MySerializedFile.ser");
ObjectOutputStream o = new ObjectOutputStream(f);
// write object 
```

#### Deserialization with ObjectInputStream
```java 
FileInputStream f = new FileInputStream("MySerializedFile.ser");
ObjectInputStream o = new ObjectInputStream(f);
// read object 
```