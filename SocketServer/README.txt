Project: SocketServer

Description:
	Creates socket connection. The client creates a list of user-supplied integers
	and sends each number to the server. The server then sums the numbers together
	and sends the sum back to the client, which then displays the sum.
	
Files:
	Client: handles all client-side interactions and methods.
	Server: handles all server-side interactions and methods.

Execution:
	First run the file titled "Server", and then "Client".
	The client will ask the user to input a series of integers, entering each one.
	The user must press enter while the input is empty for the
		program to proceed.
	Next the program asks the user to enter the host name. If the
		client and server are both running on the same machine, the
		host name should be localhost.
	The program will run independently from here on.