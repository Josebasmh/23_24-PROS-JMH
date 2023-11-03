//actividad9fifocrea.c
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>


int main (void)
{
	int fp;
	int p, bytesleidos;
	char saludo[] = "Un saludo !!!!!\n", buffer [10];
	while (1) {
		fp = open ("FIFO2", 0);
		bytesleidos = read(fp, buffer, 1);
		printf("Obteniendo información..."); 
		while (bytesleidos != 0) {
			printf("%s", buffer);
			bytesleidos = read (fp, buffer, 1); // leo otro byte
	}
	close (fp);
}
return(0);
}