# TPO

1 -  Non-blocking I/O – shared mapped file

Write simple two applications (it may be one application which operates in two modes) 
which communicate with each other by saving and reading data from a shared file 
mapped with into memory.
One of the application should save some data – e.g. two integer values. The other 
application should retrieve the data and perform some operation – e.g. adding the values 
read – and then print out the result to the console.
Reader and writer should run in a continuous mode – i.e. writer should attempt writing 
data to the shared file for specific number of iteration. On the other hand the reader 
should await for the date originated from the writer until it makes sense – writer is still 
working.
Writer must not overwrite data put previously by itself into the file until reader fetches 
previous data set (or a message) from the file.
Analogously reader must not re-read data which it has already read from the file. In 
other words reader should read particular data set (or a message) only once and wait for 
the next one in case it has not been overwritten by the origin (i.e. writer).
NOTE: Your solution should be based on non-blocking I/O implementation.

2 - Client/Server – custom protocol for echoing messages 
and adding values

Write a client/server solution which implements a simple (human-readable) protocol 
which supports two basic operations:
− echoing messages – the server echoes the message sent by the client;
− adding values of two operands and returning the result to the requestor (client).
NOTE: Your solution should be based on non-blocking I/O implementation.

3 - Web Applications – Introduction

Develop a simple Java™ servlet which adds two integer values passed by a user as 
parameters to a web form and prints the result below the mentioned form. The user of 
your application should be capable to pass parameters to the servlet either with GET or 
POST method – i.e. you could for instance put two different submit buttons for each of 
the HTTP method.
NOTE: make your servlet robust to invalid input – a user may provide parameter 
values which may not be parsed into integer.

4 - Web Applications – Model-View-Controller

Modify the architecture of the solution for assignment 3 so that it complies with the 
Model-View-Controller concept implementation for web application as discussed during 
lecture.