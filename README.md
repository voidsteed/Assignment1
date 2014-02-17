Assignment1
===========
CS 283
Assignment1
Yujun Liu

Created the simpleClient, simple server, MTServer and benchmarkClient

The benchmark client creates threads when it runs. Each thread will create a socket, send a string in lower case, and then receive a string in upper case from the server. Also, the server sends back the upcase string to client.

Outputs of the benchmark client testing:

It takes 7851 ms to run 1000 strings	with simpleServer.

It takes 884 ms to run 1000 strings with MTserver


Reasoning why the multithreaded server performs better

Because in a single thread server, it has to work on the clients’ input one by one. However, in a multithread server, it generates threads to work on the clients’ input parallelly, all threads happened simultaneously. They don't have to wait for each other to run.
