// actividad10.c
// Joseba Martinez
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <signal.h>
pid_t pid_hijo,pid_padre;

void manejador (int signal){
	printf("Padre recibe señal...%d\n",signal);
}

int main (void){
	pid_padre = getpid();
	pid_hijo = fork();
	switch (pid_hijo)
	{
	case -1:
		printf("No se ha podido crear el proceso hijo\n");
		exit(-1);
		break;
	case 0:
		kill (pid_padre,SIGUSR1);
		sleep(1);
		kill (pid_padre,SIGUSR1);
		sleep(1);
		kill (pid_padre,SIGUSR1);
		sleep(1);
		kill(pid_padre,SIGKILL);
		break;		
	default:
		signal(SIGUSR1,manejador);
		while (1){
			sleep(2);
		}
		break;
	}
	return(0);	
}
