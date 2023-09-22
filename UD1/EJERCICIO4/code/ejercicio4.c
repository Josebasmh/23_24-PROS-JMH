// ejercicio4
// Joseba Martinez
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{ 
    pid_t pid, pid2, pid3;
	int status1, status2, status3;
    
    // No se crea hijo 1
    if ((pid=fork())== -1){
	printf("No se ha podido crear el primer proceso hijo...");
	exit (-1);

	// Primer hijo
    } else if (pid == 0)   {
		printf ("Soy el hijo 1, mi PID es %d, El PID de mi padre es: %d.\n", getpid(), getppid());
	} else {

		// Segundo hijo
		if ((pid2 = fork()) == -1){
			printf("No se ha podido crear el primer proceso hijo...");
			exit (-1);
		} else if (pid2 == 0){
			printf ("Soy el hijo 2, mi PID es %d, El PID de mi padre es: %d.\n", getpid(), getppid());
		}else{

			// Tercer hijo
			if ((pid3 = fork()) == -1){
				printf("No se ha podido crear el primer proceso hijo...");
				exit (-1);
			}else if (pid3==0){
				printf ("Soy el hijo 3, mi PID es %d, El PID de mi padre es: %d.\n", getpid(), getppid());
			}else{

				// Padre: espera a que sus tres hijos termine
				waitpid(pid,&status1,0);
				waitpid(pid2,&status2,0);
				waitpid(pid3,&status3,0);
				printf ("Soy el proceso padre %d. \n", getpid());
			}
		}
	}
	exit(0);
}