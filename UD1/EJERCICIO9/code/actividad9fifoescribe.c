//actividad9fifoescribe.c
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>


int main (void)
{
	int fp;
	int p, bytesleidos;
	char saludo[] = "Un saludo !!!!!\n";
	p=mknod("FIFO2", __S_IFIFO|0666, 0); /// permiso de lectura y escritura
	fp = open ("FIFO2", 1); /// abrimos fifo con permiso de escritura
	
	if (fp == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}
	printf("Mandando información al FIFO...\n");
	write (fp, saludo, sizeof(saludo)); 	
	close (fp);
	return(0);
}