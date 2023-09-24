// ejercicio5
// Joseba Martinez
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid;
    int status;

    // Primer Hijo
    if ((pid=fork())==-1){
        exit(-1);
    }else if (pid==0){
        printf("Soy el hijo %d, mi padre es %d \n",getpid(),getppid());

        // Segundo Hijo
        if (pid=fork()==0){
            printf("Soy el hijo %d, mi padre es %d \n",getpid(),getppid());

            // Tercer Hijo
            if (pid=fork()==0){
                printf("Soy el hijo %d, mi padre es %d \n",getpid(),getppid());
            }else{
                waitpid(pid,&status,0);    
            }
            
        }else{
            waitpid(pid,&status,0);
        }
    }else{
        waitpid(pid,&status,0);
        printf("Soy el padre %d \n",getpid());
    }
    exit(0);
}